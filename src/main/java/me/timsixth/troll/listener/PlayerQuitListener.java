package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.model.Troll;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
@RequiredArgsConstructor
public class PlayerQuitListener implements Listener {

	private final TrollManager trollManager;

	@EventHandler
	private void onQuit(PlayerQuitEvent event) {
		Player player = event.getPlayer();

		if(trollManager.getTrollBySenderUuid(player.getUniqueId()).isPresent()){
			Troll troll = trollManager.getTrollBySenderUuid(player.getUniqueId()).get();
			trollManager.removeTroll(troll);
			return;
		}
		if (trollManager.getTrollByVictimUuid(player.getUniqueId()).isPresent()){
			Troll troll = trollManager.getTrollByVictimUuid(player.getUniqueId()).get();
			trollManager.removeTroll(troll);
		}
	}
}
