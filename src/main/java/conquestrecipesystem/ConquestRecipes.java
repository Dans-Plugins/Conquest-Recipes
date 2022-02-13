package conquestrecipesystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import conquestrecipesystem.services.LocalCommandService;
import conquestrecipesystem.services.LocalItemStackService;
import conquestrecipesystem.services.LocalRecipeService;

public final class ConquestRecipes extends JavaPlugin implements Listener {

    public static String version = "v1.0";

    // subsystems
    public LocalItemStackService itemstacks = new LocalItemStackService(this);
    public LocalRecipeService recipes = new LocalRecipeService(this);

    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        recipes.registerRecipes();
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        LocalCommandService commandInterpreter = new LocalCommandService(this);
        return commandInterpreter.interpretCommand(sender, label, args);
    }
/*
    @EventHandler()
    public void onCraft(CraftItemEvent event) {
        CraftItemEventHandler handler = new CraftItemEventHandler();
        handler.handle(event);
    }
 */
}
