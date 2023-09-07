package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Random;
@RequiredArgsConstructor
public class RandomTeleportTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {

        Random random = new Random();
        Location location = other.getLocation().add(random.nextInt(21), 0.0, random.nextInt(21));

        while (location.getWorld().getBlockAt(location).getType() != Material.AIR) {
            location = other.getLocation().add(random.nextInt(21), 1.0, random.nextInt(21));
        }

        other.teleport(location);
        sender.sendMessage(messages.getTeleport());
    }

    @Override
    public String getName() {
        return "RANDOM_TELEPORT";
    }
}
