package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.IRON_SWORD;
import static org.bukkit.Material.STICK;

public class BronzeDagger {

    ConquestRecipes conquestRecipes = null;

    public BronzeDagger(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, IRON_SWORD, "Bronze Dagger", "A dagger made of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_dagger");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("000", "0S0", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
