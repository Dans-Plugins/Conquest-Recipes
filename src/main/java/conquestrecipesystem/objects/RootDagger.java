package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.COBBLESTONE;
import static org.bukkit.Material.STONE_SWORD;

public class RootDagger {

    ConquestRecipes conquestRecipes = null;

    public RootDagger(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, STONE_SWORD, "Stone Root Dagger", "A dagger made out of stone with a root handle.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_root_dagger");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("000", "0B0", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("Roots", 1)));
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(COBBLESTONE)));
        Bukkit.addRecipe(recipe);
    }
}
