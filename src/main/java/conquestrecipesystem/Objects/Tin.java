package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class Tin {

    Main main = null;

    public Tin(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, FIREWORK_STAR, "Tin Chunk", "A chunk of tin, found while sifting through gravel.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_tin");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(4));
        recipe.shape("III", "III", "III");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(GRAVEL)));
        Bukkit.addRecipe(recipe);
    }
}
