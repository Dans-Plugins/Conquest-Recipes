package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.IRON_SWORD;
import static org.bukkit.Material.STICK;

public class BronzeBlade {

    ConquestRecipes conquestRecipes = null;

    public BronzeBlade(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, IRON_SWORD, "Bronze Blade", "A blade made of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_blade");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0S0", "0S0", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
