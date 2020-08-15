package conquestrecipesystem.EventHandlers;

import org.bukkit.ChatColor;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftItemEventHandler {

    public void handle(CraftItemEvent event) {
        System.out.println("Someone is crafting!");
        // if result has no lore
        if (!hasLore(event.getRecipe().getResult())) {
            System.out.println("Result does not have lore!");
            Inventory craftingInventory = event.getInventory();
            for (ItemStack item : craftingInventory) {
                if (hasLore(item)) {
                    System.out.println("Ingredients did have lore!");
                    event.setCancelled(true);
                    event.getWhoClicked().sendMessage(ChatColor.RED + "Cannot use custom items in a regular crafting recipe!");
                    return;
                }
            }
        }

    }

    public boolean hasLore(ItemStack item) {
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                if (meta.hasLore()) {
                    System.out.println("Item has lore!");
                    return true;
                }
            }
        }
        System.out.println("Item does not have lore!");
        return false;
    }

}
