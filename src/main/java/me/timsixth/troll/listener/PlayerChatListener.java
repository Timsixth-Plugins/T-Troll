package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public class PlayerChatListener implements Listener {

    private final TrollProcessManager trollProcessManager;
    private final ConfigFile configFile;
    private final TrollPlugin trollPlugin;

    @EventHandler
    private void onChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        Inventory otherInventory = player.getInventory();
        Optional<TrollProcess> trollByVictimUuid = trollProcessManager.getTrollByVictimUuid(player.getUniqueId());

        if (!trollByVictimUuid.isPresent()) return;

        TrollProcess troll = trollByVictimUuid.get();
        if (event.getMessage().equalsIgnoreCase(troll.getTrolledUser().getHackerTrollCode())) {

            if (otherInventory.firstEmpty() == -1) {
                player.getLocation().getWorld().dropItemNaturally(player.getLocation(), getSword());
            } else {
                otherInventory.setItem(otherInventory.firstEmpty(), getSword());
            }
            Bukkit.getScheduler().callSyncMethod(trollPlugin, () -> player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 0, true)));

            troll.getTrolledUser().setHackerTrollCode(null);
            event.setCancelled(true);
        }

        if (troll.getTrolledUser().isFakeAdmin()) {
            String msg = configFile.getFakeAdminFormat();
            msg = msg.replace("{NICK}", player.getName());
            msg = msg.replace("{MESSAGE}", event.getMessage());
            msg = msg.replace(">>", "»");

            Bukkit.broadcastMessage(msg);
            event.setCancelled(true);
        }

    }

    private ItemStack getSword() {
        ItemStack sword = new ItemStack(Material.WOODEN_SWORD, 1);
        sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
        ItemMeta meta = sword.getItemMeta();
        meta.setLore(Arrays.asList(configFile.getHackerTrollEnchantLoreLine(), "", configFile.getHackerTrollThirdLoreLine()));
        meta.setDisplayName(configFile.getHackerTrollSwordName());
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        sword.setItemMeta(meta);
        return sword;
    }
}
