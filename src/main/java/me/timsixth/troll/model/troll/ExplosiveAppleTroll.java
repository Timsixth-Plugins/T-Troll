package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.UniversalItemMeta;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

@RequiredArgsConstructor
public class ExplosiveAppleTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        ItemStack apple = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);
        ItemMeta meta = apple.getItemMeta();
        UniversalItemMeta universalItemMeta = new UniversalItemMeta(meta);
        universalItemMeta.setLocalizedName("explosive-apple");
        apple.setItemMeta(universalItemMeta.toItemMeta());

        other.getInventory().addItem(apple);
        sender.sendMessage(messages.getExplosiveAppleMessage());
    }

    @Override
    public String getName() {
        return "EXPLOSIVE_APPLE";
    }
}
