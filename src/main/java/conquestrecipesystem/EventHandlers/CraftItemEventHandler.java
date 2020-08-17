/*
package conquestrecipesystem.EventHandlers;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Material.PAPER;

public class CraftItemEventHandler {

    public void handle(CraftItemEvent event) {
//        System.out.println("Someone is crafting!");
        // if result has no lore
        ItemStack craftedItem = event.getInventory().getResult();
        if (craftedItem != null) {
            if (!isWhitelisted(craftedItem)) {
                if (!hasLore(craftedItem)) {
//                System.out.println("Result does not have lore!");
                    Inventory craftingInventory = event.getInventory();
                    for (ItemStack item : craftingInventory) {
                        if (item != null) {
                            if (hasLore(item)) {
//                            System.out.println("Ingredients did have lore!");
                                event.setCancelled(true);
                                event.getWhoClicked().sendMessage(ChatColor.RED + "Cannot use custom items in a regular crafting recipe!");
                                return;
                            }
                        }
                    }
                }
            }
        }
        else {
            System.out.println("Crafted item is null!");
        }
    }

    public boolean hasLore(ItemStack item) {
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                if (meta.hasLore()) {
//                    System.out.println("Item has lore!");
                    return true;
                }
            }
        }
//        System.out.println("Item does not have lore!");
        return false;
    }

    // to make this compatible with food spoilage
    public boolean isWhitelisted(ItemStack item) {
        switch (item.getType()) {
            case BREAD:
            case MUSHROOM_STEW:
            case RABBIT_STEW:
            case BEETROOT_SOUP:
            case CAKE:
            case PUMPKIN_PIE:
            case SUGAR:
            case COOKIE:
                return true;
        }
        return false;
    }

}
*/