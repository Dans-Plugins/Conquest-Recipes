package conquestrecipesystem.Subsystems;

import conquestrecipesystem.Objects.SuperSteelIngot;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import conquestrecipesystem.Main;
import conquestrecipesystem.Objects.SteelIngot;

import java.util.ArrayList;
import java.util.List;

public class ItemStackSubsystem {

    Main main = null;

    public ItemStackSubsystem(Main plugin) {
        main = plugin;
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

    public ItemStack getItemStack(String itemName, int amount) {

        if (itemName.equalsIgnoreCase("SteelIngot")) {
            SteelIngot steelIngot = new SteelIngot(main);
            return steelIngot.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SuperSteelIngot")) {
            SuperSteelIngot superSteelIngot = new SuperSteelIngot(main);
            return superSteelIngot.getItemStack(amount);
        }

        return null;
    }

}
