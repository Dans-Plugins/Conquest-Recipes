package recipesystem;

import org.bukkit.plugin.java.JavaPlugin;
import recipesystem.Subsystems.CommandSubsystem;
import recipesystem.Subsystems.ItemStackSubsystem;
import recipesystem.Subsystems.RecipeSubsystem;

public final class Main extends JavaPlugin {

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
}
