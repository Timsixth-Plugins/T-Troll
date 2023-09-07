package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class RandomPotionEffectTroll implements Troll {
    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Random random = new Random();
        List<PotionEffectType> types = Arrays.asList(PotionEffectType.values());

        PotionEffectType randomPotionEffectType = types.get(random.nextInt(types.size()));

        other.addPotionEffect(new PotionEffect(randomPotionEffectType, 600, 0, true));

        sender.sendMessage(messages.getGiveRandomPotionEffect());
    }

    @Override
    public String getName() {
        return "RANDOM_POTION_EFFECT";
    }
}
