package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SimpleBlowgun {

    Main main = null;

    public SimpleBlowgun(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, BOW, "Simple Blowgun", "A tube of bamboo made to shoot darts.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_simple_blowgun");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0I0", "0I0", "0I0");
        recipe.setIngredient('I', BAMBOO);
        Bukkit.addRecipe(recipe);
    }

}
