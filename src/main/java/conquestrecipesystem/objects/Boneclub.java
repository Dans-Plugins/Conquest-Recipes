package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class Boneclub {

    ConquestRecipes conquestRecipes = null;

    public Boneclub(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, STONE_AXE, "Boneclub", "A club fashioned out of sharp bones");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_boneclub");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("BBF", "0I0", "I00");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(BONE)));
        Bukkit.addRecipe(recipe);
    }
}
