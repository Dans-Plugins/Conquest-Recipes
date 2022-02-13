package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.BONE;
import static org.bukkit.Material.CHAINMAIL_LEGGINGS;

public class SkeletalLegs {

    ConquestRecipes conquestRecipes = null;

    public SkeletalLegs(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, CHAINMAIL_LEGGINGS, "Skeletal Legs", "The legs of a skeleton.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_skeletal_legs");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("III", "I0I", "I0I");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BONE)));
        Bukkit.addRecipe(recipe);
    }
}
