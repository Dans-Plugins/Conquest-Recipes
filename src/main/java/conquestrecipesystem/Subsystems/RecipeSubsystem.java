package conquestrecipesystem.Subsystems;

import conquestrecipesystem.Main;
import conquestrecipesystem.Objects.SteelIngot;
import conquestrecipesystem.Objects.SuperSteelIngot;

public class RecipeSubsystem {

    Main main = null;

    public RecipeSubsystem(Main plugin) {
        main = plugin;
    }

    public void registerRecipes() {

        SteelIngot steelIngot = new SteelIngot(main);
        steelIngot.registerRecipe();

        SuperSteelIngot superSteelIngot = new SuperSteelIngot(main);
        superSteelIngot.registerRecipe();

    }

}
