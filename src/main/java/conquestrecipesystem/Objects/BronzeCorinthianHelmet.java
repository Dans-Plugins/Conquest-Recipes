package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeCorinthianHelmet {

    Main main = null;

    public BronzeCorinthianHelmet(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, CARVED_PUMPKIN, "Bronze Corinthian Helmet", "A bronze helmet, meant to be worn by those who fight at the front.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_bronze_corinthian_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0ID", "SSS", "S0S");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(FEATHER)));
        recipe.setIngredient('D', new RecipeChoice.ExactChoice(new ItemStack(RED_DYE)));
        Bukkit.addRecipe(recipe);
    }
}
