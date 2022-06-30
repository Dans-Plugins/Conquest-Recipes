package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeGladiatorHelmet {

    ConquestRecipes conquestRecipes = null;

    public BronzeGladiatorHelmet(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, CARVED_PUMPKIN, "Bronze Gladiator Helmet", "A bronze helmet, meant to be worn by those of the gladiatorial pits.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(conquestRecipes, "conquest_recipes_bronze_gladiator_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0S0", "SSS", "SIS");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(conquestRecipes.getItemStackService().getItemStack("BronzeIngot", 1)));
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(IRON_BARS)));
        Bukkit.addRecipe(recipe);
    }
}
