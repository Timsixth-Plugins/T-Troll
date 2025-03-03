package me.timsixth.troll;

import lombok.Getter;
import me.timsixth.troll.bstats.Metrics;
import me.timsixth.troll.command.AdminTrollCommand;
import me.timsixth.troll.command.TrollCommand;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.gui.ExecuteTrollAction;
import me.timsixth.troll.gui.OpenMenuAction;
import me.timsixth.troll.listener.*;
import me.timsixth.troll.manager.MenuManager;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.troll.*;
import me.timsixth.troll.tabcompleter.AdminTrollCommandTabCompleter;
import me.timsixth.troll.task.CheckIsPlayerEndermanTask;
import me.timsixth.troll.task.CheckPlayerHasHotPotato;
import me.timsixth.troll.task.CheckPlayerHasSwappedWaterTask;
import me.timsixth.troll.version.VersionChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import pl.timsixth.guilibrary.core.GUIApi;
import pl.timsixth.guilibrary.core.manager.YAMLMenuManager;
import pl.timsixth.guilibrary.core.model.action.custom.NoneClickAction;

@Getter
public class TrollPlugin extends JavaPlugin {

    private TrollManager trollManager;
    private TrollProcessManager trollProcessManager;
    private Messages messages;
    private ConfigFile configFile;
    private YAMLMenuManager menuManager;

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();

        GUIApi guiApi = new GUIApi(this);

        messages = new Messages(this);
        configFile = new ConfigFile(this, messages);

        trollProcessManager = new TrollProcessManager(this);
        trollManager = new TrollManager();

        menuManager = new MenuManager(guiApi.getActionRegistration(), configFile);

        guiApi.getActionRegistration().register(new NoneClickAction(), new ExecuteTrollAction(), new OpenMenuAction());
        guiApi.setMenuManager(menuManager);

        getCommand("troll").setExecutor(new TrollCommand(menuManager, trollProcessManager, messages, configFile));
        getCommand("atroll").setExecutor(new AdminTrollCommand(configFile, messages));
        getCommand("atroll").setTabCompleter(new AdminTrollCommandTabCompleter());

        guiApi.registerMenuListener();
        registerListeners();
        registerTrolls();

        new VersionChecker(this).checkVersion();

        new Metrics(this, 19466);

        menuManager.load();

        runTasks();
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerChatListener(trollProcessManager, configFile, this), this);
        pluginManager.registerEvents(new PlayerMoveListener(trollProcessManager), this);
        pluginManager.registerEvents(new PlayerQuitListener(trollProcessManager), this);
        pluginManager.registerEvents(new PlayerVehicleListener(trollProcessManager, messages), this);
        pluginManager.registerEvents(new PlayerDropItemListener(trollProcessManager), this);
        pluginManager.registerEvents(new EntityShootBowListener(configFile, this), this);
        pluginManager.registerEvents(new EntityDamageByEntityListener(trollProcessManager), this);
        pluginManager.registerEvents(new PlayerInteractEnityListener(messages, configFile), this);
        pluginManager.registerEvents(new PlayerEatListener(configFile), this);
    }

    private void registerTrolls() {
        trollManager.addTrolls(
                new AdminRewardTroll(messages, configFile),
                new AnvilTroll(messages),
                new ArrowSpamTroll(messages),
                new BlowUpTroll(configFile, messages),
                new ChatSpamTroll(messages),
                new CreeperSoundTroll(messages),
                new DropGlassTroll(messages, configFile, this),
                new DropHandItemTroll(messages),
                new DrunkTroll(messages, configFile),
                new EndermanTeleportTroll(messages),
                new FakeBanTroll(messages),
                new FakeCrashTroll(messages),
                new FakeExpTroll(messages, this),
                new FakeInventoryClearTroll(messages, trollProcessManager),
                new FakeJoinTroll(messages),
                new FakeOpTroll(configFile, messages),
                new FreezeTroll(messages),
                new HackerCodeTroll(messages, configFile),
                new LavaTroll(messages),
                new MinecartTroll(messages, this, configFile),
                new OpenInventoryTroll(messages),
                new PoisonTroll(messages),
                new PumpkinTroll(messages),
                new RandomPotionEffectTroll(messages),
                new RandomTeleportTroll(messages),
                new RocketWithPlayerTroll(messages),
                new RotateTroll(messages),
                new ScareTroll(messages),
                new SlimeFriendTroll(messages, configFile),
                new SpawnTeleportTroll(messages),
                new SpeedTroll(messages),
                new StrikeLightningTroll(messages),
                new SwitchFakeAdminTroll(messages, configFile),
                new TeleportUnderPlayerTroll(messages, configFile),
                new WaterTroll(messages),
                new WebTroll(messages),
                new ZombieTroll(messages),
                new BurnTroll(messages),
                new HitPlayerTroll(messages),
                new HungerTroll(messages),
                new PirateTroll(messages, configFile),
                new LuckyNameTagTroll(messages, configFile),
                new CopierTroll(messages, configFile),
                new LegendaryTraderTroll(messages),
                new ChangeDiamondsOresTroll(messages),
                new EndermanTroll(messages, configFile),
                new NoInternetTroll(messages),
                new WardenSoundTroll(messages),
                new LowerReachTroll(messages),
                new ExplosiveAppleTroll(messages),
                new ToggleGravityTroll(messages),
                new MeteorTroll(messages),
                new HotPotatoTroll(configFile, messages),
                new SwapLavaWaterTroll(messages),
                new OneHeartTroll(messages)
        );
    }

    private void runTasks() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckIsPlayerEndermanTask(trollProcessManager), 20, 0);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new CheckPlayerHasSwappedWaterTask(trollProcessManager), 20, 0);

        new CheckPlayerHasHotPotato(configFile).runTaskTimer(this, 0, 10 * 20L);
    }
}
