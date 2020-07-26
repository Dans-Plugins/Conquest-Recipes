package conquestrecipesystem.Subsystems;

import conquestrecipesystem.Main;
import conquestrecipesystem.Objects.Dart;
import conquestrecipesystem.Objects.SharpenedBamboo;
import conquestrecipesystem.Objects.SimpleBlowgun;
import conquestrecipesystem.Objects.SteelIngot;

public class RecipeSubsystem {

    Main main = null;

    public RecipeSubsystem(Main plugin) {
        main = plugin;
    }

    public void registerRecipes() {

        SteelIngot steelIngot = new SteelIngot(main);
        steelIngot.registerRecipe();

        SimpleBlowgun simpleBlowgun = new SimpleBlowgun(main);
        simpleBlowgun.registerRecipe();

        Dart dart = new Dart(main);
        dart.registerRecipe();

        SharpenedBamboo sharpenedBamboo = new SharpenedBamboo(main);
        sharpenedBamboo.registerRecipe();

    }

}
