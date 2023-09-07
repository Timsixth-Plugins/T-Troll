package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@RequiredArgsConstructor
public class DropHandItemTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        if (other.getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
            sender.sendMessage(messages.getNoHandItem());
        } else {
            ItemStack handItem = other.getInventory().getItemInMainHand();
            handItem.setAmount(other.getInventory().getItemInMainHand().getAmount());
            ItemMeta handItemMeta = handItem.getItemMeta();
            handItemMeta.getDisplayName();
            handItem.setItemMeta(handItemMeta);
            other.getInventory().remove(handItem);
            Location otherLocation = other.getLocation();
            otherLocation.getWorld().dropItemNaturally(otherLocation, handItem);

            sender.sendMessage(messages.getDroppedHandItem());
        }
    }

    @Override
    public String getName() {
        return "DROP_HAND_ITEM";
    }
}
