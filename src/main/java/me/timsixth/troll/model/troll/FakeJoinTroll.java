package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class FakeJoinTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.sendMessage(messages.getFakeJoinOther());
        sender.sendMessage(messages.getFakeJoin());
    }

    @Override
    public String getName() {
        return "FAKE_JOIN";
    }
}
