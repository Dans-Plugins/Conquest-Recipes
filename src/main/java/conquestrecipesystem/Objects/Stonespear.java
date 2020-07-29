package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;
import static org.bukkit.Material.STRING;

public class Stonespear {

    Main main = null;

    public Stonespear(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, STONE_SWORD, "Stonespear", "A spear crafted from a sharp rock");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_stonespear");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0SF", "0IS", "I00");
        recipe.setIngredient('I', STICK);
        recipe.setIngredient('F', COBBLESTONE);
        recipe.setIngredient('S', STRING);
        Bukkit.addRecipe(recipe);
    }
}
