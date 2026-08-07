package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListItemsCommand {

    /**
     * Every item name accepted by {@link conquestrecipesystem.services.ItemStackService#getItemStack(String, int)}.
     * A new entry belongs here whenever a class is added to conquestrecipesystem.objects, so that
     * /cr list and /cr get stay in agreement.
     */
    private static final String[] CRAFTABLE_ITEMS = {
            "AfricanTallShield",
            "BigMacuahuitl",
            "Boneclub",
            "BonePlateBoots",
            "BonePlateChestplate",
            "BonePlateHelm",
            "BonePlateLeggings",
            "BoneShield",
            "BronzeAxesword",
            "BronzeBlade",
            "BronzeCorinthianHelmet",
            "BronzeDagger",
            "BronzeFancyFlail",
            "BronzeGladiatorHelmet",
            "BronzeGlaive",
            "BronzeGreatsword",
            "BronzeHatchet",
            "BronzeHoe",
            "BronzeIngot",
            "BronzeKatar",
            "BronzeKhopesh",
            "BronzePickaxe",
            "BronzeSpade",
            "CleanHopliteShield",
            "Copper",
            "Cuauhololli",
            "Dart",
            "DecoratedChimalliShield",
            "EagleHelmet",
            "FancyBronzeHelmet",
            "FancyWoodenWarclub",
            "FeatheredMacuahuitl",
            "FeatherHeaddress",
            "GreatBronzeaxe",
            "GreekPlateChestpiece",
            "GreekPlateGreaves",
            "GreekPlateHelm",
            "GreekPlateSabatons",
            "JaguarHelmet",
            "LargeWoodenClub",
            "PrimitiveFishingSpear",
            "PrimitiveFlail",
            "PrimitiveHuntingSpear",
            "PrimitiveStoneblade",
            "PrimitiveWarhammer",
            "RootCleaver",
            "RootDagger",
            "RootmossClothChestpiece",
            "RootmossClothHelmet",
            "RootmossClothLeggings",
            "RootmossClothShoes",
            "Roots",
            "SharpenedBamboo",
            "SharpenedPole",
            "SimpleBlowgun",
            "SkeletalChest",
            "SkeletalFeet",
            "SkeletalLegs",
            "SkeletalSkull",
            "SmallMacuahuitl",
            "SmallWoodenClub",
            "SpikedClub",
            "SpikedHalberd",
            "SpikedHatchet",
            "SpiralChimalliShield",
            "SteelBastardsword",
            "SteelIngot",
            "SteelLongsword",
            "StoneHalberd",
            "Stonespear",
            "Strawhat",
            "Tepoztopilli",
            "Tin"
    };

    ConquestRecipes conquestRecipes = null;

    public ListItemsCommand(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public void showListToPlayer(CommandSender sender) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("conquestrecipes.listitems") || player.hasPermission("conquestrecipes.default")) {

                // title
                player.sendMessage(ChatColor.AQUA + " == Conquest Recipes - Items == ");

                for (String itemName : CRAFTABLE_ITEMS) {
                    player.sendMessage(ChatColor.AQUA + itemName);
                }

            }
            else {
                player.sendMessage(ChatColor.RED + "Sorry! In order to use this command, you need the following permission: 'conquestrecipes.listitems'");
            }

        }

    }

}
