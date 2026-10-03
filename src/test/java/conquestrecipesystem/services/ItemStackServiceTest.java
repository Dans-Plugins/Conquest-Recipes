package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemStackServiceTest {

    private ItemMeta meta;
    private MockedStatic<Bukkit> bukkit;
    private ItemStackService itemStackService;

    @BeforeEach
    public void setUp() {
        // ItemStack reads and applies its meta through the server's item factory; this one hands out a
        // single meta and accepts it back, so the stack's meta is the one the assertions inspect
        meta = mock(ItemMeta.class);
        when(meta.clone()).thenReturn(meta);
        ItemFactory itemFactory = mock(ItemFactory.class);
        when(itemFactory.getItemMeta(any(Material.class))).thenReturn(meta);
        when(itemFactory.isApplicable(any(ItemMeta.class), any(Material.class))).thenReturn(true);
        when(itemFactory.asMetaFor(any(ItemMeta.class), any(Material.class))).thenReturn(meta);
        // setItemMeta adopts whatever type this returns, so it has to hand back the type it was given
        when(itemFactory.updateMaterial(any(ItemMeta.class), any(Material.class)))
                .thenAnswer(invocation -> invocation.getArgument(1));
        // hasItemMeta() asks whether the stack's meta equals no meta at all
        when(itemFactory.equals(ArgumentMatchers.<ItemMeta>isNull(), ArgumentMatchers.<ItemMeta>isNull())).thenReturn(true);
        bukkit = mockStatic(Bukkit.class);
        bukkit.when(Bukkit::getItemFactory).thenReturn(itemFactory);

        itemStackService = new ItemStackService(mock(ConquestRecipes.class));
    }

    @AfterEach
    public void tearDown() {
        bukkit.close();
    }

    @Test
    public void createItemStackUsesTheGivenTypeAndAmount() {
        ItemStack item = itemStackService.createItemStack(3, Material.IRON_SWORD, "Bronze Blade", "A blade of bronze.");

        assertEquals(Material.IRON_SWORD, item.getType());
        assertEquals(3, item.getAmount());
    }

    @Test
    public void createItemStackNamesTheItemInWhite() {
        itemStackService.createItemStack(1, Material.IRON_SWORD, "Bronze Blade", "A blade of bronze.");

        verify(meta).setDisplayName(ChatColor.WHITE + "Bronze Blade");
    }

    @Test
    public void createItemStackPutsTheDescriptionInItalicsBelowABlankLoreLine() {
        itemStackService.createItemStack(1, Material.IRON_SWORD, "Bronze Blade", "A blade of bronze.");

        assertEquals(Arrays.asList("", ChatColor.WHITE + "" + ChatColor.ITALIC + "A blade of bronze."), loreSetOn(meta));
    }

    @Test
    public void createItemStackAppliesTheMetaToTheStack() {
        ItemStack item = itemStackService.createItemStack(1, Material.IRON_SWORD, "Bronze Blade", "A blade of bronze.");

        // without setItemMeta the stack holds no meta of its own, and hasItemMeta() is false
        assertTrue(item.hasItemMeta());
        assertSame(meta, item.getItemMeta());
    }

    private List<String> loreSetOn(ItemMeta meta) {
        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<String>> lore = ArgumentCaptor.forClass(List.class);
        verify(meta).setLore(lore.capture());
        return lore.getValue();
    }

}
