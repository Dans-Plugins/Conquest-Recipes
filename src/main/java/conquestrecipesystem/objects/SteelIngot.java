package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SteelIngot {

    ConquestRecipes conquestRecipes = null;

    public SteelIngot(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, IRON_INGOT, "Steel Ingot", "A durable refined alloy");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_steel_ingot_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(2));
        recipe1.shape("CCC", "III", "CCC");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(IRON_INGOT)));
        recipe1.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(COAL)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_steel_ingot_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(2));
        recipe2.shape("CCC", "III", "CCC");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(IRON_INGOT)));
        recipe2.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(CHARCOAL)));
        Bukkit.addRecipe(recipe2);
    }

}
