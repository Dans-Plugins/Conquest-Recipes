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

            if (player.hasPermission("morerecipes.listitems") || player.hasPermission("morerecipes.default")) {

                // title
                player.sendMessage(ChatColor.AQUA + " == More Recipes - Items == ");

                // custom
                player.sendMessage(ChatColor.AQUA + "SteelIngot");
                player.sendMessage(ChatColor.AQUA + "SuperSteelIngot");

            }
            else {
                player.sendMessage(ChatColor.RED + "Sorry! In order to use this command, you need the following permission: 'morerecipes.listitems'");
            }

        }

    }

}
