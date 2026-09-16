package conquestrecipesystem;

import conquestrecipesystem.services.CommandService;
import conquestrecipesystem.services.ItemStackService;
import conquestrecipesystem.services.RecipeService;
import conquestrecipesystem.trace.TraceClient;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Collections;

public final class ConquestRecipes extends JavaPlugin implements Listener {
    private static final String USAGE_REPORTING_ENABLED_KEY = "usage-reporting.enabled";
    private static final String USAGE_REPORTING_ENDPOINT_KEY = "usage-reporting.endpoint";
    private static final String USAGE_REPORTING_KEY_KEY = "usage-reporting.key";
    private static final String DEFAULT_USAGE_REPORTING_ENDPOINT = "https://trace.danielstephenson.dev";

    private final String pluginVersion = "v" + getDescription().getVersion();

    private final ItemStackService itemStackService = new ItemStackService(this);
    private final RecipeService recipeService = new RecipeService(this);

    // A no-op until the config has been read, so a command arriving before
    // onEnable() finishes has something safe to report to.
    private TraceClient trace = TraceClient.disabled();

    @Override
    public void onEnable() {
        // Writes the bundled config.yml on first run; an existing file is left alone,
        // except that one from before usage reporting gets the block copied in, so
        // the switch is visible on disk before the first report is sent.
        saveDefaultConfig();
        if (copyBundledUsageReportingBlock(getConfig())) {
            saveConfig();
        }

        this.getServer().getPluginManager().registerEvents(this, this);
        recipeService.registerRecipes();

        // usage reporting: one event now, one per command; see config.yml. The
        // server-wide switch, plugins/trace/config.yml, is created by the client
        // if it is missing and honoured if it says enabled: false.
        trace = TraceClient.builder(getUsageReportingEndpoint(), getName())
                .key(getUsageReportingKey())
                .enabled(isUsageReportingEnabled())
                .serverWideConfig(getDataFolder().getParentFile())
                .logger(getLogger())
                .build();
        getLogger().info(usageReportingNotice(getName(), trace.disabledReason()));
        trace.report("startup", null, Collections.singletonMap("version", getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        trace.close();
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        trace.report("command", null, Collections.singletonMap("name", cmd.getName()));
        CommandService commandInterpreter = new CommandService(this);
        return commandInterpreter.interpretCommand(sender, label, args);
    }

    public ItemStackService getItemStackService() {
        return itemStackService;
    }

    public RecipeService getRecipeService() {
        return recipeService;
    }

    public String getVersion() {
        return pluginVersion;
    }

    // The one-argument getters, deliberately. saveDefaultConfig() never touches a
    // config.yml that already exists, so a server whose config.yml predates the
    // usage-reporting block has no such block on disk. Bukkit registers the
    // jar's config.yml as the defaults for that file, and the one-argument
    // getters fall through to them -- but the two-argument getters return their
    // explicit fallback instead, which for the key would be "" and would turn
    // reporting off on every such installation. Verified against
    // YamlConfiguration, not assumed.

    boolean isUsageReportingEnabled() {
        return getConfig().getBoolean(USAGE_REPORTING_ENABLED_KEY);
    }

    String getUsageReportingEndpoint() {
        String endpoint = getConfig().getString(USAGE_REPORTING_ENDPOINT_KEY);
        return endpoint != null ? endpoint : DEFAULT_USAGE_REPORTING_ENDPOINT;
    }

    /** Empty when no key is configured or bundled, which the client treats as "off". */
    String getUsageReportingKey() {
        String key = getConfig().getString(USAGE_REPORTING_KEY_KEY);
        return key != null ? key : "";
    }

    /**
     * Copies the bundled usage-reporting block into {@code config} when the file
     * on disk has none: a config.yml from before usage reporting existed, which
     * saveDefaultConfig() never rewrites. Reporting was already active there
     * through the one-argument getters above; this makes the switch visible in
     * the file so it can be found and turned off. The values are the jar's
     * defaults, not new literals.
     *
     * @return whether anything was copied, in which case the caller saves the file
     */
    static boolean copyBundledUsageReportingBlock(FileConfiguration config) {
        if (config.isSet("usage-reporting")) {
            return false;
        }
        Configuration defaults = config.getDefaults();
        if (defaults == null || !defaults.isSet("usage-reporting")) {
            return false;
        }
        for (String key : Arrays.asList(USAGE_REPORTING_ENABLED_KEY, USAGE_REPORTING_ENDPOINT_KEY, USAGE_REPORTING_KEY_KEY)) {
            config.set(key, defaults.get(key));
        }
        return true;
    }

    /**
     * The one console line, every startup, that says whether usage reporting is
     * on, what is sent, and how to turn it off.
     *
     * @param pluginName the name this plugin reports as
     * @param disabledReason {@link TraceClient#disabledReason()}: null when reporting is on
     */
    static String usageReportingNotice(String pluginName, String disabledReason) {
        if (disabledReason != null) {
            return "Usage reporting is off (" + disabledReason + ").";
        }
        return "Usage reporting is on: " + pluginName + " sends its name, version and command names to "
                + "https://trace.danielstephenson.dev - nothing about players or the server. "
                + "Turn it off with usage-reporting.enabled: false in this plugin's config.yml, "
                + "or for every plugin with enabled: false in plugins/trace/config.yml. "
                + "Details: https://github.com/Stephenson-Software/trace#usage-reporting";
    }
}
