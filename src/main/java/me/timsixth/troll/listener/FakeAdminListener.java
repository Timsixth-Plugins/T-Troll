package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.model.Troll;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
@RequiredArgsConstructor
public class FakeAdminListener implements Listener {

    private final UserManager userManager;

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        if (userManager.getTrollByVictimUuid(player.getUniqueId()) == null) {
            return;
        }
        Troll troll = userManager.getTrollByVictimUuid(player.getUniqueId());

        if (troll.getTrolledUser().isFakeAdmin()) {
            String msg = ConfigFile.FAKEADMIN_FORMAT;
            msg = msg.replace("{NICK}", player.getName());
            msg = msg.replace("{MESSAGE}", event.getMessage());
            msg = msg.replace(">>", "»");

            Bukkit.broadcastMessage(msg);
            event.setCancelled(true);
        }
    }
}
