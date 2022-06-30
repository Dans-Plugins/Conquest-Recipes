package conquestrecipesystem.objects;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import static org.bukkit.Material.*;

public class DecoratedChimalliShield {

    ConquestRecipes conquestRecipes = null;

    public DecoratedChimalliShield(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack getItemStack(int amount) {
        return conquestRecipes.getItemStackService().createItemStack(amount, SHIELD, "Decorated Chimalli Shield", "A primitive, but decorated shield.");
    }

    public void registerRecipe() {
        NamespacedKey key1 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_1");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, getItemStack(1));
        recipe1.shape("BBB", "BFB", "III");
        recipe1.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe1.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        recipe1.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(OAK_PLANKS)));
        Bukkit.addRecipe(recipe1);
        NamespacedKey key2 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_2");
        ShapedRecipe recipe2 = new ShapedRecipe(key2, getItemStack(1));
        recipe2.shape("BBB", "BFB", "III");
        recipe2.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(SPRUCE_PLANKS)));
        recipe2.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe2.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe2);
        NamespacedKey key3 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_3");
        ShapedRecipe recipe3 = new ShapedRecipe(key3, getItemStack(1));
        recipe3.shape("BBB", "BFB", "III");
        recipe3.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(BIRCH_PLANKS)));
        recipe3.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe3.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe3);
        NamespacedKey key4 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_4");
        ShapedRecipe recipe4 = new ShapedRecipe(key4, getItemStack(1));
        recipe4.shape("BBB", "BFB", "III");
        recipe4.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(JUNGLE_PLANKS)));
        recipe4.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe4.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe4);
        NamespacedKey key5 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_5");
        ShapedRecipe recipe5 = new ShapedRecipe(key5, getItemStack(1));
        recipe5.shape("BBB", "BFB", "III");
        recipe5.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(ACACIA_PLANKS)));
        recipe5.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe5.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe5);
        NamespacedKey key6 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_6");
        ShapedRecipe recipe6 = new ShapedRecipe(key6, getItemStack(1));
        recipe6.shape("BBB", "BFB", "III");
        recipe6.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(DARK_OAK_PLANKS)));
        recipe6.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe6.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe6);
        NamespacedKey key7 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_7");
        ShapedRecipe recipe7 = new ShapedRecipe(key7, getItemStack(1));
        recipe7.shape("BBB", "BFB", "III");
        recipe7.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(CRIMSON_PLANKS)));
        recipe7.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe7.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe7);
        NamespacedKey key8 = new NamespacedKey(conquestRecipes, "conquest_recipes_decorated_chimalli_shield_8");
        ShapedRecipe recipe8 = new ShapedRecipe(key8, getItemStack(1));
        recipe8.shape("BBB", "BFB", "III");
        recipe8.setIngredient('B', new RecipeChoice.ExactChoice(new ItemStack(WARPED_PLANKS)));
        recipe8.setIngredient('I', new RecipeChoice.ExactChoice(new ItemStack(STICK)));
        recipe8.setIngredient('F', new RecipeChoice.ExactChoice(new ItemStack(GREEN_DYE)));
        Bukkit.addRecipe(recipe8);
    }
}
