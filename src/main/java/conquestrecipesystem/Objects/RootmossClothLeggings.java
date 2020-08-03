package conquestrecipesystem.Objects;

import conquestrecipesystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class RootmossClothLeggings {

    Main main = null;

    public RootmossClothLeggings(Main plugin) {
        main = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return main.itemstacks.createItemStack(amount, CHAINMAIL_LEGGINGS, "Rootmoss Cloth Leggings", "A rootmoss cloth leggings. Made of intertwined vines and roots.");
    }

    public void registerRecipe() {
        NamespacedKey key = new NamespacedKey(main, "conquest_recipes_rootmoss_cloth_leggings");
        ShapedRecipe recipe = new ShapedRecipe(key, getItemStack(1));
        recipe.shape("ILI", "L0L", "I0I");
        recipe.setIngredient('I', new RecipeChoice.ExactChoice(main.itemstacks.getItemStack("Roots", 1)));
        recipe.setIngredient('L', new RecipeChoice.ExactChoice(new ItemStack(VINE)));
        Bukkit.addRecipe(recipe);
    }
}
