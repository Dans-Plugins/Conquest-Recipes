package conquestrecipesystem.commands;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        CommandSender console = permittedSender();

        listItemsCommand.showList(console, new String[]{"list"});

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Conquest Recipes - Items")),
                "the console should receive the list header");
        assertTrue(messages.stream().anyMatch(message -> message.endsWith("AfricanTallShield")),
                "the console should receive the item names on the first page");
    }

    @Test
    public void theDefaultPermissionAlsoGrantsAccess() {
        CommandSender console = mock(CommandSender.class);
        when(console.hasPermission("conquestrecipes.default")).thenReturn(true);

        listItemsCommand.showList(console, new String[]{"list"});

        assertTrue(messagesSentTo(console).stream().anyMatch(message -> message.contains("Conquest Recipes - Items")),
                "conquestrecipes.default should be enough to list items");
    }

    @Test
    public void senderWithoutPermissionIsRefused() {
        CommandSender console = mock(CommandSender.class);

        listItemsCommand.showList(console, new String[]{"list"});

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("conquestrecipes.listitems")),
                "a sender without permission should be told which permission is needed");
        assertTrue(messages.stream().noneMatch(message -> message.contains("Conquest Recipes - Items")),
                "a sender without permission should not receive the list");
    }

    @Test
    public void aSinglePageFitsWithinTheChatWindow() {
        CommandSender console = permittedSender();

        listItemsCommand.showList(console, new String[]{"list"});

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.size() <= 10,
                "a page should fit the ten lines the chat window shows by default, but " + messages.size() + " lines were sent");
        assertTrue(itemLinesIn(messages).stream().allMatch(message -> message.startsWith(ChatColor.AQUA.toString())),
                "every item line should be coloured aqua");
    }

    @Test
    public void everyItemIsReachableByPagingThroughTheList() {
        List<String> namesSeen = new ArrayList<>();

        int lastPage = lastPageNumber();
        for (int page = 1; page <= lastPage; page++) {
            CommandSender console = permittedSender();
            listItemsCommand.showList(console, new String[]{"list", String.valueOf(page)});
            namesSeen.addAll(itemLinesIn(messagesSentTo(console)));
        }

        assertEquals(73, namesSeen.size(), "paging through every page should print all 73 craftable items exactly once");
        assertEquals(namesSeen.size(), new HashSet<>(namesSeen).size(), "no item should be printed on more than one page");
        assertTrue(namesSeen.contains(ChatColor.AQUA + "AfricanTallShield"), "the first item should appear on some page");
        assertTrue(namesSeen.contains(ChatColor.AQUA + "Tin"), "the last item should appear on some page");
    }

    @Test
    public void theHeaderAndFooterReportThePosition() {
        CommandSender console = permittedSender();

        listItemsCommand.showList(console, new String[]{"list", "2"});

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Page 2 of " + lastPageNumber())),
                "the header should name the current page and the total, but received: " + messages);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Showing 9-16 of 73 items")),
                "the footer should report which items are on screen, but received: " + messages);
    }

    @Test
    public void aNonNumericPageIsAnsweredWithUsage() {
        CommandSender console = permittedSender();

        listItemsCommand.showList(console, new String[]{"list", "abc"});

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("isn't a number") && message.contains("/conquestrecipes list (page)")),
                "a non-numeric page should be answered with a usage message, but received: " + messages);
        assertTrue(messages.stream().noneMatch(message -> message.contains("Conquest Recipes - Items")),
                "no page should be printed for a non-numeric page");
    }

    @Test
    public void aPageOutsideTheRangeIsRefused() {
        CommandSender console = permittedSender();

        listItemsCommand.showList(console, new String[]{"list", "0"});

        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("There is no page 0")),
                "a page below the range should be refused, but received: " + messages);

        CommandSender other = permittedSender();
        listItemsCommand.showList(other, new String[]{"list", String.valueOf(lastPageNumber() + 1)});
        assertTrue(messagesSentTo(other).stream().anyMatch(message -> message.contains("There is no page ")),
                "a page above the range should be refused");
    }

    @Test
    public void theFinalPageHoldsOnlyTheRemainingItems() {
        CommandSender console = permittedSender();

        listItemsCommand.showList(console, new String[]{"list", String.valueOf(lastPageNumber())});

        List<String> messages = messagesSentTo(console);
        assertEquals(1, itemLinesIn(messages).size(), "73 items over pages of 8 should leave one item on the final page");
        assertTrue(messages.stream().anyMatch(message -> message.contains("Showing 73-73 of 73 items")),
                "the footer should report the final item's position, but received: " + messages);
    }

    private int lastPageNumber() {
        return (73 + 7) / 8;
    }

    private CommandSender permittedSender() {
        CommandSender sender = mock(CommandSender.class);
        when(sender.hasPermission("conquestrecipes.listitems")).thenReturn(true);
        return sender;
    }

    private List<String> itemLinesIn(List<String> messages) {
        return messages.stream()
                .filter(message -> !message.contains("==") && !message.contains("Showing "))
                .collect(Collectors.toList());
    }

    private List<String> messagesSentTo(CommandSender sender) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(sender, atLeastOnce()).sendMessage(captor.capture());
        return captor.getAllValues();
    }

}
