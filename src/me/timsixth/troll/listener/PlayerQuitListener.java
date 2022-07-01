package me.timsixth.troll.listener;

import me.timsixth.troll.manager.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

	private final UserManager userManager;

	public PlayerQuitListener(UserManager userManager) {
		this.userManager = userManager;
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if (userManager.containsPlayer(player)) {
			userManager.removePlayer(player);
		}

		if (userManager.isFrozen(player)) {
			userManager.unFreeze(player);
		}

		if (userManager.isFakeAdmin(player)) {
			userManager.removeFakeAdmin(player);
		}
	}
}
