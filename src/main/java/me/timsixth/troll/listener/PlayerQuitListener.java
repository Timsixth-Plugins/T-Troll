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

		if(userManager.getTrollBySenderUuid(player.getUniqueId()).isPresent()){
			Troll troll = userManager.getTrollBySenderUuid(player.getUniqueId()).get();
			userManager.removeTroll(troll);
			return;
		}
		if (userManager.getTrollByVictimUuid(player.getUniqueId()).isPresent()){
			Troll troll = userManager.getTrollByVictimUuid(player.getUniqueId()).get();
			userManager.removeTroll(troll);
		}
	}
}
