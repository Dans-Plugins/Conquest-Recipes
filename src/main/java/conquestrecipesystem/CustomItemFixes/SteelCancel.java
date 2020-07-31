package conquestrecipesystem.CustomItemFixes;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class SteelCancel {

    Main main = null;

    public SteelCancel(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, AIR, "Air", "Air");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("S00", "000", "000");
        recipe1.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("0S0", "000", "000");
        recipe2.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe2);
        NamespacedKey key3 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe3 = new ShapedRecipe(key3, getItemStack(1));
        recipe3.shape("00S", "000", "000");
        recipe3.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe3);
        NamespacedKey key4 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe4 = new ShapedRecipe(key4, getItemStack(1));
        recipe4.shape("000", "S00", "000");
        recipe4.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe4);
        NamespacedKey key5 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe5 = new ShapedRecipe(key5, getItemStack(1));
        recipe5.shape("000", "0S0", "000");
        recipe5.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe5);
        NamespacedKey key6 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe6 = new ShapedRecipe(key6, getItemStack(1));
        recipe6.shape("000", "00S", "000");
        recipe6.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe6);
        NamespacedKey key7 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe7 = new ShapedRecipe(key7, getItemStack(1));
        recipe7.shape("000", "000", "S00");
        recipe7.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe7);
        NamespacedKey key8 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe8 = new ShapedRecipe(key8, getItemStack(1));
        recipe8.shape("000", "000", "0S0");
        recipe8.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe8);
        NamespacedKey key9 = new NamespacedKey(main, "conquest_recipes_steel_cancel");
        ShapedRecipe recipe9 = new ShapedRecipe(key9, getItemStack(1));
        recipe9.shape("000", "000", "00S");
        recipe9.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe9);
    }
}
