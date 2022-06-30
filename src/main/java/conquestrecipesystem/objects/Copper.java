package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.COBBLESTONE;
import static org.bukkit.Material.NETHER_BRICK;

public class Copper {

    ConquestRecipes conquestRecipes = null;

    public Copper(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, NETHER_BRICK, "Copper Chunk", "A chunk of copper found from smashing apart stone.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_copper");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(4));
        recipe.shape("III", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(COBBLESTONE)));
        Bukkit.addRecipe(recipe);
    }
}
