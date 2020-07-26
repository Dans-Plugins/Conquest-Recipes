package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SharpenedBamboo {

    Main main = null;

    public SharpenedBamboo(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, BAMBOO, "Sharpened Bamboo", "A piece of sharpened bamboo.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_sharpened_bamboo");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(8));
        recipe.shape("FII", "III", "III");
        recipe.setIngredient('I', BAMBOO);
        recipe.setIngredient('F', FLINT);
        Bukkit.addRecipe(recipe);
    }
}
