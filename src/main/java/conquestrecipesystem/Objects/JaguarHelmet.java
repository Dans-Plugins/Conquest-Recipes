package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class JaguarHelmet {

    Main main = null;

    public JaguarHelmet(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, CARVED_PUMPKIN, "Jaguar Helmet", "Helmet made to represent a Jaguar.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_jaguar_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0L0", "III", "FFF");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(LEATHER)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(GRASS)));
        recipe.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(FLINT)));
        Bukkit.addRecipe(recipe);
    }
}
