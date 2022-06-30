package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.BAMBOO;
import static org.bukkit.Material.BOW;

public class SimpleBlowgun {

    ConquestRecipes conquestRecipes = null;
    private Object SimpleBlowgun;

    public SimpleBlowgun(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, BOW, "Simple Blowgun", "A tube of bamboo made to shoot darts.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_simple_blowgun");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0I0", "0I0", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BAMBOO)));
        Bukkit.addRecipe(recipe);
    }

}
