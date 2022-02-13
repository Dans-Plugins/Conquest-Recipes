package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class CleanHopliteShield {

    ConquestRecipes conquestRecipes = null;

    public CleanHopliteShield(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, SHIELD, "Clean Hoplite Shield", "A small bronze shield.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_clean_hoplite_shield");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0S0", "SSS", "0S0");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
