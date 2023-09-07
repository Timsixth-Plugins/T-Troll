package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class RotateTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location location = other.getLocation();
        location.setYaw(location.getYaw() + 180.0F);
        other.teleport(location);

        sender.sendMessage(messages.getRotated());
    }

    @Override
    public String getName() {
        return "ROTATE";
    }
}
