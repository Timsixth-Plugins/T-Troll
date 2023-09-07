package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@RequiredArgsConstructor
public class FakeCrashTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0, true));
        other.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true));
        other.sendTitle(ChatUtil.chatColor("&c&lCRASH"), "", 10, 70, 20);
        sender.sendMessage(messages.getSendCrash());
    }

    @Override
    public String getName() {
        return "FAKE_CRASH";
    }
}
