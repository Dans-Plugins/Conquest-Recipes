package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class Tepoztopilli {

    ConquestRecipes conquestRecipes = null;

    public Tepoztopilli(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, STONE_SWORD, "Tepoztopilli", "A long spear with a flint tip.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_tepoztopilli");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("00S", "0I0", "I00");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(FLINT)));
        Bukkit.addRecipe(recipe);
    }
}
