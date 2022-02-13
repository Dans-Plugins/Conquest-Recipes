package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SteelLongsword {

    ConquestRecipes conquestRecipes = null;

    public SteelLongsword(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, IRON_SWORD, "Steel Longsword", "A long blade of steel.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_steel_longsword");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("00S", "0S0", "I00");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
