package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeFancyFlail {

    ConquestRecipes conquestRecipes = null;

    public BronzeFancyFlail(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, IRON_AXE, "Bronze Fancy Flail", "A flail of bronze, made for those wishing to show off on the battlefield.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_fancy_flail");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("00I", "0IC", "I0S");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(CHAIN)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
