package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BigMacuahuitl {

    ConquestRecipes conquestRecipes = null;

    public BigMacuahuitl(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, STONE_SWORD, "Big Macuahuitl", "A stick layered with flint blades.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_big_macuahuitl");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("SIS", "SIS", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(FLINT)));
        Bukkit.addRecipe(recipe);
    }
}
