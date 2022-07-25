package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Optional;

@RequiredArgsConstructor
public class FreezePlayerListener implements Listener {

    private final UserManager userManager;


    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        Optional<Troll> trollByVictimUuid = userManager.getTrollByVictimUuid(player.getUniqueId());

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
