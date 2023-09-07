package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class FreezeTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        if (!userProperties.isFrozen()) {
            userProperties.setFrozen(true);
            sender.sendMessage(messages.getFrezzedPlayer());
        } else {
            userProperties.setFrozen(false);
            sender.sendMessage(messages.getUnfreezed());
        }
    }

    @Override
    public String getName() {
        return "FREEZE";
    }
}
