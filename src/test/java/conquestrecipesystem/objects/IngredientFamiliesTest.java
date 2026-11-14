package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.services.ItemRegistry;
import conquestrecipesystem.services.ItemStackService;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

/**
 * Pins the sentence that opens "Crafting" in USER_GUIDE.md: every bronze item, the Greek armour and the
 * Clean Hoplite Shield included, is made from Bronze Ingots; the Steel Longsword and Steel Bastardsword are
 * made from Steel Ingots; and the Rootmoss Cloth armour, Stone Root Cleaver and Stone Root Dagger take Roots.
 *
 * The groups are picked out by registry name rather than listed, so a bronze, steel or Rootmoss item added
 * later is held to the same sentence without this test being edited.
 */
public class IngredientFamiliesTest {

    /** For every registry name, the Conquest Recipes items its recipes look up as ingredients. */
    private static final Map<String, Set<String>> INGREDIENTS_BY_ITEM = new LinkedHashMap<>();

    @BeforeAll
    public static void recordIngredientLookups() {
        List<String> lookups = new ArrayList<>();

        ConquestRecipes plugin = mock(ConquestRecipes.class);
        when(plugin.getName()).thenReturn("Conquest-Recipes");
        ItemStackService itemStackService = mock(ItemStackService.class);
        when(itemStackService.createItemStack(anyInt(), any(Material.class), anyString(), anyString()))
                .thenAnswer(invocation -> new ItemStack((Material) invocation.getArgument(1), invocation.getArgument(0)));
        when(itemStackService.getItemStack(anyString(), anyInt())).thenAnswer(invocation -> {
            lookups.add(invocation.getArgument(0));
            return new ItemStack(Material.STRUCTURE_VOID, invocation.getArgument(1));
        });
        when(plugin.getItemStackService()).thenReturn(itemStackService);

        try (MockedStatic<Bukkit> bukkit = mockStatic(Bukkit.class)) {
            // RecipeChoice.ExactChoice compares the stacks it is given, which reaches the server's item factory
            bukkit.when(Bukkit::getItemFactory).thenReturn(mock(ItemFactory.class));

            for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
                lookups.clear();
                entry.registerRecipe(plugin);
                INGREDIENTS_BY_ITEM.put(entry.getName(), new HashSet<>(lookups));
            }
        }
    }

    @Test
    public void everyBronzeItemIsMadeFromBronzeIngots() {
        assertFamilyTakes("BronzeIngot", name -> !name.equals("BronzeIngot")
                && (name.contains("Bronze") || name.startsWith("GreekPlate") || name.equals("CleanHopliteShield")),
                "BronzeAxesword", "GreekPlateHelm", "CleanHopliteShield", "FancyBronzeHelmet", "GreatBronzeaxe");
    }

    @Test
    public void bothSteelSwordsAreMadeFromSteelIngots() {
        assertFamilyTakes("SteelIngot", name -> name.startsWith("Steel") && !name.equals("SteelIngot"),
                "SteelLongsword", "SteelBastardsword");
    }

    @Test
    public void theRootmossArmourAndTheStoneRootBladesTakeRoots() {
        assertFamilyTakes("Roots", name -> name.startsWith("Rootmoss") || name.equals("RootCleaver") || name.equals("RootDagger"),
                "RootmossClothHelmet", "RootmossClothChestpiece", "RootmossClothLeggings", "RootmossClothShoes",
                "RootCleaver", "RootDagger");
    }

    /**
     * Asserts that every registry name the predicate picks out has a recipe taking the ingredient, and that
     * the predicate picks out at least the named items, so a renamed item cannot quietly drop out of the
     * group and leave the check passing over nothing.
     */
    private void assertFamilyTakes(String ingredient, Predicate<String> inFamily, String... mustInclude) {
        Set<String> family = INGREDIENTS_BY_ITEM.keySet().stream()
                .filter(inFamily)
                .collect(Collectors.toCollection(TreeSet::new));
        assertTrue(family.containsAll(Arrays.asList(mustInclude)),
                "the " + ingredient + " group should include " + Arrays.toString(mustInclude) + " but is " + family);

        Set<String> missing = family.stream()
                .filter(name -> !INGREDIENTS_BY_ITEM.get(name).contains(ingredient))
                .collect(Collectors.toCollection(TreeSet::new));
        assertEquals(new TreeSet<String>(), missing,
                "USER_GUIDE.md's \"Crafting\" section says these are made from " + ingredient + ", but no recipe for them takes it");
    }

}
