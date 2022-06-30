package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SharpenedBamboo {

    ConquestRecipes conquestRecipes = null;

    public SharpenedBamboo(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, BAMBOO, "Sharpened Bamboo", "A piece of sharpened bamboo.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_sharpened_bamboo");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(8));
        recipe.shape("FII", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BAMBOO)));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(FLINT)));
        Bukkit.addRecipe(recipe);
    }
}
