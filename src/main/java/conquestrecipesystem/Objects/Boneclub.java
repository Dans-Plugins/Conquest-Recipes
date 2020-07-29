package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class Boneclub {

    Main main = null;

    public Boneclub(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, STONE_AXE, "Boneclub", "A club fashioned out of sharp bones");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_boneclub");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("BBF", "0I0", "I00");
        recipe.setIngredient('I', STICK);
        recipe.setIngredient('F', STRING);
        recipe.setIngredient('B', BONE);
        Bukkit.addRecipe(recipe);
    }
}
