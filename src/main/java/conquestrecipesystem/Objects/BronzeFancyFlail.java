package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class BronzeFancyFlail {

    Main main = null;

    public BronzeFancyFlail(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, IRON_AXE, "Bronze Fancy Flail", "A flail of bronze, made for those wishing to show off on the battlefield.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_bronze_fancy_flail");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("00I", "0IC", "I0S");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe.setIngredient('C', new RecipeChoice.ExactChoice(new ItemStack(CHAIN)));
        recipe.setIngredient('S', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("BronzeIngot", 1)));
        Bukkit.addRecipe(recipe);
    }
}
