package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class HungerTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.setFoodLevel(0);

        sender.sendMessage(messages.getMadeHunger());
    }

    @Override
    public String getName() {
        return "HUNGER";
    }
}
