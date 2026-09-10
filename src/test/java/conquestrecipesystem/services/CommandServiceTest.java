package conquestrecipesystem.services;

import conquestrecipesystem.ConquestRecipes;
import org.bukkit.command.CommandSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandServiceTest {

    private CommandService commandService;

    @BeforeEach
    public void setUp() {
        ConquestRecipes plugin = mock(ConquestRecipes.class);
        when(plugin.getVersion()).thenReturn("v2.0.0");
        when(plugin.getItemStackService()).thenReturn(mock(ItemStackService.class));

        commandService = new CommandService(plugin);
    }

    @Test
    public void anUnrecognisedSubcommandIsAnswered() {
        CommandSender sender = mock(CommandSender.class);

        boolean handled = commandService.interpretCommand(sender, "cr", new String[]{"craft"});

        assertTrue(handled, "an unrecognised subcommand should be reported as handled, so that Bukkit's"
                + " empty usage fallback is not what answers the sender");
        List<String> messages = messagesSentTo(sender);
        assertTrue(messages.stream().anyMatch(message -> message.contains("'craft'") && message.contains("isn't a Conquest Recipes subcommand")),
                "the unrecognised subcommand should be named back to the sender, but received: " + messages);
    }

    @Test
    public void anUnrecognisedSubcommandIsToldWhatIsAccepted() {
        CommandSender sender = mock(CommandSender.class);

        commandService.interpretCommand(sender, "cr", new String[]{"lst"});

        assertNamesEverySubcommand(messagesSentTo(sender));
    }

    @Test
    public void helpIsAcceptedAsASubcommand() {
        CommandSender sender = mock(CommandSender.class);

        boolean handled = commandService.interpretCommand(sender, "cr", new String[]{"help"});

        assertTrue(handled, "/cr help should be handled");
        List<String> messages = messagesSentTo(sender);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Conquest Recipes v2.0.0")),
                "the header should name the plugin version, but received: " + messages);
        assertNamesEverySubcommand(messages);
    }

    @Test
    public void noArgumentsPrintsTheHeaderAndTheSubcommands() {
        CommandSender sender = mock(CommandSender.class);

        boolean handled = commandService.interpretCommand(sender, "conquestrecipes", new String[]{});

        assertTrue(handled, "/cr with no arguments should be handled");
        List<String> messages = messagesSentTo(sender);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Conquest Recipes v2.0.0")),
                "the header should name the plugin version, but received: " + messages);
        assertTrue(messages.stream().anyMatch(message -> message.contains("DanTheTechMan")),
                "the header should name the author, but received: " + messages);
        assertNamesEverySubcommand(messages);
    }

    @Test
    public void aLabelBelongingToAnotherPluginIsLeftAlone() {
        CommandSender sender = mock(CommandSender.class);

        boolean handled = commandService.interpretCommand(sender, "somethingelse", new String[]{"craft"});

        assertFalse(handled, "a label this plugin does not own should not be reported as handled");
        verify(sender, never()).sendMessage(anyString());
    }

    @Test
    public void listIsStillDispatchedPastTheUnrecognisedSubcommandBranch() {
        CommandSender sender = mock(CommandSender.class);
        when(sender.hasPermission("conquestrecipes.listitems")).thenReturn(true);

        boolean handled = commandService.interpretCommand(sender, "cr", new String[]{"list"});

        assertTrue(handled, "/cr list should be handled");
        List<String> messages = messagesSentTo(sender);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Conquest Recipes - Items")),
                "/cr list should reach ListItemsCommand, but received: " + messages);
        assertTrue(messages.stream().noneMatch(message -> message.contains("isn't a Conquest Recipes subcommand")),
                "a recognised subcommand should not also be reported as unrecognised, but received: " + messages);
    }

    @Test
    public void getIsStillDispatchedPastTheUnrecognisedSubcommandBranch() {
        CommandSender console = mock(CommandSender.class);

        boolean handled = commandService.interpretCommand(console, "cr", new String[]{"get", "BronzeBlade", "1"});

        assertTrue(handled, "/cr get should be handled");
        List<String> messages = messagesSentTo(console);
        assertTrue(messages.stream().anyMatch(message -> message.contains("must be run by a player")),
                "/cr get should reach GetCommand, which refuses a non-player sender, but received: " + messages);
        assertTrue(messages.stream().noneMatch(message -> message.contains("isn't a Conquest Recipes subcommand")),
                "a recognised subcommand should not also be reported as unrecognised, but received: " + messages);
    }

    /**
     * The point of the list is that a sender who does not already know the command surface is shown all of
     * it, so all three are asserted rather than just the one that happens to be printed first. {@code listitems}
     * is accepted too, but as an alias of {@code list} it is deliberately left out of the list rather than
     * printed as a fourth entry; {@code COMMANDS.md} is where the alias is recorded.
     */
    private void assertNamesEverySubcommand(List<String> messages) {
        for (String subcommand : new String[]{"list", "get", "help"}) {
            assertTrue(messages.stream().anyMatch(message -> message.contains("/conquestrecipes " + subcommand)),
                    "the subcommand list should name '" + subcommand + "', but received: " + messages);
        }
    }

    private List<String> messagesSentTo(CommandSender sender) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(sender, atLeastOnce()).sendMessage(captor.capture());
        return captor.getAllValues();
    }

}
