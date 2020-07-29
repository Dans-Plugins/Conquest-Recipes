package conquestrecipesystem.Subsystems;

import conquestrecipesystem.Objects.*;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import conquestrecipesystem.Main;

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

        if (itemName.equalsIgnoreCase("SimpleBlowgun")) {
            SimpleBlowgun simpleBlowgun = new SimpleBlowgun(main);
            return simpleBlowgun.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Dart")) {
            Dart dart = new Dart(main);
            return dart.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("SharpenedBamboo")) {
            SharpenedBamboo sharpenedBamboo = new SharpenedBamboo(main);
            return sharpenedBamboo.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("LargeWoodenClub")) {
            LargeWoodenClub largeWoodenClub = new LargeWoodenClub(main);
            return largeWoodenClub.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveFishingSpear")) {
            PrimitiveFishingSpear primitiveFishingSpear = new PrimitiveFishingSpear(main);
            return primitiveFishingSpear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("PrimitiveHuntingSpear")) {
            PrimitiveHuntingSpear primitiveHuntingSpear = new PrimitiveHuntingSpear(main);
            return primitiveHuntingSpear.getItemStack(amount);
        }

        if (itemName.equalsIgnoreCase("Stonespear")) {
            Stonespear stonespear = new Stonespear(main);
            return stonespear.getItemStack(amount);
        }

        return null;
    }

}
