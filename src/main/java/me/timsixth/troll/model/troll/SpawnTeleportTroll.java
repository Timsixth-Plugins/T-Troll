package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class SpawnTeleportTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location location = other.getLocation().getWorld().getSpawnLocation();

        if (location.getWorld().getName().contains("nether") || location.getWorld().getName().contains("end")) {
            sender.sendMessage(messages.getOnlyInOverworld());
            return;
        }

        while (location.getWorld().getBlockAt(location).getType() != Material.AIR) {
            location = location.add(0.0, 1.0, 0.0);
        }

        other.teleport(location);
        sender.sendMessage(messages.getSpawnTp());
    }

    @Override
    public String getName() {
        return "SPAWN_TELEPORT";
    }
}
