package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.XSound;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class HitPlayerTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {

        double health = other.getHealth();

        other.setHealth(health - 1D);

        XSound.play(other, "ENTITY_PLAYER_HURT");

        sender.sendMessage(messages.getHitPlayer());
    }

    @Override
    public String getName() {
        return "HIT";
    }
}
