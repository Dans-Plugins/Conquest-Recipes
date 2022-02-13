package conquestrecipesystem.services;

import conquestrecipesystem.objects.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import conquestrecipesystem.ConquestRecipes;

import java.util.ArrayList;
import java.util.List;

public class LocalItemStackService {

    ConquestRecipes conquestRecipes = null;

    public LocalItemStackService(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public ItemStack createItemStack(int amount, Material type, String name, String description) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + name);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.WHITE + "" + ChatColor.ITALIC + description);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    public ItemStack getItemStack(String itemName, int amount) {

        if (itemName.equalsIgnoreCase("SteelIngot")) {
            SteelIngot steelIngot = new SteelIngot(conquestRecipes);
            return steelIngot.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SimpleBlowgun")) {
            SimpleBlowgun simpleBlowgun = new SimpleBlowgun(conquestRecipes);
            return simpleBlowgun.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Dart")) {
            Dart dart = new Dart(conquestRecipes);
            return dart.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SharpenedBamboo")) {
            SharpenedBamboo sharpenedBamboo = new SharpenedBamboo(conquestRecipes);
            return sharpenedBamboo.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("LargeWoodenClub")) {
            LargeWoodenClub largeWoodenClub = new LargeWoodenClub(conquestRecipes);
            return largeWoodenClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveFishingSpear")) {
            PrimitiveFishingSpear primitiveFishingSpear = new PrimitiveFishingSpear(conquestRecipes);
            return primitiveFishingSpear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveHuntingSpear")) {
            PrimitiveHuntingSpear primitiveHuntingSpear = new PrimitiveHuntingSpear(conquestRecipes);
            return primitiveHuntingSpear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Stonespear")) {
            Stonespear stonespear = new Stonespear(conquestRecipes);
            return stonespear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Boneclub")) {
            Boneclub boneclub = new Boneclub(conquestRecipes);
            return boneclub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SharpenedPole")) {
            SharpenedPole sharpenedPole = new SharpenedPole(conquestRecipes);
            return sharpenedPole.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SmallWoodenClub")) {
            SmallWoodenClub smallWoodenClub = new SmallWoodenClub(conquestRecipes);
            return smallWoodenClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpikedHalberd")) {
            SpikedHalberd spikedHalberd = new SpikedHalberd(conquestRecipes);
            return spikedHalberd.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FancyWoodenWarclub")) {
            FancyWoodenWarclub fancyWoodenWarclub = new FancyWoodenWarclub(conquestRecipes);
            return fancyWoodenWarclub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveWarhammer")) {
            PrimitiveWarhammer primitiveWarhammer = new PrimitiveWarhammer(conquestRecipes);
            return primitiveWarhammer.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpikedClub")) {
            SpikedClub spikedClub = new SpikedClub(conquestRecipes);
            return spikedClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SteelLongsword")) {
            SteelLongsword steelLongsword = new SteelLongsword(conquestRecipes);
            return steelLongsword.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SteelBastardsword")) {
            SteelBastardsword steelBastardsword = new SteelBastardsword(conquestRecipes);
            return steelBastardsword.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveFlail")) {
            PrimitiveFlail primitiveFlail = new PrimitiveFlail(conquestRecipes);
            return primitiveFlail.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpikedHatchet")) {
            SpikedHatchet spikedHatchet = new SpikedHatchet(conquestRecipes);
            return spikedHatchet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveStoneblade")) {
            PrimitiveStoneblade primitiveStoneblade = new PrimitiveStoneblade(conquestRecipes);
            return primitiveStoneblade.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootCleaver")) {
            RootCleaver rootCleaver = new RootCleaver(conquestRecipes);
            return rootCleaver.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootDagger")) {
            RootDagger rootDagger = new RootDagger(conquestRecipes);
            return rootDagger.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Roots")) {
            Roots roots = new Roots(conquestRecipes);
            return roots.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BigMacuahuitl")) {
            BigMacuahuitl bigMacuahuitl = new BigMacuahuitl(conquestRecipes);
            return bigMacuahuitl.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Cuauhololli")) {
            Cuauhololli cuauhololli = new Cuauhololli(conquestRecipes);
            return cuauhololli.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FeatheredMacuahuitl")) {
            FeatheredMacuahuitl featheredMacuahuitl = new FeatheredMacuahuitl(conquestRecipes);
            return featheredMacuahuitl.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SmallMacuahuitl")) {
            SmallMacuahuitl smallMacuahuitl = new SmallMacuahuitl(conquestRecipes);
            return smallMacuahuitl.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Tepoztopilli")) {
            Tepoztopilli tepoztopilli = new Tepoztopilli(conquestRecipes);
            return tepoztopilli.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("StoneHalberd")) {
            StoneHalberd stoneHalberd = new StoneHalberd(conquestRecipes);
            return stoneHalberd.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateBoots")) {
            BonePlateBoots bonePlateBoots = new BonePlateBoots(conquestRecipes);
            return bonePlateBoots.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateChestplate")) {
            BonePlateChestplate bonePlateChestplate = new BonePlateChestplate(conquestRecipes);
            return bonePlateChestplate.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateHelm")) {
            BonePlateHelm bonePlateHelm = new BonePlateHelm(conquestRecipes);
            return bonePlateHelm.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateLeggings")) {
            BonePlateLeggings bonePlateLeggings = new BonePlateLeggings(conquestRecipes);
            return bonePlateLeggings.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BoneShield")) {
            BoneShield boneShield = new BoneShield(conquestRecipes);
            return boneShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("AfricanTallShield")) {
            AfricanTallShield africanTallShield = new AfricanTallShield(conquestRecipes);
            return africanTallShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("DecoratedChimalliShield")) {
            DecoratedChimalliShield decoratedChimalliShield = new DecoratedChimalliShield(conquestRecipes);
            return decoratedChimalliShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpiralChimalliShield")) {
            SpiralChimalliShield spiralChimalliShield = new SpiralChimalliShield(conquestRecipes);
            return spiralChimalliShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalSkull")) {
            SkeletalSkull skeletalSkull = new SkeletalSkull(conquestRecipes);
            return skeletalSkull.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalChest")) {
            SkeletalChest skeletalChest = new SkeletalChest(conquestRecipes);
            return skeletalChest.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalLegs")) {
            SkeletalLegs skeletalLegs = new SkeletalLegs(conquestRecipes);
            return skeletalLegs.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalFeet")) {
            SkeletalFeet skeletalFeet = new SkeletalFeet(conquestRecipes);
            return skeletalFeet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothHelmet")) {
            RootmossClothHelmet rootmossClothHelmet = new RootmossClothHelmet(conquestRecipes);
            return rootmossClothHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothChestpiece")) {
            RootmossClothChestpiece rootmossClothChestpiece = new RootmossClothChestpiece(conquestRecipes);
            return rootmossClothChestpiece.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothLeggings")) {
            RootmossClothLeggings rootmossClothLeggings = new RootmossClothLeggings(conquestRecipes);
            return rootmossClothLeggings.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothShoes")) {
            RootmossClothShoes rootmossClothShoes = new RootmossClothShoes(conquestRecipes);
            return rootmossClothShoes.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Strawhat")) {
            Strawhat strawhat = new Strawhat(conquestRecipes);
            return strawhat.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("EagleHelmet")) {
            EagleHelmet eagleHelmet = new EagleHelmet(conquestRecipes);
            return eagleHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FeatherHeaddress")) {
            FeatherHeaddress featherHeaddress = new FeatherHeaddress(conquestRecipes);
            return featherHeaddress.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("JaguarHelmet")) {
            JaguarHelmet jaguarHelmet = new JaguarHelmet(conquestRecipes);
            return jaguarHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Copper")) {
            Copper copper = new Copper(conquestRecipes);
            return copper.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Tin")) {
            Tin tin = new Tin(conquestRecipes);
            return tin.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeIngot")) {
            BronzeIngot bronzeIngot = new BronzeIngot(conquestRecipes);
            return bronzeIngot.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeAxesword")) {
            BronzeAxesword bronzeAxesword = new BronzeAxesword(conquestRecipes);
            return bronzeAxesword.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeBlade")) {
            BronzeBlade bronzeBlade = new BronzeBlade(conquestRecipes);
            return bronzeBlade.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeCorinthianHelmet")) {
            BronzeCorinthianHelmet bronzeCorinthianHelmet = new BronzeCorinthianHelmet(conquestRecipes);
            return bronzeCorinthianHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeDagger")) {
            BronzeDagger bronzeDagger = new BronzeDagger(conquestRecipes);
            return bronzeDagger.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeFancyFlail")) {
            BronzeFancyFlail bronzeFancyFlail = new BronzeFancyFlail(conquestRecipes);
            return bronzeFancyFlail.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeGladiatorHelmet")) {
            BronzeGladiatorHelmet bronzeGladiatorHelmet = new BronzeGladiatorHelmet(conquestRecipes);
            return bronzeGladiatorHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeGlaive")) {
            BronzeGlaive bronzeGlaive = new BronzeGlaive(conquestRecipes);
            return bronzeGlaive.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeGreatsword")) {
            BronzeGreatsword bronzeGreatsword = new BronzeGreatsword(conquestRecipes);
            return bronzeGreatsword.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeHatchet")) {
            BronzeHatchet bronzeHatchet = new BronzeHatchet(conquestRecipes);
            return bronzeHatchet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeHoe")) {
            BronzeHoe bronzeHoe = new BronzeHoe(conquestRecipes);
            return bronzeHoe.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeKatar")) {
            BronzeKatar bronzeKatar = new BronzeKatar(conquestRecipes);
            return bronzeKatar.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzeKhopesh")) {
            BronzeKhopesh bronzeKhopesh = new BronzeKhopesh(conquestRecipes);
            return bronzeKhopesh.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BronzePickaxe")) {
            BronzeSpade bronzeSpade = new BronzeSpade(conquestRecipes);
            return bronzeSpade.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("CleanHopliteShield")) {
            CleanHopliteShield cleanHopliteShield = new CleanHopliteShield(conquestRecipes);
            return cleanHopliteShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FancyBronzeHelmet")) {
            FancyBronzeHelmet fancyBronzeHelmet = new FancyBronzeHelmet(conquestRecipes);
            return fancyBronzeHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("GreatBronzeaxe")) {
            GreatBronzeaxe greatBronzeaxe = new GreatBronzeaxe(conquestRecipes);
            return greatBronzeaxe.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("GreekPlateChestpiece")) {
            GreekPlateChestpiece greekPlateChestpiece = new GreekPlateChestpiece(conquestRecipes);
            return greekPlateChestpiece.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("GreekPlateGreaves")) {
            GreekPlateGreaves greekPlateGreaves = new GreekPlateGreaves(conquestRecipes);
            return greekPlateGreaves.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("GreekPlateHelm")) {
            GreekPlateHelm greekPlateHelm = new GreekPlateHelm(conquestRecipes);
            return greekPlateHelm.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("GreekPlateSabatons")) {
            GreekPlateSabatons greekPlateSabatons = new GreekPlateSabatons(conquestRecipes);
            return greekPlateSabatons.getItemStack(amount);
        }

        return null;
    }

}
