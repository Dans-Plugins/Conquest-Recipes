package conquestrecipesystem.Objects;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import conquestrecipesystem.Main;

import static org.bukkit.Material.*;

public class SteelIngot {

    Main main = null;

    public SteelIngot(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, IRON_INGOT, "Steel Ingot", "A durable refined alloy");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_steel_ingot");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(2));
        recipe.shape("CCC", "III", "CCC");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(IRON_INGOT)));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(COAL)));
        Bukkit.addRecipe(recipe);
    }

}
