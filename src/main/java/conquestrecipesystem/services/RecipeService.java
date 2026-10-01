package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;

public class RecipeService {

    ConquestRecipes conquestRecipes = null;

    public RecipeService(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public void registerRecipes() {
        for (ItemRegistry.Entry entry : ItemRegistry.getEntries()) {
            entry.registerRecipe(conquestRecipes);
        }
    }

}
