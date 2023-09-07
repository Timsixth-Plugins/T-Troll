package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Optional;

@RequiredArgsConstructor
public class PlayerMoveListener implements Listener {

    private final TrollProcessManager trollProcessManager;

    @EventHandler
    private void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Optional<TrollProcess> trollByVictimUuid = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());

        if (!trollByVictimUuid.isPresent()) return;

        TrollProcess troll = trollByVictimUuid.get();
        if (troll.getTrolledUser().isFrozen()) {
            player.sendMessage(ChatUtil.chatColor("&cYou are frozen"));
            player.teleport(event.getFrom());
        }
    }
}
