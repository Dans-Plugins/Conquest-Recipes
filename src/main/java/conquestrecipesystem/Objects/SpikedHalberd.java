package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SpikedHalberd {

    Main main = null;

    public SpikedHalberd(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, WOODEN_AXE, "Spiked Halberd", "A Halberd fashioned out of multiple pointy sticks");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_spiked_halberd");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0IF", "0II", "I00");
        recipe.setIngredient('I', STICK);
        recipe.setIngredient('F', STRING);
        Bukkit.addRecipe(recipe);
    }
}
