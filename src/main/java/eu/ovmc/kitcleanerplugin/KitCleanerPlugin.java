package eu.ovmc.kitcleanerplugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class KitCleanerPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getCommand("kitclean").setExecutor(new KitCleanCommand());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
