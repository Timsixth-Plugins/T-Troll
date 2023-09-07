package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
@RequiredArgsConstructor
public class SpeedTroll implements Troll {
    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 100, true));

        sender.sendMessage(messages.getSpeed());
    }

    @Override
    public String getName() {
        return "SPEED";
    }
}
