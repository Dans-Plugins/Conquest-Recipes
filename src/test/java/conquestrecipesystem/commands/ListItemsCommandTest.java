package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ListItemsCommandTest {

    private ListItemsCommand listItemsCommand;

    @BeforeEach
    public void setUp() {
        listItemsCommand = new ListItemsCommand(mock(ConquestRecipes.class));
    }

    @Test
    public void consoleSenderReceivesTheItemList() {
        CommandSender console = mock(CommandSender.class);
        when(console.hasPermission("conquestrecipes.listitems")).thenReturn(true);

        listItemsCommand.showList(console);

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Conquest Recipes - Items")),
                "the console should receive the list header");
        assertTrue(messages.stream().anyMatch(message -> message.endsWith("BronzeBlade")),
                "the console should receive the item names");
    }

    @Test
    public void theDefaultPermissionAlsoGrantsAccess() {
        CommandSender console = mock(CommandSender.class);
        when(console.hasPermission("conquestrecipes.default")).thenReturn(true);

        listItemsCommand.showList(console);

        assertTrue(messagesSentTo(console).stream().anyMatch(message -> message.contains("Conquest Recipes - Items")),
                "conquestrecipes.default should be enough to list items");
    }

    @Test
    public void senderWithoutPermissionIsRefused() {
        CommandSender console = mock(CommandSender.class);

        listItemsCommand.showList(console);

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("conquestrecipes.listitems")),
                "a sender without permission should be told which permission is needed");
        assertTrue(messages.stream().noneMatch(message -> message.contains("Conquest Recipes - Items")),
                "a sender without permission should not receive the list");
    }

    @Test
    public void everyListedNameIsPrintedOnItsOwnLine() {
        CommandSender console = mock(CommandSender.class);
        when(console.hasPermission("conquestrecipes.listitems")).thenReturn(true);

        listItemsCommand.showList(console);

        List<String> messages = messagesSentTo(console);
        long itemLines = messages.stream().filter(message -> !message.contains("==")).count();
        assertTrue(itemLines > 70, "the full item list should be printed, one name per line, but " + itemLines + " lines were sent");
        assertTrue(messages.stream().allMatch(message -> message.startsWith(ChatColor.AQUA.toString())),
                "every line of the list should be coloured aqua");
    }

    private List<String> messagesSentTo(CommandSender sender) {
        org.mockito.ArgumentCaptor<String> captor = org.mockito.ArgumentCaptor.forClass(String.class);
        verify(sender, atLeastOnce()).sendMessage(captor.capture());
        return captor.getAllValues();
    }

}
