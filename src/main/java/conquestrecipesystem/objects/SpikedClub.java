package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SpikedClub {

    ConquestRecipes conquestRecipes = null;

    public SpikedClub(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, WOODEN_AXE, "Spiked Club", "A club fashioned out of sharp sticks");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_spiked_club");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0II", "0II", "I00");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe);
    }
}
