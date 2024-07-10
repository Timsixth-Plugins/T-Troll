package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
@RequiredArgsConstructor
public class MeteorTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location location = other.getLocation().add(0, 20, 0);
        Fireball fireball = other.getWorld().spawn(location, Fireball.class);
        fireball.setDirection(other.getLocation().subtract(location).toVector());
        fireball.setYield(8);
        fireball.setIsIncendiary(true);
        fireball.setFireTicks(0);

        sender.sendMessage(messages.getMeteor());
    }

    @Override
    public String getName() {
        return "METEOR";
    }
}
