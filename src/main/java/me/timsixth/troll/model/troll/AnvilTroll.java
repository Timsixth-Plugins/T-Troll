package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
@RequiredArgsConstructor
public class AnvilTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location location = other.getLocation();
        double y = location.getY() + 10;
        location.setY(y);

        location.getBlock().setType(Material.ANVIL);
        sender.sendMessage(messages.getSpawnAnvil());
    }

    @Override
    public String getName() {
        return "ANVIL";
    }
}
