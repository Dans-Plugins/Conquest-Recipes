package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.services.ItemRegistry;
import conquestrecipesystem.services.ItemStackService;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.MockedStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

/**
 * Pins the five recipes that start from vanilla materials, exactly as the table under "Crafting" in
 * USER_GUIDE.md lays them out: Copper Chunk, Tin Chunk, Bronze Ingot, Steel Ingot and Roots. Every other
 * item is made from one of these, so a changed grid, ingredient or yield here changes what a player has to
 * gather for most of the plugin, and the guide would no longer describe it.
 *
 * Each recipe is rendered as its three rows, one cell per square, so a failure shows the grid that changed.
 */
public class StarterRecipesTest {

    /**
     * Materials that stand in for a Conquest Recipes item used as an ingredient. Recipes look such an item
     * up by name; answering each name with its own otherwise-unused material keeps it distinguishable from
     * the plain vanilla material the real item is built on (a Copper Chunk is a nether brick underneath).
     */
    private static final Map<Material, String> CONQUEST_INGREDIENTS = new EnumMap<>(Material.class);

    static {
        CONQUEST_INGREDIENTS.put(Material.STRUCTURE_VOID, "Copper Chunk");
        CONQUEST_INGREDIENTS.put(Material.BARRIER, "Tin Chunk");
    }

    private ConquestRecipes plugin;

    @BeforeEach
    public void setUp() {
        plugin = mock(ConquestRecipes.class);
        when(plugin.getName()).thenReturn("Conquest-Recipes");
        ItemStackService itemStackService = mock(ItemStackService.class);
        when(itemStackService.createItemStack(anyInt(), any(Material.class), anyString(), anyString()))
                .thenAnswer(invocation -> new ItemStack((Material) invocation.getArgument(1), invocation.getArgument(0)));
        when(itemStackService.getItemStack(anyString(), anyInt())).thenAnswer(invocation -> {
            String name = invocation.getArgument(0);
            int amount = invocation.getArgument(1);
            if (name.equals("Copper")) {
                return new ItemStack(Material.STRUCTURE_VOID, amount);
            }
            if (name.equals("Tin")) {
                return new ItemStack(Material.BARRIER, amount);
            }
            return fail("a starter recipe looked up an unexpected Conquest Recipes item: " + name);
        });
        when(plugin.getItemStackService()).thenReturn(itemStackService);
    }

    @Test
    public void copperChunkIsNineCobblestoneMakingFour() {
        assertRecipes("Copper", Material.NETHER_BRICK, 4, Arrays.asList(
                grid("cobblestone | cobblestone | cobblestone",
                     "cobblestone | cobblestone | cobblestone",
                     "cobblestone | cobblestone | cobblestone")));
    }

    @Test
    public void tinChunkIsNineGravelMakingFour() {
        assertRecipes("Tin", Material.FIREWORK_STAR, 4, Arrays.asList(
                grid("gravel | gravel | gravel",
                     "gravel | gravel | gravel",
                     "gravel | gravel | gravel")));
    }

    @Test
    public void bronzeIngotIsTinOverCopperAroundCoalOrCharcoalMakingThree() {
        assertRecipes("BronzeIngot", Material.GOLD_INGOT, 3, Arrays.asList(
                grid("Tin Chunk | Tin Chunk | Tin Chunk",
                     "Copper Chunk | Copper Chunk | Copper Chunk",
                     "Copper Chunk | coal | Copper Chunk"),
                grid("Tin Chunk | Tin Chunk | Tin Chunk",
                     "Copper Chunk | Copper Chunk | Copper Chunk",
                     "Copper Chunk | charcoal | Copper Chunk")));
    }

    @Test
    public void steelIngotIsIronBetweenRowsOfCoalOrCharcoalMakingTwo() {
        assertRecipes("SteelIngot", Material.IRON_INGOT, 2, Arrays.asList(
                grid("coal | coal | coal",
                     "iron_ingot | iron_ingot | iron_ingot",
                     "coal | coal | coal"),
                grid("charcoal | charcoal | charcoal",
                     "iron_ingot | iron_ingot | iron_ingot",
                     "charcoal | charcoal | charcoal")));
    }

    @Test
    public void rootsIsOneSaplingOfAnyOfSixKindsInTheCentreMakingTwo() {
        List<List<String>> expected = new ArrayList<>();
        for (String sapling : Arrays.asList("oak_sapling", "birch_sapling", "jungle_sapling",
                "acacia_sapling", "dark_oak_sapling", "spruce_sapling")) {
            expected.add(grid("empty | empty | empty",
                              "empty | " + sapling + " | empty",
                              "empty | empty | empty"));
        }
        assertRecipes("Roots", Material.DEAD_BUSH, 2, expected);
    }

    private void assertRecipes(String itemName, Material resultMaterial, int resultAmount, List<List<String>> expectedGrids) {
        ItemRegistry.Entry entry = ItemRegistry.find(itemName);
        assertNotNull(entry, itemName + " should be in the registry");

        List<ShapedRecipe> recipes = new ArrayList<>();
        try (MockedStatic<Bukkit> bukkit = mockStatic(Bukkit.class)) {
            // RecipeChoice.ExactChoice compares the stacks it is given, which reaches the server's item factory
            bukkit.when(Bukkit::getItemFactory).thenReturn(mock(ItemFactory.class));

            entry.registerRecipe(plugin);

            ArgumentCaptor<Recipe> captor = ArgumentCaptor.forClass(Recipe.class);
            bukkit.verify(() -> Bukkit.addRecipe(captor.capture()), atLeast(0));
            for (Recipe recipe : captor.getAllValues()) {
                assertTrue(recipe instanceof ShapedRecipe, itemName + " should register shaped recipes only");
                recipes.add((ShapedRecipe) recipe);
            }
        }

        assertEquals(expectedGrids, recipes.stream().map(this::render).collect(Collectors.toList()),
                itemName + "'s recipes no longer match USER_GUIDE.md's \"Crafting\" table");
        for (ShapedRecipe recipe : recipes) {
            assertEquals(resultMaterial, recipe.getResult().getType(), recipe.getKey().getKey() + " should make " + resultMaterial);
            assertEquals(resultAmount, recipe.getResult().getAmount(), recipe.getKey().getKey() + " should make " + resultAmount);
        }
    }

    /** The recipe's three rows, each cell named by its ingredient, or "empty" for a square left blank. */
    private List<String> render(ShapedRecipe recipe) {
        Map<Character, RecipeChoice> choices = recipe.getChoiceMap();
        List<String> rows = new ArrayList<>();
        for (String row : recipe.getShape()) {
            List<String> cells = new ArrayList<>();
            for (char symbol : row.toCharArray()) {
                cells.add(cell(choices.get(symbol)));
            }
            rows.add(String.join(" | ", cells));
        }
        return rows;
    }

    private String cell(RecipeChoice choice) {
        if (choice == null) {
            return "empty";
        }
        if (!(choice instanceof RecipeChoice.ExactChoice)) {
            return "not an exact choice: " + choice;
        }
        return ((RecipeChoice.ExactChoice) choice).getChoices().stream()
                .map(ItemStack::getType)
                .map(material -> CONQUEST_INGREDIENTS.getOrDefault(material, material.name().toLowerCase()))
                .collect(Collectors.joining(" or "));
    }

    private static List<String> grid(String top, String middle, String bottom) {
        return Arrays.asList(top, middle, bottom);
    }

}
