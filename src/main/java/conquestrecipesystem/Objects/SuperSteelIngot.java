package conquestrecipesystem.Objects;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import conquestrecipesystem.Main;

import static org.bukkit.Material.COAL;
import static org.bukkit.Material.IRON_INGOT;

public class SuperSteelIngot {

    Main main = null;

    public SuperSteelIngot(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, IRON_INGOT, "Super Steel Ingot", "A super durable refined alloy");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_super_steel_ingot");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(2));
        recipe.shape("CCC", "III", "CCC");
        RecipeChoice.ExactChoice choice = new RecipeChoice.ExactChoice(getItemStack(1));
        recipe.setIngredient('I', choice);
        recipe.setIngredient('C', COAL);
        Bukkit.addRecipe(recipe);
    }

}

