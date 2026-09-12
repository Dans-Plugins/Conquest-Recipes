package conquestrecipesystem;

import conquestrecipesystem.services.CommandService;
import conquestrecipesystem.services.ItemStackService;
import conquestrecipesystem.services.RecipeService;
import conquestrecipesystem.trace.TraceClient;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

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
        // Writes the bundled config.yml on first run; an existing file is left alone.
        saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(this, this);
        recipeService.registerRecipes();

        // usage reporting: one event now, one per command; see config.yml
        trace = TraceClient.builder(getUsageReportingEndpoint(), getName())
                .key(getUsageReportingKey())
                .enabled(isUsageReportingEnabled())
                .logger(getLogger())
                .build();
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
}
