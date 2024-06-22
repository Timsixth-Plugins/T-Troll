package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.troll.ExplosiveAppleTroll;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

@RequiredArgsConstructor
public class PlayerEatListener implements Listener {

    private final TrollPlugin plugin;
    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();
        if (event.getItem().equals(ExplosiveAppleTroll.getExplosiveApple())) {
            player.getWorld().createExplosion(player.getLocation(), 3, false);
            if (plugin.getConfig().getBoolean("explosiveAppleVictimMessage.enabled", true)){
                player.sendMessage(ChatUtil.chatColor(plugin.getConfig().getString("explosiveAppleVictimMessage.message", "&d&lThat was an explosive apple")));
            }
            event.getItem().setAmount(event.getItem().getAmount() - 1);
            event.setCancelled(true);
        }
    }
}
