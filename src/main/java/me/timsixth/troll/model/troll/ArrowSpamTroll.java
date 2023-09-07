package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ArrowSpamTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location summonLocation = other.getLocation().add(0.0, 6, 0.0);
        for (int i = 0; i < 5; i++) {
            summonLocation.getWorld().spawnEntity(summonLocation.add(0, i, 0), EntityType.ARROW);
        }
        sender.sendMessage(messages.getSpawnArrow());
    }

    @Override
    public String getName() {
        return "ARROW_SPAM";
    }
}
