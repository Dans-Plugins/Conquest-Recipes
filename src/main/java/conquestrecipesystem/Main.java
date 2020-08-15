package conquestrecipesystem;

import conquestrecipesystem.EventHandlers.PrepareItemCraftEventHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.plugin.java.JavaPlugin;
import conquestrecipesystem.Subsystems.CommandSubsystem;
import conquestrecipesystem.Subsystems.ItemStackSubsystem;
import conquestrecipesystem.Subsystems.RecipeSubsystem;

public final class Main extends JavaPlugin implements Listener {

    public static String version = "v0.5";

    // subsystems
    public CommandSubsystem commands = new CommandSubsystem(this);
    public ItemStackSubsystem itemstacks = new ItemStackSubsystem(this);
    public RecipeSubsystem recipes = new RecipeSubsystem(this);

    @Override
    public void onEnable() {
        recipes.registerRecipes();
    }

    @Override
    public void onDisable() {

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CommandSubsystem commandInterpreter = new CommandSubsystem(this);
        return commandInterpreter.interpretCommand(sender, label, args);
    }

    @EventHandler()
    public void onCraft(PrepareItemCraftEvent event) {
        PrepareItemCraftEventHandler handler = new PrepareItemCraftEventHandler();
        handler.handle(event);
    }
}
