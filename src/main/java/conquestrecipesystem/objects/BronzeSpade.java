package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeSpade {

    ConquestRecipes conquestRecipes = null;

    public BronzeSpade(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, IRON_SHOVEL, "Bronze Spade", "A spade made of bronze. Used to dig.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_spade_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("I00", "C00", "C00");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        recipe1.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_spade_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("0I0", "0C0", "0C0");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        recipe2.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe2);
        NamespacedKey key3 = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_spade_3");
        ShapedRecipe recipe3 = new ShapedRecipe(key3, getItemStack(1));
        recipe3.shape("00I", "00C", "00C");
        recipe3.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        recipe3.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        Bukkit.addRecipe(recipe3);
    }
}
