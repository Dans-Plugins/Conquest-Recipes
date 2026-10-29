package conquestrecipesystem;

import conquestrecipesystem.services.ItemStackService;
import conquestrecipesystem.trace.TraceClient;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * Pins {@link ConquestRecipes#onCommand}: one usage event per command a player runs, carrying the command's name and nothing
 * the sender typed after it, and the command itself handed on to {@code CommandService}. CONFIG.md and the
 * startup notice both promise that a command event holds only the command name -- nothing about players -- so
 * the arguments, which can hold a player's chosen item name, must not reach the trace client.
 */
public class OnCommandTest {

    private ConquestRecipes plugin;
    private TraceClient trace;

    @BeforeEach
    public void setUp() throws ReflectiveOperationException {
        plugin = mock(ConquestRecipes.class);
        when(plugin.getVersion()).thenReturn("v2.0.0");
        when(plugin.getItemStackService()).thenReturn(mock(ItemStackService.class));
        doCallRealMethod().when(plugin).onCommand(any(), any(), anyString(), any());

        // A mock skips field initializers, so the trace client onEnable() would have built is put in place here.
        trace = mock(TraceClient.class);
        Field field = ConquestRecipes.class.getDeclaredField("trace");
        field.setAccessible(true);
        field.set(plugin, trace);
    }

    @Test
    public void reportsTheCommandNameAndNothingTheSenderTyped() {
        Player sender = mock(Player.class);

        plugin.onCommand(sender, command("cr"), "cr", new String[]{"help", "Notch"});

        verify(trace).report("command", null, Collections.singletonMap("name", "cr"));
        verifyNoMoreInteractions(trace);
    }

    @Test
    public void reportsUnderTheCommandsNameRatherThanTheLabelTyped() {
        Player sender = mock(Player.class);

        plugin.onCommand(sender, command("conquestrecipes"), "conquestrecipes:conquestrecipes", new String[]{});

        verify(trace).report("command", null, Collections.singletonMap("name", "conquestrecipes"));
    }

    @Test
    public void handsTheCommandOnToTheCommandService() {
        CommandSender sender = mock(CommandSender.class);

        boolean handled = plugin.onCommand(sender, command("cr"), "cr", new String[]{"help"});

        assertTrue(handled, "/cr help should be handled");
        List<String> messages = messagesSentTo(sender);
        assertTrue(messages.stream().anyMatch(message -> message.contains("Conquest Recipes v2.0.0")),
                "/cr help should reach CommandService, which prints the header, but received: " + messages);
    }

    /**
     * Bukkit only calls onCommand for commands plugin.yml declares, but the label is passed through unchecked, so
     * one CommandService does not recognise is still reported before being declined.
     */
    @Test
    public void aLabelTheCommandServiceDeclinesIsStillReported() {
        Player sender = mock(Player.class);

        boolean handled = plugin.onCommand(sender, command("cr"), "somethingelse", new String[]{});

        assertFalse(handled, "a label CommandService does not own should not be reported as handled");
        verify(sender, never()).sendMessage(anyString());
        verify(trace).report("command", null, Collections.singletonMap("name", "cr"));
    }

    /** Console, command-block and plugin-dispatched commands are handled but not reported. */
    @Test
    public void aCommandNotRunByAPlayerIsHandledButNotReported() {
        CommandSender sender = mock(CommandSender.class);

        boolean handled = plugin.onCommand(sender, command("cr"), "cr", new String[]{"help"});

        assertTrue(handled, "/cr help from the console should still be handled");
        verify(trace, never()).report(anyString(), any(), any());
    }

    private Command command(String name) {
        Command command = mock(Command.class);
        when(command.getName()).thenReturn(name);
        return command;
    }

    private List<String> messagesSentTo(CommandSender sender) {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
        verify(sender, atLeastOnce()).sendMessage(captor.capture());
        return captor.getAllValues();
    }

}
