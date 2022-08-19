package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Optional;

@RequiredArgsConstructor
public class PlayerMoveListener implements Listener {

    private final TrollManager trollManager;

    @EventHandler
    private void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Optional<Troll> trollByVictimUuid = trollManager.getTrollByVictimUuid(player.getUniqueId());

        if (!trollByVictimUuid.isPresent()) {
            return;
        }
        Troll troll = trollByVictimUuid.get();
        if (troll.getTrolledUser().isFrozen()) {
            player.sendMessage(ChatUtil.chatColor("&cYou are frozen"));
            player.teleport(event.getFrom());
        }
    }
}
