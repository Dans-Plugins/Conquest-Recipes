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

        // if result has no lore
        if (!hasLore(event.getRecipe().getResult())) {
            Inventory craftingInventory = event.getInventory();
            for (ItemStack item : craftingInventory) {
                if (hasLore(item)) {
                    event.setCancelled(true);
                    event.getWhoClicked().sendMessage(ChatColor.RED + "Cannot use custom items in a regular crafting recipe!");
                }
            }
        }

    }

    public boolean hasLore(ItemStack item) {
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta != null) {
                if (meta.hasLore()) {
                    return true;
                }
            }
        }
        return false;
    }

}
