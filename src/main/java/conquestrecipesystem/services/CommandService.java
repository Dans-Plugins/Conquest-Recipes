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

            if (args.length == 0 || args[0].equalsIgnoreCase("help")) {
                sender.sendMessage(ChatColor.AQUA + " == Conquest Recipes " + conquestRecipes.getVersion() + " == ");
                sender.sendMessage(ChatColor.AQUA + "Author: DanTheTechMan");
                sendSubcommands(sender);
                return true;
            }

            if (args[0].equalsIgnoreCase("get")) {
                GetCommand command = new GetCommand(conquestRecipes);
                command.getItem(sender, args);
                return true;
            }

            if (args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("listitems")) {
                ListItemsCommand command = new ListItemsCommand(conquestRecipes);
                command.showList(sender, args);
                return true;
            }

            // Returning false here would hand the sender back to Bukkit, which answers with the command's
            // usage message -- and plugin.yml declares none, so an unrecognised subcommand would be met
            // with silence. It is answered here instead.
            sender.sendMessage(ChatColor.RED + "'" + args[0] + "' isn't a Conquest Recipes subcommand.");
            sendSubcommands(sender);
            return true;

        }

        return false;
    }

    private void sendSubcommands(CommandSender sender) {
        sender.sendMessage(ChatColor.AQUA + "/conquestrecipes list (page) - list the items that can be crafted");
        sender.sendMessage(ChatColor.AQUA + "/conquestrecipes get (itemName) (amount) - give yourself an item");
        sender.sendMessage(ChatColor.AQUA + "/conquestrecipes help - show this list");
    }

}
