package co.purevanilla.mcplugins.dragonannouncer;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static Plugin plugin;
    
    public void onEnable() {
        super.onEnable();
        Main.plugin = this;
        this.getCommand("dragonannounce").setExecutor(new Commands());
    }
    
    static {
        Main.plugin = null;
    }
}
