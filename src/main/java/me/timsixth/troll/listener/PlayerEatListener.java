package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.troll.ExplosiveAppleTroll;
import me.timsixth.troll.util.ChatUtil;
import me.timsixth.troll.util.UniversalItemMeta;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

@RequiredArgsConstructor
public class PlayerEatListener implements Listener {

    private final TrollPlugin plugin;
    private final ConfigFile configFile;

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event){
        Player player = event.getPlayer();

        UniversalItemMeta universalItemMeta = new UniversalItemMeta(event.getItem().getItemMeta());

        if (universalItemMeta.hasLocalizedName() && universalItemMeta.getLocalizedName().equalsIgnoreCase("explosive-apple")) {
            player.getWorld().createExplosion(player.getLocation(), configFile.getExplosiveAppleExplosionPower(), false);

            player.getInventory().remove(event.getItem());
            event.setCancelled(true);
        }
    }
}
