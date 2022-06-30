package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.CHAINMAIL_BOOTS;
import static org.bukkit.Material.VINE;

public class RootmossClothShoes {

    ConquestRecipes conquestRecipes = null;

    public RootmossClothShoes(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, CHAINMAIL_BOOTS, "Rootmoss Cloth Shoes", "A rootmoss pair of shoes. Made of intertwined vines and roots.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_rootmoss_cloth_shoes");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("000", "L0L", "I0I");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("Roots", 1)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(VINE)));
        Bukkit.addRecipe(recipe);
    }
}
