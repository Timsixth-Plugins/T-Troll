package me.timsixth.troll.util;

import lombok.experimental.UtilityClass;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@UtilityClass
public class ItemUtil {

    public static void setMaterial(Player other, Material material) {
        Block blockBelow = other.getLocation().getBlock().getRelative(BlockFace.DOWN);
        Block blockBelow2 = other.getLocation().subtract(1, 0, 0).getBlock().getRelative(BlockFace.DOWN);
        Block blockBelow3 = other.getLocation().subtract(0, 0, 1).getBlock().getRelative(BlockFace.DOWN);
        Block blockBelow4 = other.getLocation().add(1, 0, 0).getBlock().getRelative(BlockFace.DOWN);
        Block blockBelow5 = other.getLocation().add(0, 0, 1).getBlock().getRelative(BlockFace.DOWN);

        blockBelow.setType(material);
        blockBelow2.setType(material);
        blockBelow3.setType(material);
        blockBelow4.setType(material);
        blockBelow5.setType(material);

    }

    public static void giveItems(Player player, ItemStack... items) {
        PlayerInventory inventory = player.getInventory();

        if (inventory.firstEmpty() == -1) {

            for (ItemStack item : items) {
                player.getWorld().dropItemNaturally(player.getLocation(), item);
            }
        }

        inventory.addItem(items);
    }
}
