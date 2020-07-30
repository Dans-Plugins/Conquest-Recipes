package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;
import static org.bukkit.Material.BONE;

public class PrimitiveWarhammer {

    Main main = null;

    public PrimitiveWarhammer(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, STONE_AXE, "Primitive Warhammer", "A war hammer fashioned out of tied stone.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_primitive_warhammer");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("BFB", "0I0", "0I0");
        recipe.setIngredient('I', STICK);
        recipe.setIngredient('F', STRING);
        recipe.setIngredient('B', COBBLESTONE);
        Bukkit.addRecipe(recipe);
    }
}
