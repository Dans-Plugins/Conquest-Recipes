package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class Strawhat {

    ConquestRecipes conquestRecipes = null;

    public Strawhat(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, CARVED_PUMPKIN, "Strawhat", "A hat made of straw from wheat. Ideal for farmers.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_strawhat");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("LLL", "I0I", "000");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(WHEAT)));
        Bukkit.addRecipe(recipe);
    }
}
