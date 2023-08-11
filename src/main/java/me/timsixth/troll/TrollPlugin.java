package me.timsixth.troll;

import me.timsixth.troll.bstats.Metrics;
import me.timsixth.troll.command.AdminTrollCommand;
import me.timsixth.troll.command.TrollCommand;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.listener.*;
import me.timsixth.troll.manager.InventoryManager;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.tabcompleter.AdminTrollCommandTabCompleter;
import me.timsixth.troll.version.VersionChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TrollPlugin extends JavaPlugin {

    private TrollManager trollManager;
    private Messages messages;
    private ConfigFile configFile;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        messages = new Messages(this);
        configFile = new ConfigFile(this, messages);
        InventoryManager inventoryManager = new InventoryManager(configFile);
        trollManager = new TrollManager(this);

        getCommand("troll").setExecutor(new TrollCommand(inventoryManager, trollManager, messages, configFile));
        getCommand("atroll").setExecutor(new AdminTrollCommand(configFile, messages));
        getCommand("atroll").setTabCompleter(new AdminTrollCommandTabCompleter());
        registerListeners();

        new VersionChecker(this).checkVersion();

        new Metrics(this, 19466);
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerChatListener(trollManager, configFile, this), this);
        pluginManager.registerEvents(new PlayerMoveListener(trollManager), this);
        pluginManager.registerEvents(new InventoryClickListener(trollManager, this, messages, configFile), this);
        pluginManager.registerEvents(new PlayerQuitListener(trollManager), this);
        pluginManager.registerEvents(new PlayerVehicleListener(trollManager, messages), this);
    }
}
