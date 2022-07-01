package me.timsixth.troll.listener;

import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.util.ChatUtil;
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
		if (userManager.isFrozen(event.getPlayer())) {
			event.getPlayer().sendMessage(ChatUtil.chatColor("&cYou are frozen"));
			event.getPlayer().teleport(event.getFrom());
		}
	}
}
