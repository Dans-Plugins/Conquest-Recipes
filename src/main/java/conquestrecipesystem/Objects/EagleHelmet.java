package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class EagleHelmet {

    Main main = null;

    public EagleHelmet(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, CARVED_PUMPKIN, "Eagle Helmet", "Helmet made to represent an eagle.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_eagle_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0L0", "III", "I0I");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(LEATHER)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(GRASS)));
        Bukkit.addRecipe(recipe);
    }
}
