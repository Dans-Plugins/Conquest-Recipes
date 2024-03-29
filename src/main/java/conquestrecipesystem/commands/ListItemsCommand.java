package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListItemsCommand {

    ConquestRecipes conquestRecipes = null;

    public ListItemsCommand(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public void showListToPlayer(CommandSender sender) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("conquestrecipes.listitems") || player.hasPermission("conquestrecipes.default")) {

                // title
                player.sendMessage(ChatColor.AQUA + " == More Recipes - Items == ");

                // custom
                player.sendMessage(ChatColor.AQUA + "Salt");
                player.sendMessage(ChatColor.AQUA + "BigMacuahuitl");
                player.sendMessage(ChatColor.AQUA + "Boneclub");
                player.sendMessage(ChatColor.AQUA + "Cuauhololli");
                player.sendMessage(ChatColor.AQUA + "Dart");
                player.sendMessage(ChatColor.AQUA + "FancyWoodenWarclub");
                player.sendMessage(ChatColor.AQUA + "FeatheredMacuahuitl");
                player.sendMessage(ChatColor.AQUA + "LargeWoodenClub");
                player.sendMessage(ChatColor.AQUA + "PrimitiveFishingSpear");
                player.sendMessage(ChatColor.AQUA + "PrimitiveFlail");
                player.sendMessage(ChatColor.AQUA + "PrimitiveHuntingSpear");
                player.sendMessage(ChatColor.AQUA + "PrimitiveStoneblade");
                player.sendMessage(ChatColor.AQUA + "PrimitiveWarhammer");
                player.sendMessage(ChatColor.AQUA + "RootCleaver");
                player.sendMessage(ChatColor.AQUA + "RootDagger");
                player.sendMessage(ChatColor.AQUA + "Roots");
                player.sendMessage(ChatColor.AQUA + "SharpenedBamboo");
                player.sendMessage(ChatColor.AQUA + "SharpenedPole");
                player.sendMessage(ChatColor.AQUA + "SimpleBlowgun");
                player.sendMessage(ChatColor.AQUA + "SmallMacuahuitl");
                player.sendMessage(ChatColor.AQUA + "SmallWoodenClub");
                player.sendMessage(ChatColor.AQUA + "SpikedClub");
                player.sendMessage(ChatColor.AQUA + "SpikedHalberd");
                player.sendMessage(ChatColor.AQUA + "SpikedHatchet");
                player.sendMessage(ChatColor.AQUA + "SteelBastardsword");
                player.sendMessage(ChatColor.AQUA + "SteelLongsword");
                player.sendMessage(ChatColor.AQUA + "StoneHalberd");
                player.sendMessage(ChatColor.AQUA + "Stonespear");
                player.sendMessage(ChatColor.AQUA + "Tepoztopilli");

                // uncraftable
                player.sendMessage(ChatColor.AQUA + "BlazeRod");
                player.sendMessage(ChatColor.AQUA + "ChainmailBoots");
                player.sendMessage(ChatColor.AQUA + "ChainmailChestplate");
                player.sendMessage(ChatColor.AQUA + "ChainmailHelmet");
                player.sendMessage(ChatColor.AQUA + "ChainmailLeggings");
                player.sendMessage(ChatColor.AQUA + "DiamondHorseArmor");
                player.sendMessage(ChatColor.AQUA + "GoldenHorseArmor");
                player.sendMessage(ChatColor.AQUA + "GrassBlock");
                player.sendMessage(ChatColor.AQUA + "IronHorseArmor");
                player.sendMessage(ChatColor.AQUA + "Lead");
                player.sendMessage(ChatColor.AQUA + "NameTag");
                player.sendMessage(ChatColor.AQUA + "Saddle");
                player.sendMessage(ChatColor.AQUA + "String");
                player.sendMessage(ChatColor.AQUA + "TotemOfUndying");

            }
            else {
                player.sendMessage(ChatColor.RED + "Sorry! In order to use this command, you need the following permission: 'conquestrecipes.listitems'");
            }

        }

    }

}
