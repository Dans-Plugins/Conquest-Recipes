package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

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

    /**
     * How many item names are printed per page. The chat window shows roughly ten lines by default,
     * so a page plus its header and footer is kept within that.
     */
    private static final int ITEMS_PER_PAGE = 8;

    ConquestRecipes conquestRecipes = null;

    public ListItemsCommand(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public void showList(CommandSender sender, String[] args) {

        if (!sender.hasPermission("conquestrecipes.listitems") && !sender.hasPermission("conquestrecipes.default")) {
            sender.sendMessage(ChatColor.RED + "Sorry! In order to use this command, you need the following permission: 'conquestrecipes.listitems'");
            return;
        }

        int lastPage = getLastPage();

        int page = 1;
        if (args.length > 1) {
            try {
                page = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException exception) {
                sender.sendMessage(ChatColor.RED + "'" + args[1] + "' isn't a number. Usage: /conquestrecipes list (page)");
                return;
            }

            if (page < 1 || page > lastPage) {
                sender.sendMessage(ChatColor.RED + "There is no page " + page + ". Pages run from 1 to " + lastPage + ".");
                return;
            }
        }

        int firstIndex = (page - 1) * ITEMS_PER_PAGE;
        int lastIndex = Math.min(firstIndex + ITEMS_PER_PAGE, CRAFTABLE_ITEMS.length);

        // title
        sender.sendMessage(ChatColor.AQUA + " == Conquest Recipes - Items (Page " + page + " of " + lastPage + ") == ");

        for (int index = firstIndex; index < lastIndex; index++) {
            sender.sendMessage(ChatColor.AQUA + CRAFTABLE_ITEMS[index]);
        }

        // footer
        sender.sendMessage(ChatColor.GRAY + "Showing " + (firstIndex + 1) + "-" + lastIndex + " of " + CRAFTABLE_ITEMS.length
                + " items. Use '/cr list (page)' to see the rest.");

    }

    private int getLastPage() {
        return (CRAFTABLE_ITEMS.length + ITEMS_PER_PAGE - 1) / ITEMS_PER_PAGE;
    }

}
