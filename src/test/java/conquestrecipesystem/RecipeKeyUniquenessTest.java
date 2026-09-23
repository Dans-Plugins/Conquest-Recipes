package conquestrecipesystem;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Every item class builds its recipe key from a string literal copied by hand from a neighbouring class.
 * Two of those copies were never edited: {@code BronzeGreatsword} registered under the Bronze Katar's key
 * and {@code FeatherHeaddress} under the Jaguar Helmet's. Older servers logged the second registration and
 * ignored it, which silently made one recipe of each pair uncraftable; current Spigot throws instead, and
 * the exception escapes {@code onEnable}, so the plugin never enables at all (issue #83).
 *
 * This test reads the sources and asserts that every class in {@code conquestrecipesystem.objects} declares
 * a recipe key and that no key is declared twice.
 */
public class RecipeKeyUniquenessTest {

    private static final Path OBJECTS = Paths.get("src", "main", "java", "conquestrecipesystem", "objects");

    /** {@code new NamespacedKey(conquestRecipes, "conquest_recipes_steel_longsword")}, the shape every key takes. */
    private static final Pattern RECIPE_KEY = Pattern.compile("new NamespacedKey\\(conquestRecipes, \"(\\w+)\"\\)");

    /**
     * An empty result would mean the source no longer has the shape {@link #RECIPE_KEY} reads, in which case
     * the uniqueness check below would pass vacuously.
     */
    @Test
    public void everyItemClassDeclaresARecipeKey() {
        Set<String> withoutKey = recipeKeysByClass().entrySet().stream()
                .filter(entry -> entry.getValue().isEmpty())
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(TreeSet::new));
        assertTrue(withoutKey.isEmpty(),
                "no recipe key matching " + RECIPE_KEY.pattern() + " was found in " + withoutKey);
    }

    /** Some items have several recipes, each with its own key; no key may appear twice, in one class or two. */
    @Test
    public void noRecipeKeyIsDeclaredTwice() {
        Map<String, List<String>> classesByKey = new TreeMap<>();
        recipeKeysByClass().forEach((className, keys) ->
                keys.forEach(key -> classesByKey.computeIfAbsent(key, k -> new ArrayList<>()).add(className)));

        Map<String, List<String>> duplicated = classesByKey.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, TreeMap::new));
        assertEquals(new TreeMap<String, List<String>>(), duplicated,
                "each recipe key may be registered once; Spigot refuses a duplicate and the plugin fails to enable");
    }

    private Map<String, List<String>> recipeKeysByClass() {
        assertTrue(Files.isDirectory(OBJECTS),
                "expected the item classes at " + OBJECTS.toAbsolutePath() + "; tests are run from the project root");

        try (Stream<Path> files = Files.list(OBJECTS)) {
            Map<String, List<String>> keysByClass = files
                    .filter(file -> file.getFileName().toString().endsWith(".java"))
                    .collect(Collectors.toMap(
                            file -> file.getFileName().toString().replaceFirst("\\.java$", ""),
                            this::recipeKeysIn,
                            (a, b) -> a,
                            TreeMap::new));
            assertFalse(keysByClass.isEmpty(), "no item classes were found in " + OBJECTS.toAbsolutePath());
            return keysByClass;
        }
        catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

    private List<String> recipeKeysIn(Path file) {
        String source;
        try {
            source = new String(Files.readAllBytes(file), StandardCharsets.UTF_8);
        }
        catch (IOException exception) {
            throw new UncheckedIOException("could not read " + file.toAbsolutePath(), exception);
        }
        Matcher matcher = RECIPE_KEY.matcher(source);
        List<String> keys = new ArrayList<>();
        while (matcher.find()) {
            keys.add(matcher.group(1));
        }
        return keys;
    }

}
