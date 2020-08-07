package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeGladiatorHelmet {

    Main main = null;

    public BronzeGladiatorHelmet(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, CARVED_PUMPKIN, "Bronze Gladiator Helmet", "A bronze helmet, meant to be worn by those of the gladiatorial pits.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_bronze_gladiator_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0S0", "SSS", "SIS");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(IRON_BARS)));
        Bukkit.addRecipe(recipe);
    }
}
