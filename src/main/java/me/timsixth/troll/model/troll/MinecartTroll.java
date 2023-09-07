package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class MinecartTroll implements Troll {

    private final Messages messages;
    private final TrollPlugin trollPlugin;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        PlayerInventory otherInventory = other.getInventory();
        Location otherLocation = other.getLocation();
        if (otherInventory.firstEmpty() == -1) {
            other.getLocation().getWorld().dropItemNaturally(other.getLocation(), new ItemStack(Material.MINECART, 1));
        } else {
            otherInventory.addItem(new ItemStack(Material.MINECART, 1));
        }
        otherLocation.getBlock().setType(Material.RAIL);
        toggleMinecartTroll(sender, userProperties, other, true);
        new BukkitRunnable() {
            @Override
            public void run() {
                if (userProperties.isMinecartTroll()) {
                    toggleMinecartTroll(sender, userProperties, other, false);
                }
            }
        }.runTaskLater(trollPlugin, 10 * 20L);
    }

    @Override
    public String getName() {
        return "MINECART";
    }

    private void toggleMinecartTroll(Player player, TrolledUserProperties trolledUser, Player other, boolean minecartTroll) {
        trolledUser.setMinecartTroll(minecartTroll);
        if (minecartTroll) {
            player.sendMessage(messages.getMinecartToTroller());
            if (configFile.isVictimMessage()) other.sendMessage(messages.getMinecartToVictim());
        } else {
            if (configFile.isVictimMessage()) other.sendMessage(messages.getMinecartNotDone());
        }
    }
}
