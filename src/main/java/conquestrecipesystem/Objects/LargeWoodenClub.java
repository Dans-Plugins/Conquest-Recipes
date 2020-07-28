package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class LargeWoodenClub {

    Main main = null;
    private Object LargeWoodenClub;

    public LargeWoodenClub(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, BOW, "Large Wooden Club", "A large wooden club fashioned out of stripped logs.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(main, "conquest_recipes_large_wooden_club");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("0I0", "0I0", "0S0");
        recipe1.setIngredient('I', STRIPPED_OAK_LOG);
        recipe1.setIngredient('S', STICK);
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(main, "conquest_recipes_large_wooden_club");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("0I0", "0I0", "0S0");
        recipe2.setIngredient('I', STRIPPED_BIRCH_LOG);
        recipe2.setIngredient('S', STICK);
        Bukkit.addRecipe(recipe2);
    }

}
