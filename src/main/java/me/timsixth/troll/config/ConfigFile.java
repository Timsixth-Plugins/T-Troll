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
    private String hackerTrollEnchantLoreLine;
    private String hackerTrollThirdLoreLine;
    private String hackerTrollSwordName;
    private String hackerTrollBookTitle;
    private String hackerTrollBookAuthor;
    private String hackerTrollBookContent;
    private boolean victimMessage;
    private String itemRewardName;

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
        hackerTrollEnchantLoreLine = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollSword.LoreEnchantLine"));
        hackerTrollThirdLoreLine = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollSword.LoreThirdLine"));
        hackerTrollSwordName = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollSword.itemName"));
        hackerTrollBookTitle = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollBook.bookTitle"));
        hackerTrollBookAuthor = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollBook.author"));
        hackerTrollBookContent = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollBook.content"));
        victimMessage = trollPlugin.getConfig().getBoolean("victimMessage");
        itemRewardName = ChatUtil.chatColor(trollPlugin.getConfig().getString("itemRewardName"));
    }
    public void reloadConfig(){
        trollPlugin.reloadConfig();
        loadSettings();
        messages.loadMessages();
    }
}
