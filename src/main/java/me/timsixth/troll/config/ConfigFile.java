package me.timsixth.troll.config;

import lombok.Getter;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.util.ChatUtil;
@Getter
public class ConfigFile {

    private final String permission;
    private final String guiName;
    private final String fakeAdminFormat;
    private final String fakeOpFormat;

    private final float powerOfExplosion;
    private final String guiPrefix;

    public ConfigFile(TrollPlugin trollPlugin) {
        permission = trollPlugin.getConfig().getString("permission");
        powerOfExplosion = trollPlugin.getConfig().getInt("power_explosion");
        guiName = ChatUtil.chatColor(trollPlugin.getConfig().getString("guiname"));
        fakeAdminFormat = ChatUtil.chatColor(trollPlugin.getConfig().getString("fakeadmin_format"));
        fakeOpFormat = ChatUtil.chatColor(trollPlugin.getConfig().getString("fakeop_format"));
        guiPrefix = ChatUtil.chatColor(trollPlugin.getConfig().getString("gui_prefix"));
    }
}
