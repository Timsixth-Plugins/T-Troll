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
		if (userManager.isFreeze(event.getPlayer())) {
			event.getPlayer().sendMessage(ChatUtil.chatColor("&cYou are freeze"));
			event.getPlayer().teleport(event.getFrom());
		}
	}
}
