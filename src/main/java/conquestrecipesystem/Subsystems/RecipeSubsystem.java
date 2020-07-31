package conquestrecipesystem.Subsystems;

import conquestrecipesystem.CustomItemFixes.SteelCancel;
import conquestrecipesystem.Main;
import conquestrecipesystem.Objects.*;

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

        LargeWoodenClub largeWoodenClub = new LargeWoodenClub(main);
        largeWoodenClub.registerRecipe();

        PrimitiveFishingSpear primitiveFishingSpear = new PrimitiveFishingSpear(main);
        primitiveFishingSpear.registerRecipe();

        PrimitiveHuntingSpear primitiveHuntingSpear = new PrimitiveHuntingSpear(main);
        primitiveHuntingSpear.registerRecipe();

        Stonespear stonespear = new Stonespear(main);
        stonespear.registerRecipe();

        Boneclub boneclub = new Boneclub(main);
        boneclub.registerRecipe();

        SharpenedPole sharpenedPole = new SharpenedPole(main);
        sharpenedPole.registerRecipe();

        SmallWoodenClub smallWoodenClub = new SmallWoodenClub(main);
        smallWoodenClub.registerRecipe();

        SpikedHalberd spikedHalberd = new SpikedHalberd(main);
        spikedHalberd.registerRecipe();

        FancyWoodenWarclub fancyWoodenWarclub = new FancyWoodenWarclub(main);
        fancyWoodenWarclub.registerRecipe();

        PrimitiveWarhammer primitiveWarhammer = new PrimitiveWarhammer(main);
        primitiveWarhammer.registerRecipe();

        SpikedClub spikedClub = new SpikedClub(main);
        spikedClub.registerRecipe();

        SteelLongsword steelLongsword = new SteelLongsword(main);
        steelLongsword.registerRecipe();

        SteelBastardsword steelBastardsword = new SteelBastardsword(main);
        steelBastardsword.registerRecipe();

        SteelCancel steelCancel = new SteelCancel(main);
        steelCancel.registerRecipe();

    }

}
