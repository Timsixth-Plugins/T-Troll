package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ToggleGravityTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.setGravity(!other.hasGravity());
        sender.sendMessage(other.hasGravity() ? messages.getEnableGravity() : messages.getDisableGravity());
    }

    @Override
    public String getName() {
        return "TOGGLE GRAVITY";
    }
}
