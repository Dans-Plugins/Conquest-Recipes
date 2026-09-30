package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackService {
    private final ConquestRecipes conquestRecipes;

    public ItemStackService(ConquestRecipes conquestRecipes) {
        this.conquestRecipes = conquestRecipes;
    }

    public ItemStack createItemStack(int amount, Material type, String name, String description) {
        ItemStack item = new ItemStack(type, amount);
        ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(ChatColor.WHITE + name);
        List<String> lore = new ArrayList<>();
        lore.add("");
        lore.add(ChatColor.WHITE + "" + ChatColor.ITALIC + description);

        meta.setLore(lore);
        item.setItemMeta(meta);

        return item;
    }

    /**
     * A stack of the item named {@code itemName}, matched without regard to case, or null if no item in
     * {@link ItemRegistry} has that name.
     */
    public ItemStack getItemStack(String itemName, int amount) {
        ItemRegistry.Entry entry = ItemRegistry.find(itemName);
        if (entry == null) {
            return null;
        }
        return entry.getItemStack(conquestRecipes, amount);
    }

}
