package conquestrecipesystem;

import org.bukkit.configuration.file.FileConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Pins the usage-reporting settings to the one-argument config getters. saveDefaultConfig() never
 * rewrites a config.yml that already exists, so an installation whose file predates the
 * usage-reporting block only gets the bundled key if the lookup falls through to the jar's defaults
 * -- which the one-argument getters do and the two-argument getters do not.
 */
public class UsageReportingConfigTest {

    private ConquestRecipes plugin;
    private FileConfiguration config;

    @BeforeEach
    public void setUp() {
        plugin = mock(ConquestRecipes.class);
        config = mock(FileConfiguration.class);
        when(plugin.getConfig()).thenReturn(config);
        doCallRealMethod().when(plugin).isUsageReportingEnabled();
        doCallRealMethod().when(plugin).getUsageReportingEndpoint();
        doCallRealMethod().when(plugin).getUsageReportingKey();
    }

    @Test
    public void enabledIsReadWithTheOneArgumentGetter() {
        when(config.getBoolean("usage-reporting.enabled")).thenReturn(true);

        assertTrue(plugin.isUsageReportingEnabled());
        verify(config, never()).getBoolean(eq("usage-reporting.enabled"), anyBoolean());
    }

    @Test
    public void endpointIsReadWithTheOneArgumentGetter() {
        when(config.getString("usage-reporting.endpoint")).thenReturn("http://localhost:1");

        assertEquals("http://localhost:1", plugin.getUsageReportingEndpoint());
        verify(config, never()).getString(eq("usage-reporting.endpoint"), anyString());
    }

    @Test
    public void endpointFallsBackToTheAuthorsServerWhenAbsentEverywhere() {
        when(config.getString("usage-reporting.endpoint")).thenReturn(null);

        assertEquals("https://trace.danielstephenson.dev", plugin.getUsageReportingEndpoint());
    }

    @Test
    public void keyIsReadWithTheOneArgumentGetter() {
        when(config.getString("usage-reporting.key")).thenReturn("abc");

        assertEquals("abc", plugin.getUsageReportingKey());
        verify(config, never()).getString(eq("usage-reporting.key"), anyString());
    }

    @Test
    public void keyIsEmptyWhenAbsentEverywhere() {
        when(config.getString("usage-reporting.key")).thenReturn(null);

        assertEquals("", plugin.getUsageReportingKey());
    }
}
