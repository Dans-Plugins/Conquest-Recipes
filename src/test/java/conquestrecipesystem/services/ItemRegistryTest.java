package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.Keyed;
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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemRegistryTest {

    private ConquestRecipes plugin;
    private ItemStackService pluginItemStackService;

    @BeforeEach
    public void setUp() {
        plugin = mock(ConquestRecipes.class);
        when(plugin.getName()).thenReturn("Conquest-Recipes");
        pluginItemStackService = mock(ItemStackService.class);
        when(pluginItemStackService.createItemStack(anyInt(), any(Material.class), anyString(), anyString()))
                .thenAnswer(invocation -> new ItemStack((Material) invocation.getArgument(1), invocation.getArgument(0)));
        // some recipes take another Conquest Recipes item as an ingredient, looked up by name
        when(pluginItemStackService.getItemStack(anyString(), anyInt()))
                .thenAnswer(invocation -> ItemRegistry.find(invocation.getArgument(0)).getItemStack(plugin, invocation.getArgument(1)));
        when(plugin.getItemStackService()).thenReturn(pluginItemStackService);
    }

    @Test
    public void findIgnoresCase() {
        for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
            assertSame(entry, ItemRegistry.find(entry.getName().toLowerCase()),
                    entry.getName() + " should be found under its lower-case name");
        }
    }

    @Test
    public void findReturnsNullForAnUnknownName() {
        assertNull(ItemRegistry.find("NotAnItem"));
    }

    @Test
    public void getItemStackBuildsTheNamedItem() {
        ItemStack dart = new ItemStackService(plugin).getItemStack("dart", 5);

        assertEquals(Material.ARROW, dart.getType());
        assertEquals(5, dart.getAmount());
        verify(pluginItemStackService).createItemStack(eq(5), eq(Material.ARROW), eq("Dart"), anyString());
    }

    @Test
    public void getItemStackReturnsNullForAnUnknownName() {
        assertNull(new ItemStackService(plugin).getItemStack("NotAnItem", 1));
    }

    @Test
    public void everyItemRegistersARecipe() {
        try (MockedStatic<Bukkit> bukkit = mockBukkit()) {
            for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
                bukkit.clearInvocations();

                entry.registerRecipe(plugin);

                assertFalse(recipesAddedTo(bukkit).isEmpty(), entry.getName() + " should register at least one recipe");
            }
        }
    }

    @Test
    public void registerRecipesRegistersEveryItemsRecipesUnderDistinctKeys() {
        try (MockedStatic<Bukkit> bukkit = mockBukkit()) {
            new RecipeService(plugin).registerRecipes();

            List<Recipe> registered = recipesAddedTo(bukkit);
            Set<String> keys = registered.stream()
                    .map(recipe -> ((Keyed) recipe).getKey().getKey())
                    .collect(Collectors.toSet());
            assertTrue(registered.size() >= ItemRegistry.getEntries().size(),
                    "every item in the registry should register at least one recipe, but only " + registered.size() + " were registered");
            assertEquals(registered.size(), keys.size(), "no two recipes should share a key");
        }
    }

    /**
     * Bukkit leaves a shape symbol that is never given an ingredient as an empty slot, without complaint,
     * so a symbol whose {@code setIngredient} line is missing or names another letter makes the recipe
     * accept an empty slot where an ingredient was meant. Every recipe marks its empty slots with
     * {@code '0'}; any other symbol must have an ingredient.
     */
    @Test
    public void everyShapeSymbolOtherThanTheBlankHasAnIngredient() {
        try (MockedStatic<Bukkit> bukkit = mockBukkit()) {
            for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
                bukkit.clearInvocations();

                entry.registerRecipe(plugin);

                for (Recipe recipe : recipesAddedTo(bukkit)) {
                    ShapedRecipe shaped = (ShapedRecipe) recipe;
                    Map<Character, RecipeChoice> choices = shaped.getChoiceMap();
                    Set<Character> withoutIngredient = new TreeSet<>();
                    for (String row : shaped.getShape()) {
                        for (char symbol : row.toCharArray()) {
                            if (symbol != '0' && choices.get(symbol) == null) {
                                withoutIngredient.add(symbol);
                            }
                        }
                    }
                    assertTrue(withoutIngredient.isEmpty(), entry.getName() + "'s recipe " + shaped.getKey().getKey()
                            + " has no ingredient for " + withoutIngredient + " in its shape " + Arrays.toString(shaped.getShape()));
                }
            }
        }
    }

    private MockedStatic<Bukkit> mockBukkit() {
        MockedStatic<Bukkit> bukkit = mockStatic(Bukkit.class);
        // RecipeChoice.ExactChoice compares the stacks it is given, which reaches the server's item factory
        bukkit.when(Bukkit::getItemFactory).thenReturn(mock(ItemFactory.class));
        return bukkit;
    }

    private List<Recipe> recipesAddedTo(MockedStatic<Bukkit> bukkit) {
        ArgumentCaptor<Recipe> recipes = ArgumentCaptor.forClass(Recipe.class);
        bukkit.verify(() -> Bukkit.addRecipe(recipes.capture()), atLeast(0));
        return recipes.getAllValues();
    }

}
