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
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

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
    private float explosiveAppleExplosionPower;
    private ItemStack hotPotato;

    private final File guisFile;
    private final YamlConfiguration ymlGuis;

    public ConfigFile(TrollPlugin trollPlugin, Messages messages) {
        this.trollPlugin = trollPlugin;
        this.messages = messages;

        guisFile = createFile("guis.yml");
        ymlGuis = loadYaml(guisFile);

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
        explosiveAppleExplosionPower = (float) trollPlugin.getConfig().getDouble("explosiveApplePower", 3);
        hotPotato = loadItem(Material.POTATO, "hotPotato");
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

    private YamlConfiguration loadYaml(File file) {
        YamlConfiguration ymlFile = YamlConfiguration.loadConfiguration(file);

        Reader reader = new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(file.getName())), StandardCharsets.UTF_8);

        YamlConfiguration defaultYamlFile = YamlConfiguration.loadConfiguration(reader);
        ymlFile.setDefaults(defaultYamlFile);

        ymlFile.options().copyDefaults(true);

        save(ymlFile, file);

        return ymlFile;
    }

    private void save(YamlConfiguration yamlConfiguration, File file){
        try {
            yamlConfiguration.save(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}