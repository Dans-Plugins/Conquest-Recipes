package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

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

                    int amount;
                    try {
                        amount = Integer.parseInt(args[2]);
                    }
                    catch (NumberFormatException exception) {
                        player.sendMessage(ChatColor.RED + "'" + args[2] + "' isn't a number. Usage: /conquestrecipes get (itemName) (amount)");
                        return;
                    }

                    if (amount < 1) {
                        player.sendMessage(ChatColor.RED + "The amount must be at least 1.");
                        return;
                    }

                    ItemStack item = conquestRecipes.getItemStackService().getItemStack(itemToGet, amount);

                    if (item != null) {
                        // add to player's inventory
                        // if player's inventory has space
                        if (player.getInventory().firstEmpty() != -1) {
                            Map<Integer, ItemStack> leftovers = player.getInventory().addItem(item);
                            player.sendMessage(ChatColor.GREEN + "" + itemToGet + " created.");

                            // whatever didn't fit is dropped at the player's feet rather than discarded
                            int dropped = 0;
                            for (ItemStack leftover : leftovers.values()) {
                                player.getWorld().dropItemNaturally(player.getLocation(), leftover);
                                dropped += leftover.getAmount();
                            }
                            if (dropped > 0) {
                                player.sendMessage(ChatColor.YELLOW + "" + dropped + " didn't fit in your inventory and were dropped at your feet.");
                            }
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
                player.sendMessage(ChatColor.RED + "Sorry! In order to use this command, you need one of the following permissions: 'conquestrecipes.get' or 'conquestrecipes.admin'");
            }

        }
        else { // an inventory is needed to receive the item, so only a player can run this
            sender.sendMessage(ChatColor.RED + "This command must be run by a player.");
        }

    }

}
