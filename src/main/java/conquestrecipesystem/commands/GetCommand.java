package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GetCommand {

    ConquestRecipes conquestRecipes = null;

    public GetCommand(ConquestRecipes plugin) {
        conquestRecipes = plugin;
    }

    public void getItem(CommandSender sender, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            if (player.hasPermission("conquestrecipes.get") || player.hasPermission("conquestrecipes.admin")) {

                if (args.length > 2) {

                    String itemToGet = args[1];
                    int amount = Integer.parseInt(args[2]);

                    ItemStack item = conquestRecipes.getItemStackService().getItemStack(itemToGet, amount);

                    if (item != null) {
                        // add to player's inventory
                        // if player's inventory has space
                        if (player.getInventory().firstEmpty() != -1) {
                            player.getInventory().addItem(item);
                            player.sendMessage(ChatColor.GREEN + "" + itemToGet + " created.");
                        }
                        else { // player's inventory is full
                            player.sendMessage(ChatColor.RED + "Inventory full.");
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "That isn't an item in Conquest Recipes!");
                    }

                }
                else {
                    player.sendMessage(ChatColor.RED + "Usage: /conquestrecipes get (itemName) (amount)");
                }

            }
            else {
                player.sendMessage(ChatColor.RED + "Sorry! In order to use this command, you need the following permission: 'conquestrecipes.get'");
            }

        }

    }

}
