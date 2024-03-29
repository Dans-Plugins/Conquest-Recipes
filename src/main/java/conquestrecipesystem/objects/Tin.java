package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.FIREWORK_STAR;
import static org.bukkit.Material.GRAVEL;

public class Tin {

    ConquestRecipes conquestRecipes = null;

    public Tin(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, FIREWORK_STAR, "Tin Chunk", "A chunk of tin, found while sifting through gravel.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_tin");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(4));
        recipe.shape("III", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(GRAVEL)));
        Bukkit.addRecipe(recipe);
    }
}
