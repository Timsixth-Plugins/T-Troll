package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@RequiredArgsConstructor
public class RocketWithPlayerTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Vector vector = new Vector(0, 100, 0);
        other.setVelocity(vector);
        sender.sendMessage(messages.getLauchedPlayer());
    }

    @Override
    public String getName() {
        return "ROCKET_WITH_PLAYER";
    }
}
