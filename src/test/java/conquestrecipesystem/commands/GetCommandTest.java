package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import conquestrecipesystem.services.ItemStackService;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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
        when(inventory.firstEmpty()).thenReturn(0);

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
    public void unrecognisedItemNameIsReported() {
        when(itemStackService.getItemStack("NotAnItem", 1)).thenReturn(null);

        getCommand.getItem(player, new String[]{"get", "NotAnItem", "1"});

        assertTrue(messagesSentTo(player).stream().anyMatch(message -> message.contains("isn't an item in Conquest Recipes")),
                "an unrecognised item name should be reported to the player");
        verify(inventory, never()).addItem(org.mockito.ArgumentMatchers.<ItemStack>any());
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

        assertTrue(messagesSentTo(unprivileged).stream().anyMatch(message -> message.contains("conquestrecipes.get")),
                "a player without permission should be told which permission is needed");
        verify(itemStackService, never()).getItemStack(anyString(), anyInt());
    }

    private List<String> messagesSentTo(CommandSender sender) {
        org.mockito.ArgumentCaptor<String> captor = org.mockito.ArgumentCaptor.forClass(String.class);
        verify(sender, atLeastOnce()).sendMessage(captor.capture());
        return captor.getAllValues();
    }

}
