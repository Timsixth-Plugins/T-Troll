package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
@RequiredArgsConstructor
public class DrunkTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;
    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 3, true));
        other.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 3, true));
        other.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 3, true));
        other.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 3, true));

        sender.sendMessage(messages.getDrunk());
        if (configFile.isVictimMessage())
            other.sendMessage(messages.getDrunkOther().replace("{NICK}", other.getName()));
    }

    @Override
    public String getName() {
        return "DRUNK";
    }
}
