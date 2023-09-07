package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.XSound;
import org.bukkit.Location;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class EndermanTeleportTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location otherLocation = other.getLocation();
        Location playerLocation = sender.getLocation();

        other.teleport(playerLocation);
        XSound.play(other, "ENDERMAN_TELEPORT");
        sender.teleport(otherLocation);
        XSound.play(sender, "ENDERMAN_TELEPORT");

        sender.sendMessage(messages.getSwapped());
    }

    @Override
    public String getName() {
        return "ENDERMAN_TELEPORT";
    }
}
