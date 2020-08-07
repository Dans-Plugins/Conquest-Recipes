package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.GOLDEN_CHESTPLATE;
import static org.bukkit.Material.GOLDEN_LEGGINGS;

public class GreekPlateGreaves {

    Main main = null;

    public GreekPlateGreaves(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, GOLDEN_LEGGINGS, "Bronze Greek Plate Greaves", "A pair of greaves made of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_greek_plate_greaves");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("SSS", "S0S", "S0S");
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
