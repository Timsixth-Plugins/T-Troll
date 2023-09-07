package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
@RequiredArgsConstructor
public class StrikeLightningTroll implements Troll {

    private final Messages messages;
    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.getWorld().strikeLightning(other.getLocation());
        sender.sendMessage(messages.getStrikeLightning());
    }

    @Override
    public String getName() {
        return "STRIKE_LIGHTNING";
    }
}
