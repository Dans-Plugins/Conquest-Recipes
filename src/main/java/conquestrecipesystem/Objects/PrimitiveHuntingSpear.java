package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class PrimitiveHuntingSpear {

    Main main = null;

    public PrimitiveHuntingSpear(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, WOODEN_SWORD, "Primitive Hunting Spear", "A spear crafted from common flint and a long stick");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_primitive_hunting_spear");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0F0", "SIS", "0I0");
        recipe.setIngredient('I', STICK);
        recipe.setIngredient('F', FLINT);
        recipe.setIngredient('S', STRING);
        Bukkit.addRecipe(recipe);
    }
}
