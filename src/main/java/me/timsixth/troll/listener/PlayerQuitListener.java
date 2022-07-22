package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.model.Troll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {

	private final UserManager userManager;

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if (userManager.getTrollBySenderUuid(player.getUniqueId()) != null){
			Troll troll = userManager.getTrollBySenderUuid(player.getUniqueId());
			userManager.removeTroll(troll);
			return;
		}
		if (userManager.getTrollByVictimUuid(player.getUniqueId()) != null){
			Troll troll = userManager.getTrollByVictimUuid(player.getUniqueId());
			userManager.removeTroll(troll);
		}
	}
}
