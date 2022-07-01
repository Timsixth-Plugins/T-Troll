package me.timsixth.troll;

import me.timsixth.troll.command.TrollCommand;
import me.timsixth.troll.listener.FakeAdminListener;
import me.timsixth.troll.listener.FreezePlayerListener;
import me.timsixth.troll.listener.InventoryClickListener;
import me.timsixth.troll.listener.PlayerQuitListener;
import me.timsixth.troll.manager.InvManager;
import me.timsixth.troll.manager.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        InvManager invManager = new InvManager();
        UserManager userManager = new UserManager();

        getCommand("troll").setExecutor(new TrollCommand(invManager, userManager));
        Bukkit.getPluginManager().registerEvents(new FakeAdminListener(userManager), this);
        Bukkit.getPluginManager().registerEvents(new FreezePlayerListener(userManager), this);
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(this,userManager), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(userManager), this);
    }
}
