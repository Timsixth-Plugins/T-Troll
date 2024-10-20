package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class OneHeartTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        userProperties.toggleOneHeart(other);

        String message = userProperties.isOneHeart() ? messages.getOneHeartEnabled() : messages.getOneHeartDisabled();

        sender.sendMessage(message);
    }

    @Override
    public String getName() {
        return "ONE_HEART";
    }
}
