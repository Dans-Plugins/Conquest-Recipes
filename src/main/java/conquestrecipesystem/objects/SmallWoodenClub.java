package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SmallWoodenClub {

    ConquestRecipes conquestRecipes = null;

    public SmallWoodenClub(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, WOODEN_SWORD, "Small Wooden Club", "A small club fashioned out of a log.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("000", "0I0", "0S0");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_OAK_LOG)));
        recipe1.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("000", "0I0", "0S0");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_BIRCH_LOG)));
        recipe2.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe2);
        NamespacedKey key3 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_3");
        ShapedRecipe recipe3 = new ShapedRecipe(key3, getItemStack(1));
        recipe3.shape("000", "0I0", "0S0");
        recipe3.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_SPRUCE_LOG)));
        recipe3.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe3);
        NamespacedKey key4 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_4");
        ShapedRecipe recipe4 = new ShapedRecipe(key4, getItemStack(1));
        recipe4.shape("000", "0I0", "0S0");
        recipe4.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_JUNGLE_LOG)));
        recipe4.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe4);
        NamespacedKey key5 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_5");
        ShapedRecipe recipe5 = new ShapedRecipe(key5, getItemStack(1));
        recipe5.shape("000", "0I0", "0S0");
        recipe5.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_ACACIA_LOG)));
        recipe5.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe5);
        NamespacedKey key6 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_6");
        ShapedRecipe recipe6 = new ShapedRecipe(key6, getItemStack(1));
        recipe6.shape("000", "0I0", "0S0");
        recipe6.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_DARK_OAK_LOG)));
        recipe6.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe6);
        NamespacedKey key7 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_7");
        ShapedRecipe recipe7 = new ShapedRecipe(key7, getItemStack(1));
        recipe7.shape("000", "0I0", "0S0");
        recipe7.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_CRIMSON_STEM)));
        recipe7.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe7);
        NamespacedKey key8 = new NamespacedKey(conquestRecipes, "conquest_recipes_small_wooden_club_8");
        ShapedRecipe recipe8 = new ShapedRecipe(key8, getItemStack(1));
        recipe8.shape("000", "0I0", "0S0");
        recipe8.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRIPPED_WARPED_STEM)));
        recipe8.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe8);
    }
}
