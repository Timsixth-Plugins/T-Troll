package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {

	private final TrollProcessManager trollProcessManager;

	@EventHandler
	private void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if(trollProcessManager.getTrollBySenderUuid(player.getUniqueId()).isPresent()){
			TrollProcess troll = trollProcessManager.getTrollBySenderUuid(player.getUniqueId()).get();
			trollProcessManager.removeTroll(troll);
			return;
		}
		if (trollProcessManager.getTrollByVictimUuid(player.getUniqueId()).isPresent()){
			TrollProcess troll = trollProcessManager.getTrollByVictimUuid(player.getUniqueId()).get();
			trollProcessManager.removeTroll(troll);
		}
	}
}
