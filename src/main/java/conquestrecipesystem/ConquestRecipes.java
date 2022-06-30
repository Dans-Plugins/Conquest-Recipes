package conquestrecipesystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import conquestrecipesystem.services.CommandService;
import conquestrecipesystem.services.ItemStackService;
import conquestrecipesystem.services.RecipeService;

public final class ConquestRecipes extends JavaPlugin implements Listener {
    private final String pluginVersion = "v" + getDescription().getVersion();

    private final ItemStackService itemStackService = new ItemStackService(this);
    private final RecipeService recipeService = new RecipeService(this);

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        recipeService.registerRecipes();
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
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
}
