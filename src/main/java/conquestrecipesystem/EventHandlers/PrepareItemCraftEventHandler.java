package conquestrecipesystem.EventHandlers;

import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

public class PrepareItemCraftEventHandler {

    public void handle(PrepareItemCraftEvent event) {

        // if result has no lore
        if (!hasLore(event.getRecipe().getResult())) {
            Recipe recipe = event.getRecipe();
            Inventory craftingInventory = event.getInventory();
            for (ItemStack item : craftingInventory) {
                if (hasLore(item)) {
                    // TODO: prevent crafting
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
