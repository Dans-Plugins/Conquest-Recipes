package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.objects.*;

public class LocalRecipeService {

    ConquestRecipes conquestRecipes = null;

    public LocalRecipeService(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public void registerRecipes() {

        SteelIngot steelIngot = new SteelIngot(conquestRecipes);
        steelIngot.registerRecipe();

        SimpleBlowgun simpleBlowgun = new SimpleBlowgun(conquestRecipes);
        simpleBlowgun.registerRecipe();

        Dart dart = new Dart(conquestRecipes);
        dart.registerRecipe();

        SharpenedBamboo sharpenedBamboo = new SharpenedBamboo(conquestRecipes);
        sharpenedBamboo.registerRecipe();

        LargeWoodenClub largeWoodenClub = new LargeWoodenClub(conquestRecipes);
        largeWoodenClub.registerRecipe();

        PrimitiveFishingSpear primitiveFishingSpear = new PrimitiveFishingSpear(conquestRecipes);
        primitiveFishingSpear.registerRecipe();

        PrimitiveHuntingSpear primitiveHuntingSpear = new PrimitiveHuntingSpear(conquestRecipes);
        primitiveHuntingSpear.registerRecipe();

        Stonespear stonespear = new Stonespear(conquestRecipes);
        stonespear.registerRecipe();

        Boneclub boneclub = new Boneclub(conquestRecipes);
        boneclub.registerRecipe();

        SharpenedPole sharpenedPole = new SharpenedPole(conquestRecipes);
        sharpenedPole.registerRecipe();

        SmallWoodenClub smallWoodenClub = new SmallWoodenClub(conquestRecipes);
        smallWoodenClub.registerRecipe();

        SpikedHalberd spikedHalberd = new SpikedHalberd(conquestRecipes);
        spikedHalberd.registerRecipe();

        FancyWoodenWarclub fancyWoodenWarclub = new FancyWoodenWarclub(conquestRecipes);
        fancyWoodenWarclub.registerRecipe();

        PrimitiveWarhammer primitiveWarhammer = new PrimitiveWarhammer(conquestRecipes);
        primitiveWarhammer.registerRecipe();

        SpikedClub spikedClub = new SpikedClub(conquestRecipes);
        spikedClub.registerRecipe();

        SteelLongsword steelLongsword = new SteelLongsword(conquestRecipes);
        steelLongsword.registerRecipe();

        SteelBastardsword steelBastardsword = new SteelBastardsword(conquestRecipes);
        steelBastardsword.registerRecipe();

        PrimitiveFlail primitiveFlail = new PrimitiveFlail(conquestRecipes);
        primitiveFlail.registerRecipe();

        SpikedHatchet spikedHatchet = new SpikedHatchet(conquestRecipes);
        spikedHatchet.registerRecipe();

        PrimitiveStoneblade primitiveStoneblade = new PrimitiveStoneblade(conquestRecipes);
        primitiveStoneblade.registerRecipe();

        RootCleaver rootCleaver = new RootCleaver(conquestRecipes);
        rootCleaver.registerRecipe();

        RootDagger rootDagger = new RootDagger(conquestRecipes);
        rootDagger.registerRecipe();

        BigMacuahuitl bigMacuahuitl = new BigMacuahuitl(conquestRecipes);
        bigMacuahuitl.registerRecipe();

        Cuauhololli cuauhololli = new Cuauhololli(conquestRecipes);
        cuauhololli.registerRecipe();

        FeatheredMacuahuitl featheredMacuahuitl = new FeatheredMacuahuitl(conquestRecipes);
        featheredMacuahuitl.registerRecipe();

        SmallMacuahuitl smallMacuahuitl = new SmallMacuahuitl(conquestRecipes);
        smallMacuahuitl.registerRecipe();

        Tepoztopilli tepoztopilli = new Tepoztopilli(conquestRecipes);
        tepoztopilli.registerRecipe();

        StoneHalberd stoneHalberd = new StoneHalberd(conquestRecipes);
        stoneHalberd.registerRecipe();

        Roots roots = new Roots(conquestRecipes);
        roots.registerRecipe();

        BonePlateBoots bonePlateBoots = new BonePlateBoots(conquestRecipes);
        bonePlateBoots.registerRecipe();

        BonePlateChestplate bonePlateChestplate = new BonePlateChestplate(conquestRecipes);
        bonePlateChestplate.registerRecipe();

        BonePlateHelm bonePlateHelm = new BonePlateHelm(conquestRecipes);
        bonePlateHelm.registerRecipe();

        BonePlateLeggings bonePlateLeggings = new BonePlateLeggings(conquestRecipes);
        bonePlateLeggings.registerRecipe();

        BoneShield boneShield = new BoneShield(conquestRecipes);
        boneShield.registerRecipe();

        AfricanTallShield africanTallShield = new AfricanTallShield(conquestRecipes);
        africanTallShield.registerRecipe();

        DecoratedChimalliShield decoratedChimalliShield = new DecoratedChimalliShield(conquestRecipes);
        decoratedChimalliShield.registerRecipe();

        SpiralChimalliShield spiralChimalliShield = new SpiralChimalliShield(conquestRecipes);
        spiralChimalliShield.registerRecipe();

        SkeletalSkull skeletalSkull = new SkeletalSkull(conquestRecipes);
        skeletalSkull.registerRecipe();

        SkeletalChest skeletalChest = new SkeletalChest(conquestRecipes);
        skeletalChest.registerRecipe();

        SkeletalLegs skeletalLegs = new SkeletalLegs(conquestRecipes);
        skeletalLegs.registerRecipe();

        SkeletalFeet skeletalFeet = new SkeletalFeet(conquestRecipes);
        skeletalFeet.registerRecipe();

        RootmossClothHelmet rootmossClothHelmet = new RootmossClothHelmet(conquestRecipes);
        rootmossClothHelmet.registerRecipe();

        RootmossClothChestpiece rootmossClothChestpiece = new RootmossClothChestpiece(conquestRecipes);
        rootmossClothChestpiece.registerRecipe();

        RootmossClothLeggings rootmossClothLeggings = new RootmossClothLeggings(conquestRecipes);
        rootmossClothLeggings.registerRecipe();

        RootmossClothShoes rootmossClothShoes = new RootmossClothShoes(conquestRecipes);
        rootmossClothShoes.registerRecipe();

        Copper copper = new Copper(conquestRecipes);
        copper.registerRecipe();

        Tin tin = new Tin(conquestRecipes);
        tin.registerRecipe();

        BronzeIngot bronzeIngot = new BronzeIngot(conquestRecipes);
        bronzeIngot.registerRecipe();

        BronzeAxesword bronzeAxesword = new BronzeAxesword(conquestRecipes);
        bronzeAxesword.registerRecipe();

        BronzeBlade bronzeBlade = new BronzeBlade(conquestRecipes);
        bronzeBlade.registerRecipe();

        BronzeCorinthianHelmet bronzeCorinthianHelmet = new BronzeCorinthianHelmet(conquestRecipes);
        bronzeCorinthianHelmet.registerRecipe();

        BronzeDagger bronzeDagger = new BronzeDagger(conquestRecipes);
        bronzeDagger.registerRecipe();

        BronzeFancyFlail bronzeFancyFlail = new BronzeFancyFlail(conquestRecipes);
        bronzeFancyFlail.registerRecipe();

        BronzeGladiatorHelmet bronzeGladiatorHelmet = new BronzeGladiatorHelmet(conquestRecipes);
        bronzeGladiatorHelmet.registerRecipe();

        BronzeGlaive bronzeGlaive = new BronzeGlaive(conquestRecipes);
        bronzeGlaive.registerRecipe();

        BronzeGreatsword bronzeGreatsword = new BronzeGreatsword(conquestRecipes);
        bronzeGreatsword.registerRecipe();

        BronzeHatchet bronzeHatchet = new BronzeHatchet(conquestRecipes);
        bronzeHatchet.registerRecipe();

        BronzeKhopesh bronzeKhopesh = new BronzeKhopesh(conquestRecipes);
        bronzeKhopesh.registerRecipe();

        BronzePickaxe bronzePickaxe = new BronzePickaxe(conquestRecipes);
        bronzePickaxe.registerRecipe();

        BronzeSpade bronzeSpade = new BronzeSpade(conquestRecipes);
        bronzeSpade.registerRecipe();

        CleanHopliteShield cleanHopliteShield = new CleanHopliteShield(conquestRecipes);
        cleanHopliteShield.registerRecipe();

        FancyBronzeHelmet fancyBronzeHelmet = new FancyBronzeHelmet(conquestRecipes);
        fancyBronzeHelmet.registerRecipe();

        GreatBronzeaxe greatBronzeaxe = new GreatBronzeaxe(conquestRecipes);
        greatBronzeaxe.registerRecipe();

        GreekPlateChestpiece greekPlateChestpiece = new GreekPlateChestpiece(conquestRecipes);
        greekPlateChestpiece.registerRecipe();

        GreekPlateGreaves greekPlateGreaves = new GreekPlateGreaves(conquestRecipes);
        greekPlateGreaves.registerRecipe();

        GreekPlateHelm greekPlateHelm = new GreekPlateHelm(conquestRecipes);
        greekPlateHelm.registerRecipe();

        GreekPlateSabatons greekPlateSabatons = new GreekPlateSabatons(conquestRecipes);
        greekPlateSabatons.registerRecipe();

        Strawhat strawhat = new Strawhat(conquestRecipes);
        strawhat.registerRecipe();

        EagleHelmet eagleHelmet = new EagleHelmet(conquestRecipes);
        eagleHelmet.registerRecipe();

        FeatherHeaddress featherHeaddress = new FeatherHeaddress(conquestRecipes);
        featherHeaddress.registerRecipe();

        BronzeHoe bronzeHoe = new BronzeHoe(conquestRecipes);
        bronzeHoe.registerRecipe();

        BronzeKatar bronzeKatar = new BronzeKatar(conquestRecipes);
        bronzeKatar.registerRecipe();

        JaguarHelmet jaguarHelmet = new JaguarHelmet(conquestRecipes);
        jaguarHelmet.registerRecipe();



    }

}
