package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class LowerReachTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        if (!userProperties.isLoweredReach()){
            userProperties.setLoweredReach(true);
            sender.sendMessage(messages.getLowerReachEnabled());
        } else {
            userProperties.setLoweredReach(false);
            sender.sendMessage(messages.getLowerReachDisabled());
        }
    }

    @Override
    public String getName() {
        return "LOWER_REACH";
    }
}
