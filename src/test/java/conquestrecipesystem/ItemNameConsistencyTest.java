package conquestrecipesystem;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Adding an item means writing the same name into three unrelated places: the recipe registration in
 * {@code RecipeService}, the lookup branch in {@code ItemStackService}, and the {@code CRAFTABLE_ITEMS}
 * array in {@code ListItemsCommand}. Nothing makes the three agree at compile time, and two shipped bugs
 * came from them disagreeing — an item that could be crafted but that {@code /cr get} refused to produce,
 * and a printed list that omitted 45 items while naming 15 that do not exist. Both were found by reading.
 *
 * This test reads the sources and asserts that all three still name exactly the classes present in
 * {@code conquestrecipesystem.objects}, so that the next divergence fails the build rather than a server.
 * It is the interim guard described in issue #64; the registry that would remove the duplication outright
 * is still to come.
 */
public class ItemNameConsistencyTest {

    private static final Path SOURCE_ROOT = Paths.get("src", "main", "java", "conquestrecipesystem");

    /** {@code new SteelLongsword(conquestRecipes)}, the shape every registration in RecipeService takes. */
    private static final Pattern RECIPE_REGISTRATION = Pattern.compile("new (\\w+)\\(conquestRecipes\\)");

    /** {@code itemName.equalsIgnoreCase("SteelLongsword")}, the shape every lookup branch takes. */
    private static final Pattern LOOKUP_BRANCH = Pattern.compile("itemName\\.equalsIgnoreCase\\(\"(\\w+)\"\\)");

    private static final Pattern CRAFTABLE_ITEMS_ARRAY = Pattern.compile("CRAFTABLE_ITEMS = \\{(.*?)};", Pattern.DOTALL);

    private static final Pattern STRING_LITERAL = Pattern.compile("\"(\\w+)\"");

    @Test
    public void everyItemClassHasARegisteredRecipe() {
        assertEquals(itemClassNames(), registeredRecipeNames(),
                "RecipeService.registerRecipes() should register exactly the classes in conquestrecipesystem.objects");
    }

    @Test
    public void everyItemClassCanBeLookedUpByName() {
        assertEquals(itemClassNames(), lookupNames(),
                "ItemStackService.getItemStack(String, int) should accept exactly the classes in conquestrecipesystem.objects");
    }

    @Test
    public void everyItemClassIsListedByTheListCommand() {
        assertEquals(itemClassNames(), listedNames(),
                "ListItemsCommand.CRAFTABLE_ITEMS should name exactly the classes in conquestrecipesystem.objects");
    }

    private Set<String> itemClassNames() {
        Path objects = SOURCE_ROOT.resolve("objects");
        assertTrue(Files.isDirectory(objects),
                "expected the item classes at " + objects.toAbsolutePath() + "; tests are run from the project root");

        try (Stream<Path> files = Files.list(objects)) {
            Set<String> names = files
                    .map(file -> file.getFileName().toString())
                    .filter(fileName -> fileName.endsWith(".java"))
                    .map(fileName -> fileName.substring(0, fileName.length() - ".java".length()))
                    .collect(Collectors.toCollection(TreeSet::new));
            assertTrue(!names.isEmpty(), "no item classes were found in " + objects.toAbsolutePath());
            return names;
        }
        catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    private Set<String> registeredRecipeNames() {
        return namesMatching(RECIPE_REGISTRATION, read("services/RecipeService.java"), "recipe registrations");
    }

    private Set<String> lookupNames() {
        return namesMatching(LOOKUP_BRANCH, read("services/ItemStackService.java"), "lookup branches");
    }

    private Set<String> listedNames() {
        String source = read("commands/ListItemsCommand.java");
        Matcher array = CRAFTABLE_ITEMS_ARRAY.matcher(source);
        assertTrue(array.find(), "the CRAFTABLE_ITEMS array could not be found in ListItemsCommand");
        return namesMatching(STRING_LITERAL, array.group(1), "CRAFTABLE_ITEMS entries");
    }

    /**
     * Collects every capture of {@code pattern}. An empty result means the source no longer has the shape
     * this test reads rather than that the item set is empty, so it is reported as such instead of being
     * compared as a set and blamed on the item that happens to sort first.
     */
    private Set<String> namesMatching(Pattern pattern, String source, String description) {
        Set<String> names = new TreeSet<>();
        Matcher matcher = pattern.matcher(source);
        while (matcher.find()) {
            names.add(matcher.group(1));
        }
        assertTrue(!names.isEmpty(),
                "no " + description + " were recognised; this test reads the source with " + pattern.pattern()
                        + " and needs updating if that shape has changed");
        return names;
    }

    private String read(String relativePath) {
        Path file = SOURCE_ROOT.resolve(relativePath);
        try {
            return new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        }
        catch (IOException exception) {
            throw new UncheckedIOException("could not read " + file.toAbsolutePath(), exception);
        }
    }

}
