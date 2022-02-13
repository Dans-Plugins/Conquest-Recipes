package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class PrimitiveFishingSpear {

    ConquestRecipes conquestRecipes = null;
    private Object PrimitiveFishingSpear;

    public PrimitiveFishingSpear(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, WOODEN_SWORD, "Primitive Fishingspear", "A long, crudely made spear, made primarily for fishing.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_fishingspear_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("0S0", "TIT", "0I0");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(OAK_SAPLING)));
        recipe1.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe1.setIngredient('T', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_fishingspear_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("0S0", "TIT", "0I0");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BIRCH_SAPLING)));
        recipe2.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe2.setIngredient('T', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe2);
        NamespacedKey key3 = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_fishingspear_3");
        ShapedRecipe recipe3 = new ShapedRecipe(key3, getItemStack(1));
        recipe3.shape("0S0", "TIT", "0I0");
        recipe3.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(DARK_OAK_SAPLING)));
        recipe3.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe3.setIngredient('T', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe3);
        NamespacedKey key4 = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_fishingspear_4");
        ShapedRecipe recipe4 = new ShapedRecipe(key4, getItemStack(1));
        recipe4.shape("0S0", "TIT", "0I0");
        recipe4.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(SPRUCE_SAPLING)));
        recipe4.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe4.setIngredient('T', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe4);
        NamespacedKey key5 = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_fishingspear_5");
        ShapedRecipe recipe5 = new ShapedRecipe(key5, getItemStack(1));
        recipe5.shape("0S0", "TIT", "0I0");
        recipe5.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(JUNGLE_SAPLING)));
        recipe5.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe5.setIngredient('T', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe5);
        NamespacedKey key6 = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_fishingspear_6");
        ShapedRecipe recipe6 = new ShapedRecipe(key6, getItemStack(1));
        recipe6.shape("0S0", "TIT", "0I0");
        recipe6.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(ACACIA_SAPLING)));
        recipe6.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe6.setIngredient('T', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe6);
    }
}
