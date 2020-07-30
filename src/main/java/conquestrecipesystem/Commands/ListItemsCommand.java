package conquestrecipesystem.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import conquestrecipesystem.Main;

public class ListItemsCommand {

    Main main = null;

    public ListItemsCommand(Main plugin) {
        main = plugin;
    }

    public void showListToPlayer(CommandSender sender) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("conquestrecipes.listitems") || player.hasPermission("conquestrecipes.default")) {

                // title
                player.sendMessage(ChatColor.AQUA + " == More Recipes - Items == ");

                // custom
                player.sendMessage(ChatColor.AQUA + "Salt");
                player.sendMessage(ChatColor.AQUA + "Boneclub");
                player.sendMessage(ChatColor.AQUA + "Dart");
                player.sendMessage(ChatColor.AQUA + "FancyWoodenWarclub");
                player.sendMessage(ChatColor.AQUA + "LargeWoodenClub");
                player.sendMessage(ChatColor.AQUA + "PrimitiveFishingSpear");
                player.sendMessage(ChatColor.AQUA + "PrimitiveHuntingSpear");
                player.sendMessage(ChatColor.AQUA + "PrimitiveWarhammer");
                player.sendMessage(ChatColor.AQUA + "SharpenedBamboo");
                player.sendMessage(ChatColor.AQUA + "SharpenedPole");
                player.sendMessage(ChatColor.AQUA + "SimpleBlowgun");
                player.sendMessage(ChatColor.AQUA + "SmallWoodenClub");
                player.sendMessage(ChatColor.AQUA + "SpikedClub");
                player.sendMessage(ChatColor.AQUA + "SpikedHalberd");
                player.sendMessage(ChatColor.AQUA + "SteelBastardsword");
                player.sendMessage(ChatColor.AQUA + "SteelIngot");
                player.sendMessage(ChatColor.AQUA + "SteelLongsword");
                player.sendMessage(ChatColor.AQUA + "Stonespear");

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
