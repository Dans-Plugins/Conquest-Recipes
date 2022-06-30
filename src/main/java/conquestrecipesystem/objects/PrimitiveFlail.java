package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class PrimitiveFlail {

    ConquestRecipes conquestRecipes = null;

    public PrimitiveFlail(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, WOODEN_AXE, "Primitive Flail", "A flail crafted out of a rock tied to a stick.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_primitive_flail");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("00I", "0IS", "I0C");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(new ItemStack(STRING)));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(COBBLESTONE)));
        Bukkit.addRecipe(recipe);
    }
}
