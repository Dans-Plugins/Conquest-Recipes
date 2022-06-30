package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class FeatherHeaddress {

    ConquestRecipes conquestRecipes = null;

    public FeatherHeaddress(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, CARVED_PUMPKIN, "Feather Headdress", "A Headdress made primarily of feathers.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_jaguar_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("FFF", "III", "000");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(LEATHER)));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(FEATHER)));
        Bukkit.addRecipe(recipe);
    }
}
