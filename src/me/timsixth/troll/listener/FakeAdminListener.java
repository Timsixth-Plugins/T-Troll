package me.timsixth.troll.listener;

import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class FakeAdminListener implements Listener {
	
	private final UserManager userManager;
	
	public FakeAdminListener(UserManager userManager) {
		this.userManager = userManager;
	}

	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		if (userManager.isFakeAdmin(event.getPlayer())) {
			String msg = ConfigFile.FAKEADMIN_FORMAT;
			msg = msg.replace("{NICK}", event.getPlayer().getName());
			msg = msg.replace("{MESSAGE}", event.getMessage());
			msg = msg.replace(">>", "»");
			
			Bukkit.broadcastMessage(msg);
			event.setCancelled(true);
		}
	}
}
