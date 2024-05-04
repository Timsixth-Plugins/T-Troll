package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class PlayerInteractEnityListener implements Listener {

    private final Messages messages;
    private final ConfigFile configFile;

    @EventHandler
    private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
        Entity rightClicked = event.getRightClicked();
        if (!(rightClicked instanceof Mob)) return;

        if(rightClicked.getCustomName() != null && rightClicked.getCustomName().equals(messages.getNameOfLegendaryTrader())) {
            Location location = rightClicked.getLocation();
            ((Mob) rightClicked).setHealth(0);
            event.getPlayer().getLocation().getWorld().spawnEntity(location, EntityType.ZOMBIE_VILLAGER);
            event.getPlayer().sendMessage(messages.getTraderBooMessage());
        }

        ItemStack itemInMainHand = event.getPlayer().getInventory().getItemInMainHand();

        if (itemInMainHand.getType() == Material.AIR) return;
        if (!itemInMainHand.hasItemMeta()) return;

        String displayName = configFile.getLuckyNameTag().getItemMeta().getDisplayName();

        if (!itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatUtil.chatColor(displayName))) return;

        Player player = event.getPlayer();

        player.getInventory().removeItem(itemInMainHand);

        rightClicked.remove();

        rightClicked.getLocation().getBlock().setType(Material.DIAMOND_BLOCK);
    }
}
