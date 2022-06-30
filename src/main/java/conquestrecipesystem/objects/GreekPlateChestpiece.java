package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.GOLDEN_CHESTPLATE;

public class GreekPlateChestpiece {

    ConquestRecipes conquestRecipes = null;

    public GreekPlateChestpiece(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, GOLDEN_CHESTPLATE, "Bronze Greek Plate Chestpiece", "A chestplate of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_greek_plate_chestpiece");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("S0S", "SSS", "SSS");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
