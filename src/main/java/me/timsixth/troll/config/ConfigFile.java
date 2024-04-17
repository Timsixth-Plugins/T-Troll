package me.timsixth.troll.config;

import lombok.AccessLevel;
import lombok.Getter;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import pl.timsixth.guilibrary.core.util.ItemBuilder;

import java.io.File;

@Getter
public class ConfigFile {

    @Getter(value = AccessLevel.NONE)
    private final TrollPlugin trollPlugin;
    @Getter(value = AccessLevel.NONE)
    private final Messages messages;
    private String permission;
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
    private ItemStack copier;
    private ItemStack luckyNameTag;

    private final File guisFile;
    private final YamlConfiguration ymlGuis;

    public ConfigFile(TrollPlugin trollPlugin, Messages messages) {
        this.trollPlugin = trollPlugin;
        this.messages = messages;

        guisFile = createFile("guis.yml");
        ymlGuis = YamlConfiguration.loadConfiguration(guisFile);

        loadSettings();
    }

    private void loadSettings() {
        permission = trollPlugin.getConfig().getString("permission");
        powerOfExplosion = trollPlugin.getConfig().getInt("power_explosion");
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
        copier = loadItem(Material.BOW, "copier");
        luckyNameTag = loadItem(Material.NAME_TAG, "luckyNameTag");
    }

    private ItemStack loadItem(Material material, String primarySection) {
        return new ItemBuilder(material)
                .setLore(pl.timsixth.guilibrary.core.util.ChatUtil.chatColor(trollPlugin.getConfig().getStringList(primarySection + ".lore")))
                .setName(ChatUtil.chatColor(trollPlugin.getConfig().getString(primarySection + ".displayName")))
                .toItemStack();
    }

    public void reloadConfig() {
        trollPlugin.reloadConfig();
        loadSettings();
        messages.loadMessages();
    }

    private File createFile(String name) {
        if (!trollPlugin.getDataFolder().exists()) {
            trollPlugin.getDataFolder().mkdir();
        }
        File file = new File(trollPlugin.getDataFolder(), name);
        if (!file.exists()) {
            trollPlugin.saveResource(name, true);
        }
        return file;
    }
}
