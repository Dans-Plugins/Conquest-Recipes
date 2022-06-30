package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class RootmossClothChestpiece {

    ConquestRecipes conquestRecipes = null;

    public RootmossClothChestpiece(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, CHAINMAIL_CHESTPLATE, "Rootmoss Cloth Chestpiece", "A rootmoss chestpiece. Made of intertwined vines and roots.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_rootmoss_cloth_chestpiece");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("L0L", "ILI", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("Roots", 1)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(VINE)));
        Bukkit.addRecipe(recipe);
    }
}
