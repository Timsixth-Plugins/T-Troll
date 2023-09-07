package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@RequiredArgsConstructor
public class AdminRewardTroll implements Troll {
    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        if (other.getInventory().firstEmpty() == -1) {
            sender.sendMessage(ChatUtil.chatColor("&7Player has a full inventory."));
            return;
        }

        ItemStack item = new ItemStack(Material.DIAMOND);
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.setDisplayName(configFile.getItemRewardName());
        item.setItemMeta(itemMeta);

        other.getInventory().addItem(item);

        if (configFile.isVictimMessage()) other.sendMessage(messages.getGetRewardFromAdmin());

        sender.sendMessage(messages.getGiveRewardFromAdmin());
    }

    @Override
    public String getName() {
        return "ADMIN_REWARD";
    }
}
