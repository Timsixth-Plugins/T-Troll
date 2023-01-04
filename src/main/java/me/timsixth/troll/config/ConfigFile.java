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
    private String hT_enchantLoreLine;
    private String hT_thirdLoreLine;
    private String hT_swordName;
    private String hT_bookTitle;
    private String hT_bookAuthor;
    private String hT_bookContent;

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
        hT_enchantLoreLine = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollSword.LoreEnchantLine"));
        hT_thirdLoreLine = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollSword.LoreThirdLine"));
        hT_swordName = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollSword.itemName"));
        hT_bookTitle = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollBook.bookTitle"));
        hT_bookAuthor = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollBook.author"));
        hT_bookContent = ChatUtil.chatColor(trollPlugin.getConfig().getString("hackertrollBook.content"));
    }
    public void reloadConfig(){
        trollPlugin.reloadConfig();
        loadSettings();
        messages.loadMessages();
    }
}
