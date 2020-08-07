package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class GreekPlateHelm {

    Main main = null;

    public GreekPlateHelm(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, GOLDEN_HELMET, "Bronze Greek Plate Helm", "A helm made of bronze.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(main, "conquest_recipes_greek_plate_helm_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("SSS", "S0S", "000");
        recipe1.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(main, "conquest_recipes_greek_plate_helm_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("000", "SSS", "S0S");
        recipe2.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe2);
    }
}
