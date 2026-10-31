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
                        // addItem fills existing stacks of the same item before empty slots, and hands back
                        // whatever it could not store
                        Map<Integer, ItemStack> leftovers = player.getInventory().addItem(item);
                        int notStored = 0;
                        for (ItemStack leftover : leftovers.values()) {
                            notStored += leftover.getAmount();
                        }

                        if (notStored >= amount) { // nothing was stored, so nothing is given or dropped
                            player.sendMessage(ChatColor.RED + "Inventory full.");
                        }
                        else {
                            player.sendMessage(ChatColor.GREEN + "" + itemToGet + " created.");

                            // whatever didn't fit is dropped at the player's feet rather than discarded
                            for (ItemStack leftover : leftovers.values()) {
                                dropInStacks(player, leftover);
                            }
                            if (notStored > 0) {
                                player.sendMessage(ChatColor.YELLOW + "" + notStored + " didn't fit in your inventory and " + (notStored == 1 ? "was" : "were") + " dropped at your feet.");
                            }
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

    /**
     * Drops the given items at the player's feet in stacks no larger than the item's maximum stack size.
     * addItem hands back what it could not store as one stack holding the whole remainder, which can be
     * more than the item stacks to (63 swords, say); a dropped item above its maximum is not valid state.
     */
    private void dropInStacks(Player player, ItemStack leftover) {
        int maxStackSize = Math.max(1, leftover.getMaxStackSize());
        int remaining = leftover.getAmount();
        while (remaining > 0) {
            int amount = Math.min(maxStackSize, remaining);
            ItemStack stack = leftover.clone();
            stack.setAmount(amount);
            player.getWorld().dropItemNaturally(player.getLocation(), stack);
            remaining -= amount;
        }
    }

}
