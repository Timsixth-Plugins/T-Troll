package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ZombieTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.0, 0, 1), EntityType.ZOMBIE);
        other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.1, 0, 0), EntityType.ZOMBIE);
        other.getLocation().getWorld().spawnEntity(other.getLocation().subtract(1.0, 0, 1), EntityType.ZOMBIE);
        sender.sendMessage(messages.getSpawnZombie());
    }

    @Override
    public String getName() {
        return "ZOMBIE";
    }
}
