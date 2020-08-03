package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class AfricanTallShield {

    Main main = null;

    public AfricanTallShield(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, SHIELD, "African Tall Bamboo Shield", "A primitive, elongated bamboo shield.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_african_tall_shield");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("0I0", "III", "0I0");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(BAMBOO)));
        Bukkit.addRecipe(recipe);
    }
}
