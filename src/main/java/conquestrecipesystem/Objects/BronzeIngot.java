package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeIngot {

    Main main = null;

    public BronzeIngot(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, GOLD_INGOT, "Bronze Ingot", "An ingot of bronze made through the combination of tin and copper.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(main, "conquest_recipes_bronze_ingot_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(3));
        recipe1.shape("SSS", "III", "ICI");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("Copper", 1)));
        recipe1.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("Tin", 1)));
        recipe1.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(COAL)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(main, "conquest_recipes_bronze_ingot_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(3));
        recipe2.shape("SSS", "III", "ICI");
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("Copper", 1)));
        recipe2.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("Tin", 1)));
        recipe2.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(CHARCOAL)));
        Bukkit.addRecipe(recipe2);
    }
}
