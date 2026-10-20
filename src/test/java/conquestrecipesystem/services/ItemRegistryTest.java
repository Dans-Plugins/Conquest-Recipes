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
import java.util.TreeMap;
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
import static org.mockito.Mockito.clearInvocations;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemRegistryTest {

    /** Each item's registry name, as /cr list prints it, and the display name it is given in game. */
    private static final Map<String, String> DISPLAY_NAMES = new TreeMap<>();

    static {
        DISPLAY_NAMES.put("AfricanTallShield", "African Tall Bamboo Shield");
        DISPLAY_NAMES.put("BigMacuahuitl", "Big Macuahuitl");
        DISPLAY_NAMES.put("BonePlateBoots", "Bone Plate");
        DISPLAY_NAMES.put("BonePlateChestplate", "Bone Plate");
        DISPLAY_NAMES.put("BonePlateHelm", "Bone Plate");
        DISPLAY_NAMES.put("BonePlateLeggings", "Bone Plate");
        DISPLAY_NAMES.put("BoneShield", "Bone Shield");
        DISPLAY_NAMES.put("Boneclub", "Boneclub");
        DISPLAY_NAMES.put("BronzeAxesword", "Bronze Axesword");
        DISPLAY_NAMES.put("BronzeBlade", "Bronze Blade");
        DISPLAY_NAMES.put("BronzeCorinthianHelmet", "Bronze Corinthian Helmet");
        DISPLAY_NAMES.put("BronzeDagger", "Bronze Dagger");
        DISPLAY_NAMES.put("BronzeFancyFlail", "Bronze Fancy Flail");
        DISPLAY_NAMES.put("BronzeGladiatorHelmet", "Bronze Gladiator Helmet");
        DISPLAY_NAMES.put("BronzeGlaive", "Bronze Glaive");
        DISPLAY_NAMES.put("BronzeGreatsword", "Bronze Greatsword");
        DISPLAY_NAMES.put("BronzeHatchet", "Bronze Hatchet");
        DISPLAY_NAMES.put("BronzeHoe", "Bronze Hoe");
        DISPLAY_NAMES.put("BronzeIngot", "Bronze Ingot");
        DISPLAY_NAMES.put("BronzeKatar", "Bronze Katar");
        DISPLAY_NAMES.put("BronzeKhopesh", "Bronze Khopesh");
        DISPLAY_NAMES.put("BronzePickaxe", "Bronze Pickaxe");
        DISPLAY_NAMES.put("BronzeSpade", "Bronze Spade");
        DISPLAY_NAMES.put("CleanHopliteShield", "Clean Hoplite Shield");
        DISPLAY_NAMES.put("Copper", "Copper Chunk");
        DISPLAY_NAMES.put("Cuauhololli", "Cuauhololli");
        DISPLAY_NAMES.put("Dart", "Dart");
        DISPLAY_NAMES.put("DecoratedChimalliShield", "Decorated Chimalli Shield");
        DISPLAY_NAMES.put("EagleHelmet", "Eagle Helmet");
        DISPLAY_NAMES.put("FancyBronzeHelmet", "Fancy Bronze Helmet");
        DISPLAY_NAMES.put("FancyWoodenWarclub", "Fancy Wooden Warclub");
        DISPLAY_NAMES.put("FeatherHeaddress", "Feather Headdress");
        DISPLAY_NAMES.put("FeatheredMacuahuitl", "Feathered Macuahuitl");
        DISPLAY_NAMES.put("GreatBronzeaxe", "Great Bronzeaxe");
        DISPLAY_NAMES.put("GreekPlateChestpiece", "Bronze Greek Plate Chestpiece");
        DISPLAY_NAMES.put("GreekPlateGreaves", "Bronze Greek Plate Greaves");
        DISPLAY_NAMES.put("GreekPlateHelm", "Bronze Greek Plate Helm");
        DISPLAY_NAMES.put("GreekPlateSabatons", "Bronze Greek Plate Sabatons");
        DISPLAY_NAMES.put("JaguarHelmet", "Jaguar Helmet");
        DISPLAY_NAMES.put("LargeWoodenClub", "Large Wooden Club");
        DISPLAY_NAMES.put("PrimitiveFishingSpear", "Primitive Fishingspear");
        DISPLAY_NAMES.put("PrimitiveFlail", "Primitive Flail");
        DISPLAY_NAMES.put("PrimitiveHuntingSpear", "Primitive Hunting Spear");
        DISPLAY_NAMES.put("PrimitiveStoneblade", "Primitive Stoneblade");
        DISPLAY_NAMES.put("PrimitiveWarhammer", "Primitive Warhammer");
        DISPLAY_NAMES.put("RootCleaver", "Stone Root Cleaver");
        DISPLAY_NAMES.put("RootDagger", "Stone Root Dagger");
        DISPLAY_NAMES.put("RootmossClothChestpiece", "Rootmoss Cloth Chestpiece");
        DISPLAY_NAMES.put("RootmossClothHelmet", "Rootmoss Cloth Hood");
        DISPLAY_NAMES.put("RootmossClothLeggings", "Rootmoss Cloth Leggings");
        DISPLAY_NAMES.put("RootmossClothShoes", "Rootmoss Cloth Shoes");
        DISPLAY_NAMES.put("Roots", "Roots");
        DISPLAY_NAMES.put("SharpenedBamboo", "Sharpened Bamboo");
        DISPLAY_NAMES.put("SharpenedPole", "Sharpened Pole");
        DISPLAY_NAMES.put("SimpleBlowgun", "Simple Blowgun");
        DISPLAY_NAMES.put("SkeletalChest", "Skeletal Chest");
        DISPLAY_NAMES.put("SkeletalFeet", "Skeletal Feet");
        DISPLAY_NAMES.put("SkeletalLegs", "Skeletal Legs");
        DISPLAY_NAMES.put("SkeletalSkull", "Skeletal Skull");
        DISPLAY_NAMES.put("SmallMacuahuitl", "Small Macuahuitl");
        DISPLAY_NAMES.put("SmallWoodenClub", "Small Wooden Club");
        DISPLAY_NAMES.put("SpikedClub", "Spiked Club");
        DISPLAY_NAMES.put("SpikedHalberd", "Spiked Halbert");
        DISPLAY_NAMES.put("SpikedHatchet", "Spiked Hatchet");
        DISPLAY_NAMES.put("SpiralChimalliShield", "Spiral Chimalli Shield");
        DISPLAY_NAMES.put("SteelBastardsword", "Steel Bastardsword");
        DISPLAY_NAMES.put("SteelIngot", "Steel Ingot");
        DISPLAY_NAMES.put("SteelLongsword", "Steel Longsword");
        DISPLAY_NAMES.put("StoneHalberd", "Stone Halbert");
        DISPLAY_NAMES.put("Stonespear", "Stonespear");
        DISPLAY_NAMES.put("Strawhat", "Strawhat");
        DISPLAY_NAMES.put("Tepoztopilli", "Tepoztopilli");
        DISPLAY_NAMES.put("Tin", "Tin Chunk");
    }

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

    /**
     * Items are identified by display name only, so a texture pack that retextures them has to match on
     * these exact strings, misspellings such as "Stone Halbert" included. Renaming one would quietly strip
     * its texture on every server running such a pack, so a change here should be deliberate.
     */
    @Test
    public void everyItemKeepsTheDisplayNameTexturePacksMatchOn() {
        assertEquals(new TreeSet<>(DISPLAY_NAMES.keySet()),
                ItemRegistry.getEntries().stream().map(ItemRegistry.Entry::getName).collect(Collectors.toCollection(TreeSet::new)),
                "every registry entry should have its display name pinned here, and no other names should be");

        for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
            clearInvocations(pluginItemStackService);

            entry.getItemStack(plugin, 1);

            ArgumentCaptor<String> displayName = ArgumentCaptor.forClass(String.class);
            verify(pluginItemStackService).createItemStack(anyInt(), any(Material.class), displayName.capture(), anyString());
            assertEquals(DISPLAY_NAMES.get(entry.getName()), displayName.getValue(), entry.getName() + "'s display name has changed");
        }
    }

    @Test
    public void everyItemIsBuiltInTheRequestedAmount() {
        for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
            ItemStack stack = entry.getItemStack(plugin, 7);

            assertEquals(7, stack.getAmount(), entry.getName() + " should be built in the amount asked for");
        }
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
