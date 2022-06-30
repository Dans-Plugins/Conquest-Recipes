package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.CHAINMAIL_LEGGINGS;
import static org.bukkit.Material.VINE;

public class RootmossClothLeggings {

    ConquestRecipes conquestRecipes = null;

    public RootmossClothLeggings(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, CHAINMAIL_LEGGINGS, "Rootmoss Cloth Leggings", "A rootmoss cloth leggings. Made of intertwined vines and roots.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_rootmoss_cloth_leggings");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("ILI", "L0L", "I0I");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("Roots", 1)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(VINE)));
        Bukkit.addRecipe(recipe);
    }
}
