package me.timsixth.troll;

import me.timsixth.troll.command.TrollCommand;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.listener.*;
import me.timsixth.troll.manager.InventoryManager;
import me.timsixth.troll.manager.TrollManager;
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
        configFile = new ConfigFile(this);
        messages = new Messages(this);
        InventoryManager inventoryManager = new InventoryManager(configFile);
        trollManager = new TrollManager(this);

        getCommand("troll").setExecutor(new TrollCommand(inventoryManager, trollManager,messages,configFile));
        registerListeners();
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerChatListener(trollManager,configFile), this);
        pluginManager.registerEvents(new PlayerMoveListener(trollManager), this);
        pluginManager.registerEvents(new InventoryClickListener(trollManager,this,messages,configFile), this);
        pluginManager.registerEvents(new PlayerQuitListener(trollManager), this);
    }
}
