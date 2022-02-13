package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BonePlateChestplate {

    ConquestRecipes conquestRecipes = null;

    public BonePlateChestplate(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, CHAINMAIL_CHESTPLATE, "Bone Plate", "A chestplate made of reinforced bones");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bone_plate_chestplate");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("L0L", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BONE)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(LEATHER)));
        Bukkit.addRecipe(recipe);
    }
}
