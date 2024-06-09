package me.timsixth.troll.listener;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import java.util.Optional;

@RequiredArgsConstructor
public class EntityDamageByEntityListener implements Listener {
    private final TrollProcessManager trollProcessManager;


    @EventHandler
    private void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Arrow)) return;

        Arrow arrow = (Arrow) event.getDamager();

        if (!(arrow.getShooter() instanceof Player)) return;
        if (!arrow.hasMetadata("copierArrow")) return;

        Entity entity = event.getEntity();

        Location copiedEntityLocation = entity.getLocation().add(0, 0, 1);

        entity.getWorld().spawnEntity(copiedEntityLocation, entity.getType());

        //Lower Reach
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            Optional<TrollProcess> trollProcessOptional = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());


            if (!trollProcessOptional.isPresent()) return;

            TrollProcess trollProcess = trollProcessOptional.get();
            TrolledUserProperties trolledUser = trollProcess.getTrolledUser();


            if (trolledUser.isLoweredReach()) {
                if (player.getLocation().distance(event.getEntity().getLocation()) > 1.5) event.setCancelled(true);
            }
        }
    }
}

