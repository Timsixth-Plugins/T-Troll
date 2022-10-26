package me.timsixth.troll.config;

import lombok.AccessLevel;
import lombok.Getter;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.util.ChatUtil;

@Getter
public class ConfigFile {

    @Getter(value = AccessLevel.NONE)
    private final TrollPlugin trollPlugin;
    @Getter(value = AccessLevel.NONE)
    private final Messages messages;
    private String permission;
    private String guiName;
    private String fakeAdminFormat;
    private String fakeOpFormat;
    private float powerOfExplosion;
    private String guiPrefix;

    public ConfigFile(TrollPlugin trollPlugin,Messages messages) {
        this.trollPlugin = trollPlugin;
        this.messages = messages;
        loadSettings();
    }

    private void loadSettings(){
        permission = trollPlugin.getConfig().getString("permission");
        powerOfExplosion = trollPlugin.getConfig().getInt("power_explosion");
        guiName = ChatUtil.chatColor(trollPlugin.getConfig().getString("guiname"));
        fakeAdminFormat = ChatUtil.chatColor(trollPlugin.getConfig().getString("fakeadmin_format"));
        fakeOpFormat = ChatUtil.chatColor(trollPlugin.getConfig().getString("fakeop_format"));
        guiPrefix = ChatUtil.chatColor(trollPlugin.getConfig().getString("gui_prefix"));
    }
    public void reloadConfig(){
        trollPlugin.reloadConfig();
        loadSettings();
        messages.loadMessages();
    }
}
