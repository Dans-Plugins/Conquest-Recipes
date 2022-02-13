package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeHatchet {

    ConquestRecipes conquestRecipes = null;

    public BronzeHatchet(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, IRON_AXE, "Bronze Hatchet", "A hatchet made of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_hatchet_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("II0", "IC0", "0C0");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.itemstacks.getItemStack("BronzeIngot", 1)));
        recipe1.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_hatchet_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("0II", "0CI", "0C0");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.itemstacks.getItemStack("BronzeIngot", 1)));
        recipe2.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe2);
    }
}
