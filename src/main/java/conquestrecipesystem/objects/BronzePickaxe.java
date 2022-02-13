package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzePickaxe {

    ConquestRecipes conquestRecipes = null;

    public BronzePickaxe(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, IRON_PICKAXE, "Bronze Pickaxe", "A pickaxe made of bronze. Great for mining.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("SSS", "0I0", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
