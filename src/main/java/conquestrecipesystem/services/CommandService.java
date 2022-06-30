package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.commands.GetCommand;
import conquestrecipesystem.commands.ListItemsCommand;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class CommandService {

    ConquestRecipes conquestRecipes = null;

    public CommandService(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        if (label.equalsIgnoreCase("conquestrecipes") || label.equalsIgnoreCase("cr")) {

            if (args.length == 0) {
                sender.sendMessage(ChatColor.AQUA + " == Conquest Recipes " + conquestRecipes.getVersion() + " == ");
                sender.sendMessage(ChatColor.AQUA + "Author: DanTheTechMan");
                return true;
            }

            if (args[0].equalsIgnoreCase("get")) {
                GetCommand command = new GetCommand(conquestRecipes);
                command.getItem(sender, args);
                return true;
            }

            if (args[0].equalsIgnoreCase("listitems")) {
                ListItemsCommand command = new ListItemsCommand(conquestRecipes);
                command.showListToPlayer(sender);
                return true;
            }

        }

        return false;
    }

}
