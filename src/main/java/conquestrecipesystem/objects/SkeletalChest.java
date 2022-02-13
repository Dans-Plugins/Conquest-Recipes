package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SkeletalChest {

    ConquestRecipes conquestRecipes = null;

    public SkeletalChest(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.itemstacks.createItemStack(amount, CHAINMAIL_CHESTPLATE, "Skeletal Chest", "The chest of a skeleton.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_skeletal_chest");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("I0I", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BONE)));
        Bukkit.addRecipe(recipe);
    }
}
