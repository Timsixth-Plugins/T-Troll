package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

@RequiredArgsConstructor
public class PlayerVehicleListener implements Listener {

    private final TrollProcessManager trollProcessManager;
    private final Messages messages;
    private final TrollPlugin trollPlugin;

    @EventHandler
    public void onVehicleEnter(VehicleEnterEvent event) {
        if (event.getVehicle().getType().equals(EntityType.MINECART)) {
            if (!(event.getEntered() instanceof Player)) return;

            Player player = (Player) event.getEntered();

            Optional<TrollProcess> trollByVictimUuid = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());

            if (!trollByVictimUuid.isPresent()) return;

            TrollProcess troll = trollByVictimUuid.get();

            if (troll.getTrolledUser().isMinecartTroll()) {
                troll.getTrolledUser().setMinecartTroll(false);
                player.sendMessage(messages.getMinecartDone());
                player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 1));
                Bukkit.getServer().getScheduler().runTask(trollPlugin, () -> player.getWorld().playSound(player.getLocation(), Sound.ENTITY_CAT_AMBIENT, 10, 2));
            }
        }
    }
}
