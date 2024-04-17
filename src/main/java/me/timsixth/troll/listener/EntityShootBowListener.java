package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

@RequiredArgsConstructor
public class EntityShootBowListener implements Listener {

    private final ConfigFile configFile;
    private final TrollPlugin plugin;

    @EventHandler
    private void onEntityShoot(EntityShootBowEvent event) {
        if (!(event.getEntity() instanceof Player)) return;

        ItemStack bow = event.getBow();

        if (!bow.hasItemMeta()) return;

        ItemMeta meta = bow.getItemMeta();

        if (!meta.getDisplayName().equalsIgnoreCase(ChatUtil.chatColor(configFile.getCopier().getItemMeta().getDisplayName()))) return;

        Entity projectile = event.getProjectile();

        projectile.setMetadata("copierArrow", new FixedMetadataValue(plugin, true));
    }
}
