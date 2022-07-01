package me.timsixth.troll.listener;

import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class FreezePlayerListener implements Listener {

    private final UserManager userManager;

    public FreezePlayerListener(UserManager userManager) {
        this.userManager = userManager;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (userManager.getTrollByVictimUuid(player.getUniqueId()) == null) {
            return;
        }
        Troll troll = userManager.getTrollByVictimUuid(player.getUniqueId());
        if (troll.getTrolledUser().isFrozen()) {
            player.sendMessage(ChatUtil.chatColor("&cYou are frozen"));
            player.teleport(event.getFrom());
        }
    }
}
