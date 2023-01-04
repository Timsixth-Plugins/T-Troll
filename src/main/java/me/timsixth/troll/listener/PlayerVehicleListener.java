package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.util.ItemUtil;
import me.timsixth.troll.util.XSound;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

@RequiredArgsConstructor
public class PlayerVehicleListener implements Listener {

    private final TrollManager trollManager;
    private final TrollPlugin trollPlugin;

    private final Messages messages;

    @EventHandler
    public void onVehicleEnter(VehicleEnterEvent event) {
        if(event.getVehicle().getType().equals(EntityType.MINECART)){
            Player player = (Player) event.getEntered();

            Optional<Troll> trollByVictimUuid = trollManager.getTrollByVictimUuid(player.getUniqueId());

            if (!trollByVictimUuid.isPresent()) {
                return;
            }
            Troll troll = trollByVictimUuid.get();

            if (troll.getTrolledUser().isMinecartTroll()) {
                troll.getTrolledUser().setMinecartTroll(false);
                player.sendMessage(messages.getMinecartDone());
                player.getInventory().addItem(new ItemStack(Material.IRON_INGOT,1));
                XSound.play(player.getLocation(),"CAT_MEOW");
            }
        }
    }
}
