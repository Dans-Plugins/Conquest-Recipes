package conquestrecipesystem.Subsystems;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import conquestrecipesystem.Commands.GetCommand;
import conquestrecipesystem.Commands.ListItemsCommand;
import conquestrecipesystem.Main;

public class CommandSubsystem {

    Main main = null;

    public CommandSubsystem(Main plugin) {
        main = plugin;
    }

    public boolean interpretCommand(CommandSender sender, String label, String[] args) {
        if (label.equalsIgnoreCase("conquestrecipes") || label.equalsIgnoreCase("cr")) {

            if (args.length == 0) {
                sender.sendMessage(ChatColor.AQUA + " == Conquest Recipes " + main.version + " == ");
                sender.sendMessage(ChatColor.AQUA + "Author: DanTheTechMan");
                return true;
            }

            if (args[0].equalsIgnoreCase("get")) {
                GetCommand command = new GetCommand(main);
                command.getItem(sender, args);
                return true;
            }

            if (args[0].equalsIgnoreCase("listitems")) {
                ListItemsCommand command = new ListItemsCommand(main);
                command.showListToPlayer(sender);
                return true;
            }

        }

        return false;
    }

}
