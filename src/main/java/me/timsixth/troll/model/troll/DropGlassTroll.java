package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class DropGlassTroll implements Troll {
    private final Messages messages;
    private final ConfigFile configFile;
    private final TrollPlugin trollPlugin;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        if (other.getInventory().firstEmpty() == -1) {
            sender.sendMessage(ChatUtil.chatColor("&7Player has a full inventory."));
            return;
        }

        userProperties.setCanNotDropGlass(true);

        other.getInventory().addItem(new ItemStack(Material.GLASS));
        if (configFile.isVictimMessage()) other.sendMessage(messages.getGetGlassButCanNotDrop());

        new BukkitRunnable() {
            @Override
            public void run() {
                if (userProperties.isCanNotDropGlass()) {
                    userProperties.setCanNotDropGlass(false);
                }
            }
        }.runTaskLater(trollPlugin, 10 * 20L);

        sender.sendMessage(messages.getGiveGlassToPlayer());
    }

    @Override
    public String getName() {
        return "DROP_GLASS";
    }
}
