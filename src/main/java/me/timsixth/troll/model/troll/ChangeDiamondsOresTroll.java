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
public class ChangeDiamondsOresTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {

        replaceDiamondsOresByLapisOres(other);

        sender.sendMessage(messages.getReplacedDiamondsOres());
    }

    @Override
    public String getName() {
        return "CHANGE_DIAMONDS";
    }

    private void replaceDiamondsOresByLapisOres(Player other) {
        PlayerInventory inventory = other.getInventory();
        ItemStack[] storageContents = inventory.getStorageContents();

        for (int i = 0; i < storageContents.length; i++) {
            ItemStack item = storageContents[i];

            if (item == null || item.getType() == Material.AIR) continue;

            if (item.getType().name().contains("DIAMOND_ORE")) {
                if (item.hasItemMeta()) continue;

                inventory.setItem(i, new ItemStack(Material.LAPIS_ORE));
            }
        }
    }
}
