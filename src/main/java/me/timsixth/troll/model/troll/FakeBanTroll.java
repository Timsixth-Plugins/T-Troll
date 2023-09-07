package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
@RequiredArgsConstructor
public class FakeBanTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.kickPlayer(messages.getFakeBan());
        sender.sendMessage(messages.getBannedPlayer());
    }

    @Override
    public String getName() {
        return "FAKE_BAN";
    }
}
