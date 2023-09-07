package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
@RequiredArgsConstructor
public class PumpkinTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        PlayerInventory otherInventory = other.getInventory();

        if (otherInventory.getHelmet() == null || otherInventory.getHelmet().getType() == Material.AIR) {
            otherInventory.setHelmet(new ItemStack(Material.PUMPKIN));
        } else {
            if (otherInventory.firstEmpty() == -1) {
                other.getLocation().getWorld().dropItemNaturally(other.getLocation(), otherInventory.getHelmet());
            } else {
                otherInventory.setItem(otherInventory.firstEmpty(), otherInventory.getHelmet());
            }
            otherInventory.setHelmet(new ItemStack(Material.PUMPKIN));
        }
        sender.sendMessage(messages.getPutOnPumpkin());
    }

    @Override
    public String getName() {
        return "PUT_ON_PUMPKIN";
    }
}
