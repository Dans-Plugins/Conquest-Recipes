package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.material.MaterialData;

import static org.bukkit.Material.*;

public class Dart {

    Main main = null;
    private Object SharpenedBamboo;

    public Dart(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, ARROW, "Dart", "A dart of bamboo and feathers");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_dart");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(3));
        recipe.shape("000", "0I0", "0F0");
        recipe.setIngredient('I', BAMBOO);
        recipe.setIngredient('F', FEATHER);
        Bukkit.addRecipe(recipe);
    }

}
