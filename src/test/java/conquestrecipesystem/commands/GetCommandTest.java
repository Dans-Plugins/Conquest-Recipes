package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.services.ItemStackService;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GetCommandTest {

    private ConquestRecipes plugin;
    private ItemStackService itemStackService;
    private Player player;
    private PlayerInventory inventory;
    private GetCommand getCommand;

    @BeforeEach
    public void setUp() {
        plugin = mock(ConquestRecipes.class);
        itemStackService = mock(ItemStackService.class);
        when(plugin.getItemStackService()).thenReturn(itemStackService);

        inventory = mock(PlayerInventory.class);

        player = mock(Player.class);
        when(player.getInventory()).thenReturn(inventory);
        when(player.hasPermission("conquestrecipes.get")).thenReturn(true);

        getCommand = new GetCommand(plugin);
    }

    @Test
    public void nonNumericAmountIsReportedAsUsageError() {
        getCommand.getItem(player, new String[]{"get", "BronzeBlade", "abc"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("isn't a number")),
                "a non-numeric amount should be reported to the player");
        verify(itemStackService, never()).getItemStack(anyString(), anyInt());
    }

    @Test
    public void zeroAmountIsRejected() {
        getCommand.getItem(player, new String[]{"get", "BronzeBlade", "0"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("at least 1")),
                "an amount below 1 should be reported to the player");
        verify(itemStackService, never()).getItemStack(anyString(), anyInt());
    }

    @Test
    public void negativeAmountIsRejected() {
        getCommand.getItem(player, new String[]{"get", "BronzeBlade", "-5"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("at least 1")),
                "a negative amount should be reported to the player");
        verify(itemStackService, never()).getItemStack(anyString(), anyInt());
    }

    @Test
    public void consoleSenderIsToldAPlayerIsRequired() {
        CommandSender console = mock(CommandSender.class);

        getCommand.getItem(console, new String[]{"get", "BronzeBlade", "1"});

        assertTrue(messagesSentTo(console).stream().anyMatch(message -> message.contains("must be run by a player")),
                "a non-player sender should be told the command requires a player");
    }

    @Test
    public void validRequestAddsTheItemToTheInventory() {
        ItemStack bronzeBlade = mock(ItemStack.class);
        when(itemStackService.getItemStack("BronzeBlade", 2)).thenReturn(bronzeBlade);

        getCommand.getItem(player, new String[]{"get", "BronzeBlade", "2"});

        verify(inventory).addItem(bronzeBlade);
        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("created")),
                "a successful request should confirm the item was created");
    }

    @Test
    public void itemsThatDoNotFitAreDroppedAtThePlayersFeet() {
        ItemStack steelLongswords = mock(ItemStack.class);
        when(itemStackService.getItemStack("SteelLongsword", 5)).thenReturn(steelLongswords);

        // a real stack, so its maximum stack size is the material's own (1 for a sword)
        HashMap<Integer, ItemStack> leftovers = new HashMap<>();
        leftovers.put(0, new ItemStack(Material.IRON_SWORD, 4));
        when(inventory.addItem(steelLongswords)).thenReturn(leftovers);

        World world = mock(World.class);
        Location feet = mock(Location.class);
        when(player.getWorld()).thenReturn(world);
        when(player.getLocation()).thenReturn(feet);

        getCommand.getItem(player, new String[]{"get", "SteelLongsword", "5"});

        // swords do not stack, so the four that did not fit are dropped one to a stack
        assertEquals(Arrays.asList(1, 1, 1, 1), amountsDroppedAt(world, feet));
        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("4 didn't fit in your inventory")),
                "the player should be told how many items were dropped");
    }

    @Test
    public void stackableItemsThatDoNotFitAreDroppedInFullStacks() {
        ItemStack steelIngots = mock(ItemStack.class);
        when(itemStackService.getItemStack("SteelIngot", 140)).thenReturn(steelIngots);

        HashMap<Integer, ItemStack> leftovers = new HashMap<>();
        leftovers.put(0, new ItemStack(Material.IRON_INGOT, 130));
        when(inventory.addItem(steelIngots)).thenReturn(leftovers);

        World world = mock(World.class);
        Location feet = mock(Location.class);
        when(player.getWorld()).thenReturn(world);
        when(player.getLocation()).thenReturn(feet);

        getCommand.getItem(player, new String[]{"get", "SteelIngot", "140"});

        // 130 ingots are two full stacks of 64 and one of 2, never one stack of 130
        assertEquals(Arrays.asList(64, 64, 2), amountsDroppedAt(world, feet));
        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("130 didn't fit in your inventory")),
                "the message should report the whole amount dropped, not the number of stacks");
    }

    @Test
    public void aSingleDroppedItemIsReportedInTheSingular() {
        ItemStack bronzeBlades = mock(ItemStack.class);
        when(itemStackService.getItemStack("BronzeBlade", 2)).thenReturn(bronzeBlades);

        HashMap<Integer, ItemStack> leftovers = new HashMap<>();
        leftovers.put(0, new ItemStack(Material.IRON_SWORD, 1));
        when(inventory.addItem(bronzeBlades)).thenReturn(leftovers);
        when(player.getWorld()).thenReturn(mock(World.class));

        getCommand.getItem(player, new String[]{"get", "BronzeBlade", "2"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("1 didn't fit in your inventory and was dropped")),
                "a single dropped item should be reported in the singular");
    }

    @Test
    public void nothingIsDroppedWhenEverythingFits() {
        ItemStack bronzeBlade = mock(ItemStack.class);
        when(itemStackService.getItemStack("BronzeBlade", 1)).thenReturn(bronzeBlade);
        when(inventory.addItem(bronzeBlade)).thenReturn(new HashMap<>());

        getCommand.getItem(player, new String[]{"get", "BronzeBlade", "1"});

        verify(player, never()).getWorld();
        assertFalse(messagesSentTo(player).stream().anyMatch(message -> message.contains("didn't fit")),
                "no drop message should be sent when everything fits");
    }

    @Test
    public void aPartialStackWithRoomIsFilledWhenNoSlotIsEmpty() {
        when(inventory.firstEmpty()).thenReturn(-1);
        ItemStack steelIngots = mock(ItemStack.class);
        when(itemStackService.getItemStack("SteelIngot", 5)).thenReturn(steelIngots);
        when(inventory.addItem(steelIngots)).thenReturn(new HashMap<>());

        getCommand.getItem(player, new String[]{"get", "SteelIngot", "5"});

        verify(inventory).addItem(steelIngots);
        List<String> messages = messagesSentTo(player);
        assertTrue(messages.stream().anyMatch(message -> message.contains("created")),
                "items that fit into an existing stack should be given even with no empty slot");
        assertFalse(messages.stream().anyMatch(message -> message.contains("Inventory full")),
                "an inventory with room in a matching stack is not full");
    }

    @Test
    public void aFullInventoryIsReportedAndNothingIsDropped() {
        when(inventory.firstEmpty()).thenReturn(-1);
        ItemStack steelLongswords = mock(ItemStack.class);
        when(itemStackService.getItemStack("SteelLongsword", 3)).thenReturn(steelLongswords);

        ItemStack leftover = mock(ItemStack.class);
        when(leftover.getAmount()).thenReturn(3);
        HashMap<Integer, ItemStack> leftovers = new HashMap<>();
        leftovers.put(0, leftover);
        when(inventory.addItem(steelLongswords)).thenReturn(leftovers);

        getCommand.getItem(player, new String[]{"get", "SteelLongsword", "3"});

        verify(player, never()).getWorld();
        List<String> messages = messagesSentTo(player);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Inventory full")),
                "a request of which nothing could be stored should be answered with 'Inventory full.'");
        assertFalse(messages.stream().anyMatch(message -> message.contains("created")),
                "nothing was given, so nothing should be reported as created");
    }

    @Test
    public void unrecognisedItemNameIsReported() {
        when(itemStackService.getItemStack("NotAnItem", 1)).thenReturn(null);

        getCommand.getItem(player, new String[]{"get", "NotAnItem", "1"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("isn't an item in Conquest Recipes")),
                "an unrecognised item name should be reported to the player");
        verify(inventory, never()).addItem(any(ItemStack.class));
    }

    @Test
    public void missingAmountArgumentShowsUsage() {
        getCommand.getItem(player, new String[]{"get", "BronzeBlade"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("Usage:")),
                "a missing amount should produce the usage message");
    }

    @Test
    public void senderWithoutPermissionIsRefused() {
        Player unprivileged = mock(Player.class);

        getCommand.getItem(unprivileged, new String[]{"get", "BronzeBlade", "1"});

        List<String> messages = messagesSentTo(unprivileged);
        assertTrue(messages.stream().anyMatch(message -> message.contains("conquestrecipes.get")),
                "a player without permission should be told which permission is needed");
        assertTrue(messages.stream().anyMatch(message -> message.contains("conquestrecipes.admin")),
                "the refusal should also name conquestrecipes.admin, which grants the command too");
        verify(itemStackService, never()).getItemStack(anyString(), anyInt());
    }

    private List<String> messagesSentTo(CommandSender sender) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(sender, atLeastOnce()).sendMessage(captor.capture());
        return captor.getAllValues();
    }

    /**
     * The amount of every stack dropped at the given location, in the order dropped. Compares amounts rather
     * than stacks because ItemStack.equals consults the server's ItemFactory, which no test starts.
     */
    private List<Integer> amountsDroppedAt(World world, Location location) {
        ArgumentCaptor<ItemStack> captor = ArgumentCaptor.forClass(ItemStack.class);
        verify(world, atLeastOnce()).dropItemNaturally(eq(location), captor.capture());
        return captor.getAllValues().stream().map(ItemStack::getAmount).collect(Collectors.toList());
    }

}
