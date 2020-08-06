package conquestrecipesystem.Subsystems;

import conquestrecipesystem.Objects.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import conquestrecipesystem.Main;

import java.util.ArrayList;
import java.util.List;

public class ItemStackSubsystem {

    Main main = null;

    public ItemStackSubsystem(Main plugin) {
        main = plugin;
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
            SteelIngot steelIngot = new SteelIngot(main);
            return steelIngot.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SimpleBlowgun")) {
            SimpleBlowgun simpleBlowgun = new SimpleBlowgun(main);
            return simpleBlowgun.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Dart")) {
            Dart dart = new Dart(main);
            return dart.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SharpenedBamboo")) {
            SharpenedBamboo sharpenedBamboo = new SharpenedBamboo(main);
            return sharpenedBamboo.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("LargeWoodenClub")) {
            LargeWoodenClub largeWoodenClub = new LargeWoodenClub(main);
            return largeWoodenClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveFishingSpear")) {
            PrimitiveFishingSpear primitiveFishingSpear = new PrimitiveFishingSpear(main);
            return primitiveFishingSpear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveHuntingSpear")) {
            PrimitiveHuntingSpear primitiveHuntingSpear = new PrimitiveHuntingSpear(main);
            return primitiveHuntingSpear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Stonespear")) {
            Stonespear stonespear = new Stonespear(main);
            return stonespear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Boneclub")) {
            Boneclub boneclub = new Boneclub(main);
            return boneclub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SharpenedPole")) {
            SharpenedPole sharpenedPole = new SharpenedPole(main);
            return sharpenedPole.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SmallWoodenClub")) {
            SmallWoodenClub smallWoodenClub = new SmallWoodenClub(main);
            return smallWoodenClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpikedHalberd")) {
            SpikedHalberd spikedHalberd = new SpikedHalberd(main);
            return spikedHalberd.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FancyWoodenWarclub")) {
            FancyWoodenWarclub fancyWoodenWarclub = new FancyWoodenWarclub(main);
            return fancyWoodenWarclub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveWarhammer")) {
            PrimitiveWarhammer primitiveWarhammer = new PrimitiveWarhammer(main);
            return primitiveWarhammer.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpikedClub")) {
            SpikedClub spikedClub = new SpikedClub(main);
            return spikedClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SteelLongsword")) {
            SteelLongsword steelLongsword = new SteelLongsword(main);
            return steelLongsword.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SteelBastardsword")) {
            SteelBastardsword steelBastardsword = new SteelBastardsword(main);
            return steelBastardsword.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveFlail")) {
            PrimitiveFlail primitiveFlail = new PrimitiveFlail(main);
            return primitiveFlail.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpikedHatchet")) {
            SpikedHatchet spikedHatchet = new SpikedHatchet(main);
            return spikedHatchet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveStoneblade")) {
            PrimitiveStoneblade primitiveStoneblade = new PrimitiveStoneblade(main);
            return primitiveStoneblade.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootCleaver")) {
            RootCleaver rootCleaver = new RootCleaver(main);
            return rootCleaver.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootDagger")) {
            RootDagger rootDagger = new RootDagger(main);
            return rootDagger.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Roots")) {
            Roots roots = new Roots(main);
            return roots.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BigMacuahuitl")) {
            BigMacuahuitl bigMacuahuitl = new BigMacuahuitl(main);
            return bigMacuahuitl.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Cuauhololli")) {
            Cuauhololli cuauhololli = new Cuauhololli(main);
            return cuauhololli.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FeatheredMacuahuitl")) {
            FeatheredMacuahuitl featheredMacuahuitl = new FeatheredMacuahuitl(main);
            return featheredMacuahuitl.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SmallMacuahuitl")) {
            SmallMacuahuitl smallMacuahuitl = new SmallMacuahuitl(main);
            return smallMacuahuitl.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Tepoztopilli")) {
            Tepoztopilli tepoztopilli = new Tepoztopilli(main);
            return tepoztopilli.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("StoneHalberd")) {
            StoneHalberd stoneHalberd = new StoneHalberd(main);
            return stoneHalberd.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateBoots")) {
            BonePlateBoots bonePlateBoots = new BonePlateBoots(main);
            return bonePlateBoots.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateChestplate")) {
            BonePlateChestplate bonePlateChestplate = new BonePlateChestplate(main);
            return bonePlateChestplate.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateHelm")) {
            BonePlateHelm bonePlateHelm = new BonePlateHelm(main);
            return bonePlateHelm.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BonePlateLeggings")) {
            BonePlateLeggings bonePlateLeggings = new BonePlateLeggings(main);
            return bonePlateLeggings.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("BoneShield")) {
            BoneShield boneShield = new BoneShield(main);
            return boneShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("AfricanTallShield")) {
            AfricanTallShield africanTallShield = new AfricanTallShield(main);
            return africanTallShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("DecoratedChimalliShield")) {
            DecoratedChimalliShield decoratedChimalliShield = new DecoratedChimalliShield(main);
            return decoratedChimalliShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SpiralChimalliShield")) {
            SpiralChimalliShield spiralChimalliShield = new SpiralChimalliShield(main);
            return spiralChimalliShield.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalSkull")) {
            SkeletalSkull skeletalSkull = new SkeletalSkull(main);
            return skeletalSkull.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalChest")) {
            SkeletalChest skeletalChest = new SkeletalChest(main);
            return skeletalChest.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalLegs")) {
            SkeletalLegs skeletalLegs = new SkeletalLegs(main);
            return skeletalLegs.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SkeletalFeet")) {
            SkeletalFeet skeletalFeet = new SkeletalFeet(main);
            return skeletalFeet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothHelmet")) {
            RootmossClothHelmet rootmossClothHelmet = new RootmossClothHelmet(main);
            return rootmossClothHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothChestpiece")) {
            RootmossClothChestpiece rootmossClothChestpiece = new RootmossClothChestpiece(main);
            return rootmossClothChestpiece.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothLeggings")) {
            RootmossClothLeggings rootmossClothLeggings = new RootmossClothLeggings(main);
            return rootmossClothLeggings.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("RootmossClothShoes")) {
            RootmossClothShoes rootmossClothShoes = new RootmossClothShoes(main);
            return rootmossClothShoes.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Strawhat")) {
            Strawhat strawhat = new Strawhat(main);
            return strawhat.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("EagleHelmet")) {
            EagleHelmet eagleHelmet = new EagleHelmet(main);
            return eagleHelmet.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("FeatherHeaddress")) {
            FeatherHeaddress featherHeaddress = new FeatherHeaddress(main);
            return featherHeaddress.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("JaguarHelmet")) {
            JaguarHelmet jaguarHelmet = new JaguarHelmet(main);
            return jaguarHelmet.getItemStack(amount);
        }

        return null;
    }

}
