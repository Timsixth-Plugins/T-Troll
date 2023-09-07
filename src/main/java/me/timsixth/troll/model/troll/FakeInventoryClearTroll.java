package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class FakeInventoryClearTroll implements Troll {

    private final Messages messages;
    private final TrollProcessManager trollProcessManager;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        trollProcessManager.fakeInventoryClear(other);

        sender.sendMessage(messages.getFilledInv());
    }

    @Override
    public String getName() {
        return "FAKE_INVENTORY_CLEAR";
    }
}
