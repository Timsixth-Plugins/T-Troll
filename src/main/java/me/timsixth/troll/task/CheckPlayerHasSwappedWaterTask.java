package me.timsixth.troll.task;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.XSound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;

import java.util.Optional;

@RequiredArgsConstructor
public class CheckPlayerHasSwappedWaterTask implements Runnable {

    private final TrollProcessManager trollProcessManager;

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            Optional<TrollProcess> trollProcessOptional = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());

            if (!trollProcessOptional.isPresent()) continue;

            TrollProcess trollProcess = trollProcessOptional.get();
            TrolledUserProperties trolledUser = trollProcess.getTrolledUser();

            if (trolledUser.isSwapLavaWater()) {

                Material type = player.getLocation().getBlock().getType();
                if (type == Material.WATER) {
                    if (player.hasPotionEffect(PotionEffectType.FIRE_RESISTANCE)) continue;

                    XSound.play(player, "ENTITY_PLAYER_HURT_ON_FIRE");

                    player.damage(4);
                    player.setFireTicks(1000);
                }

                if (type == Material.LAVA) {
                    player.setFireTicks(0);
                    player.setNoDamageTicks(20);
                }
            }
        }
    }
}
