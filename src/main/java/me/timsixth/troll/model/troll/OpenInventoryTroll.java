package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

@RequiredArgsConstructor
public class OpenInventoryTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Inventory otherInventory = other.getInventory();
        sender.openInventory(otherInventory);

        sender.sendMessage(messages.getOpenInv());
    }

    @Override
    public String getName() {
        return "OPEN_INVENTORY";
    }
}
