package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class Dart {

    ConquestRecipes conquestRecipes = null;
    private Object SharpenedBamboo;

    public Dart(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, ARROW, "Dart", "A dart of bamboo and feathers");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_dart");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(3));
        recipe.shape("000", "0I0", "0F0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BAMBOO)));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(FEATHER)));
        Bukkit.addRecipe(recipe);
    }

}
