package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class PrimitiveWarhammer {

    ConquestRecipes conquestRecipes = null;

    public PrimitiveWarhammer(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, STONE_AXE, "Primitive Warhammer", "A war hammer fashioned out of tied stone.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_warhammer");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("BFB", "0I0", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(COBBLESTONE)));
        Bukkit.addRecipe(recipe);
    }
}
