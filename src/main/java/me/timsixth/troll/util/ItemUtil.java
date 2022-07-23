package me.timsixth.troll.util;

import lombok.experimental.UtilityClass;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
@UtilityClass
public class ItemUtil {
    public static ItemStack createItem(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatUtil.chatColor(name));
        item.setItemMeta(meta);
        return item;
    }
}