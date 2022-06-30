package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeHoe {

    ConquestRecipes conquestRecipes = null;

    public BronzeHoe(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, IRON_HOE, "Bronze Hoe", "A hoe made of bronze. Made to till the earth.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_hoe_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("II0", "0C0", "0C0");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        recipe1.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_hoe_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("0II", "0C0", "0C0");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        recipe2.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe2);
    }
}
