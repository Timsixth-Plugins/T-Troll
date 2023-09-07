package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

import java.util.Optional;

@RequiredArgsConstructor
public class PlayerDropItemListener implements Listener {

    private final TrollProcessManager trollProcessManager;

    @EventHandler
    private void onDropItem(PlayerDropItemEvent event) {
        Player player = event.getPlayer();

        Optional<TrollProcess> trollByVictimUuid = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());

        if (!trollByVictimUuid.isPresent()) return;

        TrolledUserProperties trolledUser = trollByVictimUuid.get().getTrolledUser();

        if (trolledUser.isCanNotDropGlass()) {
            double newHealth = player.getHealth() - 2.0;

            player.setHealth(newHealth);
        }
    }
}
