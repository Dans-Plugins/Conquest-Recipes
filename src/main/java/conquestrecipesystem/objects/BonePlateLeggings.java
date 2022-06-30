package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BonePlateLeggings {

    ConquestRecipes conquestRecipes = null;

    public BonePlateLeggings(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, CHAINMAIL_LEGGINGS, "Bone Plate", "Leggings made of reinforced bones");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bone_plate_leggings");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("LLL", "I0I", "I0I");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BONE)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(LEATHER)));
        Bukkit.addRecipe(recipe);
    }
}
