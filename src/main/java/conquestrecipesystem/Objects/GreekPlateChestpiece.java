package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class GreekPlateChestpiece {

    Main main = null;

    public GreekPlateChestpiece(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, GOLDEN_CHESTPLATE, "Bronze Greek Plate Chestpiece", "A chestplate of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_greek_plate_chestpiece");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("S0S", "SSS", "SSS");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
