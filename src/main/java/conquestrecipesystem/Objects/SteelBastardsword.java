package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.IRON_SWORD;
import static org.bukkit.Material.STICK;

public class SteelBastardsword {

    Main main = null;

    public SteelBastardsword(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, IRON_SWORD, "Steel Bastardsword", "A long blade of steel.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_steel_bastardsword");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0S0", "0S0", "0I0");
        recipe.setIngredient('I', STICK);
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("SteelIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
