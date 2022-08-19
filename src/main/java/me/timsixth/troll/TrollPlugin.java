package me.timsixth.troll;

import me.timsixth.troll.command.TrollCommand;
import me.timsixth.troll.listener.*;
import me.timsixth.troll.manager.InventoryManager;
import me.timsixth.troll.manager.TrollManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class TrollPlugin extends JavaPlugin {

    private TrollManager trollManager;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        InventoryManager inventoryManager = new InventoryManager();
        trollManager = new TrollManager(this);

        getCommand("troll").setExecutor(new TrollCommand(inventoryManager, trollManager));
        registerListeners();
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerChatListener(trollManager), this);
        pluginManager.registerEvents(new PlayerMoveListener(trollManager), this);
        pluginManager.registerEvents(new InventoryClickListener(trollManager,this), this);
        pluginManager.registerEvents(new PlayerQuitListener(trollManager), this);
    }
}
