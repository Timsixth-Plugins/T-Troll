package me.timsixth.troll.task;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.Optional;

@RequiredArgsConstructor
public class CheckIsPlayerEndermanTask implements Runnable {

    private final TrollProcessManager trollProcessManager;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Optional<TrollProcess> trollProcessOptional = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());

            if (!trollProcessOptional.isPresent()) continue;

            TrollProcess trollProcess = trollProcessOptional.get();
            TrolledUserProperties trolledUser = trollProcess.getTrolledUser();

            World world = player.getWorld();

            if (trolledUser.isEnderman()) {
                if (player.getLocation().getBlock().getType() == Material.WATER || world.hasStorm()) {
                    player.damage(1);
                }
            }
        }
    }
}
