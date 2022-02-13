package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BonePlateBoots {

    ConquestRecipes conquestRecipes = null;

    public BonePlateBoots(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, CHAINMAIL_BOOTS, "Bone Plate", "A pair of boots made of reinforced bones");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bone_plate_boots");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("000", "I0I", "L0L");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BONE)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(LEATHER)));
        Bukkit.addRecipe(recipe);
    }
}
