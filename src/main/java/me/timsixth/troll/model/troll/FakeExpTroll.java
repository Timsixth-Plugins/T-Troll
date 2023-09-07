package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class FakeExpTroll implements Troll {

    private final Messages messages;
    private final TrollPlugin trollPlugin;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        userProperties.setExp(other.getExp());
        userProperties.setLevel(other.getLevel());
        other.setLevel(0);
        other.setExp(0);
        new BukkitRunnable() {
            @Override
            public void run() {
                other.setLevel(userProperties.getLevel());
                other.setExp(userProperties.getExp());
            }
        }.runTaskLater(trollPlugin, 10 * 20L);

        sender.sendMessage(messages.getFakeExp());
    }

    @Override
    public String getName() {
        return "FAKE_EXP";
    }
}
