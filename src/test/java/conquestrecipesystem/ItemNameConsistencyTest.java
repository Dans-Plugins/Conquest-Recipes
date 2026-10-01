package conquestrecipesystem;

import conquestrecipesystem.services.ItemRegistry;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Recipe registration, {@code /cr get} and {@code /cr list} all read the item set from {@link ItemRegistry},
 * so they can no longer disagree with each other. What the compiler still cannot check is that the registry
 * names every class in {@code conquestrecipesystem.objects}: a class written but never added to the registry
 * compiles, and is then neither craftable, obtainable nor listed.
 *
 * This test asserts that the registry names exactly the classes present in {@code conquestrecipesystem.objects},
 * and names each of them once.
 */
public class ItemNameConsistencyTest {

    private static final Path OBJECTS = Paths.get("src", "main", "java", "conquestrecipesystem", "objects");

    @Test
    public void theRegistryNamesExactlyTheItemClasses() {
        assertEquals(itemClassNames(), new TreeSet<>(registryNames()),
                "ItemRegistry should name exactly the classes in conquestrecipesystem.objects");
    }

    @Test
    public void noItemIsRegisteredTwice() {
        List<String> names = registryNames();
        Set<String> distinct = names.stream().map(String::toLowerCase).collect(Collectors.toSet());
        assertEquals(names.size(), distinct.size(),
                "ItemRegistry should name each item once; a repeated entry would register its recipe twice");
    }

    private List<String> registryNames() {
        return ItemRegistry.getEntries().stream().map(ItemRegistry.Entry::getName).collect(Collectors.toList());
    }

    private Set<String> itemClassNames() {
        assertTrue(Files.isDirectory(OBJECTS),
                "expected the item classes at " + OBJECTS.toAbsolutePath() + "; tests are run from the project root");

        try (Stream<Path> files = Files.list(OBJECTS)) {
            Set<String> names = files
                    .map(file -> file.getFileName().toString())
                    .filter(fileName -> fileName.endsWith(".java"))
                    .map(fileName -> fileName.substring(0, fileName.length() - ".java".length()))
                    .collect(Collectors.toCollection(TreeSet::new));
            assertFalse(names.isEmpty(), "no item classes were found in " + OBJECTS.toAbsolutePath());
            return names;
        }
        catch (IOException exception) {
            throw new UncheckedIOException(exception);
        }
    }

}
