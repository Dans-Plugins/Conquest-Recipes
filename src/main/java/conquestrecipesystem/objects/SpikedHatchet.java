package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SpikedHatchet {

    ConquestRecipes conquestRecipes = null;

    public SpikedHatchet(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, WOODEN_AXE, "Spiked Hatchet", "A hatchet crafted out of pointy sticks.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_spiked_hatchet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("ISI", "III", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        Bukkit.addRecipe(recipe);
    }
}
