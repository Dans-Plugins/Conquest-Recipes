package conquestrecipesystem;

import org.bukkit.plugin.java.JavaPlugin;
import conquestrecipesystem.Subsystems.CommandSubsystem;
import conquestrecipesystem.Subsystems.ItemStackSubsystem;
import conquestrecipesystem.Subsystems.RecipeSubsystem;

public final class Main extends JavaPlugin {

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
}
