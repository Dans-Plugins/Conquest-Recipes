package conquestrecipesystem;

import conquestrecipesystem.trace.TraceClient;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

    @Test
    public void copiesTheBundledUsageReportingBlockOntoAFileThatLacksIt() {
        // A real YamlConfiguration, with the jar's config.yml behind it exactly as Bukkit registers
        // it, so the copy is measured against the defaults mechanism rather than a mock of it.
        YamlConfiguration onDisk = new YamlConfiguration();
        onDisk.setDefaults(bundledConfig());
        assertFalse(onDisk.isSet("usage-reporting"), "the on-disk file itself must lack the block for this test to mean anything");

        assertTrue(ConquestRecipes.copyBundledUsageReportingBlock(onDisk));

        // In the file itself now (read without falling through to the defaults), with the jar's
        // values, and a second pass has nothing to do.
        assertEquals(Boolean.TRUE, onDisk.get("usage-reporting.enabled", null));
        assertEquals("https://trace.danielstephenson.dev", onDisk.get("usage-reporting.endpoint", null));
        assertEquals(bundledConfig().getString("usage-reporting.key"), onDisk.get("usage-reporting.key", null));
        assertFalse(ConquestRecipes.copyBundledUsageReportingBlock(onDisk));
    }

    @Test
    public void leavesAnOperatorsOwnUsageReportingBlockAlone() {
        YamlConfiguration onDisk = new YamlConfiguration();
        onDisk.set("usage-reporting.enabled", false);
        onDisk.setDefaults(bundledConfig());

        assertFalse(ConquestRecipes.copyBundledUsageReportingBlock(onDisk));

        assertFalse(onDisk.getBoolean("usage-reporting.enabled"));
        assertFalse(onDisk.isSet("usage-reporting.key"), "an operator's block is not completed from the jar");
    }

    @Test
    public void doesNothingWhenNoBundledBlockExistsEither() {
        assertFalse(ConquestRecipes.copyBundledUsageReportingBlock(new YamlConfiguration()));
    }

    @Test
    public void theStartupNoticeSaysWhatIsSentAndWhereToTurnItOff() {
        String on = ConquestRecipes.usageReportingNotice("Conquest-Recipes", null);

        assertTrue(on.startsWith("Usage reporting is on: Conquest-Recipes sends its name, version and command names to https://trace.danielstephenson.dev"), on);
        assertTrue(on.contains("usage-reporting.enabled: false"), on);
        assertTrue(on.contains("plugins/trace/config.yml"), on);
        assertTrue(on.endsWith("Details: https://github.com/Stephenson-Software/trace#usage-reporting"), on);
    }

    @Test
    public void theStartupNoticeSaysWhyReportingIsOff() {
        assertEquals("Usage reporting is off (config.yml).",
                ConquestRecipes.usageReportingNotice("Conquest-Recipes", TraceClient.REASON_CONFIG));
        assertEquals("Usage reporting is off (server-wide config: plugins/trace/config.yml).",
                ConquestRecipes.usageReportingNotice("Conquest-Recipes", TraceClient.REASON_SERVER_WIDE));
    }

    /** The config.yml shipped in the jar, exactly as Bukkit registers it as the defaults for the operator's copy. */
    private static YamlConfiguration bundledConfig() {
        InputStream bundled = UsageReportingConfigTest.class.getResourceAsStream("/config.yml");
        assertNotNull(bundled, "the bundled config.yml is missing from the classpath");
        return YamlConfiguration.loadConfiguration(new InputStreamReader(bundled, StandardCharsets.UTF_8));
    }
}
