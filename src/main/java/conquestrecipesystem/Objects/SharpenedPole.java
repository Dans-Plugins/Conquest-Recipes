package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;
import static org.bukkit.Material.STRING;

public class SharpenedPole {

    Main main = null;

    public SharpenedPole(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, WOODEN_SWORD, "Sharpened Pole", "A long stick fashioned to a sharp point.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_sharpened_pole");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0I0", "0I0", "0I0");
        recipe.setIngredient('I', STICK);
        Bukkit.addRecipe(recipe);
    }
}
