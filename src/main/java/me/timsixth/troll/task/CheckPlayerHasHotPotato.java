package me.timsixth.troll.task;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class CheckPlayerHasHotPotato extends BukkitRunnable {

    private final ConfigFile configFile;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {

            ItemStack hotPotato = configFile.getHotPotato();
            if (!player.getInventory().contains(hotPotato)) return;

            player.getInventory().removeItem(hotPotato);

            World world = player.getWorld();

            world.createExplosion(player.getLocation(), 1);
        }
    }
}
