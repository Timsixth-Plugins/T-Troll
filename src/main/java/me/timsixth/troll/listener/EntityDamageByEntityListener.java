package me.timsixth.troll.listener;

import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageByEntityListener implements Listener {

    @EventHandler
    private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) && !(event.getDamager() instanceof Arrow)) return;

        Arrow arrow = (Arrow) event.getDamager();

        if (!(arrow.getShooter() instanceof Player)) return;
        if (!arrow.hasMetadata("copierArrow")) return;

        Entity entity = event.getEntity();

        Location copiedEntityLocation = entity.getLocation().add(0, 0, 1);

        entity.getWorld().spawnEntity(copiedEntityLocation, entity.getType());
    }
}
