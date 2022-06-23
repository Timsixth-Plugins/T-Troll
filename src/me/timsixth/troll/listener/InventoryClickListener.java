package me.timsixth.troll.listener;

import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class InventoryClickListener implements Listener {

    private final UserManager userManager;

    public InventoryClickListener(UserManager userManager) {
        this.userManager = userManager;
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(ConfigFile.GUI_NAME)) {
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            Player player = (Player) event.getWhoClicked();
            Player other = Bukkit.getPlayer(userManager.getPlayer(player));

            switch (event.getRawSlot()) {
                case 0:
                    if (isPlayerOnline(other, player, event)) {
                        other.getWorld().createExplosion(other.getLocation(), ConfigFile.POWER_OF_EXPLOSION);
                        player.sendMessage(ConfigFile.BLOWUP);
                        event.setCancelled(true);
                    }
                    break;
                case 1:
                    if (isPlayerOnline(other, player, event)) {
                        if (!userManager.isFakeAdmin(other)) {
                            userManager.giveFakeAdmin(other);
                            other.sendMessage(ConfigFile.ADMIN_NOW);
                            String msg = ConfigFile.GAVE_ADMIN.replace("{NICK}", other.getName());
                            player.sendMessage(msg);
                        } else {
                            userManager.removeFakeAdmin(other);
                            userManager.giveFakeAdmin(other);
                            other.sendMessage(ConfigFile.ADMIN_NOW);
                            String msg = ConfigFile.GAVE_ADMIN.replace("{NICK}", other.getName());
                            player.sendMessage(msg);
                        }
                        event.setCancelled(true);
                    }
                    break;
                case 2:
                    if (isPlayerOnline(other, player, event)) {
                        String msgToOther = ConfigFile.FAKEOP_FORMAT.replace("{NICK}", other.getName());
                        String msgToSender = ConfigFile.GAVE_OP.replace("{NICK}", other.getName());
                        other.sendMessage(msgToOther);
                        player.sendMessage(msgToSender);
                        event.setCancelled(true);
                    }
                    break;
                case 3:
                    if (isPlayerOnline(other, player, event)) {
                        if (!userManager.isFreeze(other)) {
                            userManager.freezePlayer(other);
                            player.sendMessage(ConfigFile.FREZZED_PLAYER);
                        } else {
                            userManager.unFreeze(other);
                            player.sendMessage(ConfigFile.UNFREEZED);
                        }
                        event.setCancelled(true);
                    }
                    break;
                case 4:
                    if (isPlayerOnline(other, player, event)) {
                        Vector vector = new Vector(0, 100, 0);
                        other.setVelocity(vector);
                        player.sendMessage(ConfigFile.LAUCHED_PLAYER);
                        event.setCancelled(true);
                    }
                    break;
                case 5:
                    if (isPlayerOnline(other, player, event)) {
                        other.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0, true));
                        other.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true));
                        other.sendTitle(ChatUtil.chatColor("&c&lCRASH"), null);
                        player.sendMessage(ConfigFile.SENDCRASH);
                        event.setCancelled(true);
                    }
                    break;
                case 6:
                    if (isPlayerOnline(other, player, event)) {
                        other.kickPlayer(ConfigFile.FAKEBAN);
                        player.sendMessage(ConfigFile.BANNED_PLAYER);
                        event.setCancelled(true);
                    }
                    break;
                case 7:
                    setMaterial(other, Material.WEB, player, ConfigFile.SPAWN_WEB, event);
                    break;
                case 8:
                    if (isPlayerOnline(other, player, event)) {
                        Location location = other.getLocation();
                        double y = location.getY() + 10;
                        location.setY(y);

                        location.getBlock().setType(Material.ANVIL);
                        player.sendMessage(ConfigFile.SPAWN_ANVIL);
                        event.setCancelled(true);
                    }
                    break;
                case 9:
                    setMaterial(other, Material.LAVA, player, ConfigFile.SPAWN_LAVA, event);
                    break;
                case 10:
                    setMaterial(other, Material.WATER, player, ConfigFile.SPAWN_WATER, event);
                    break;
                case 11:
                    if (isPlayerOnline(other, player, event)) {
                        other.getLocation().getWorld().spawnEntity(other.getLocation(), EntityType.ZOMBIE);
                        player.sendMessage(ConfigFile.SPAWN_ZOMBIE);
                        event.setCancelled(true);
                    }
                    break;
                case 12:
                    if (isPlayerOnline(other, player, event)) {
                        Location summonLocation = other.getLocation().add(0.0, 6, 0.0);
                        for (int i = 0; i < 5; i++) {
                            summonLocation.getWorld().spawnEntity(summonLocation.add(0, i, 0), EntityType.ARROW);
                        }
                        player.sendMessage(ConfigFile.SPAWN_ARROW);
                        event.setCancelled(true);
                    }
                    break;
                case 13:
                    if (isPlayerOnline(other, player, event)) {
                        other.getWorld().strikeLightning(other.getLocation());
                        player.sendMessage(ConfigFile.STRIKE_LIGHTNING);
                        event.setCancelled(true);
                    }
                    break;
                case 14:
                    if (isPlayerOnline(other, player, event)) {
                        other.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0, true));
                        player.sendMessage(ConfigFile.POISONED);
                        event.setCancelled(true);
                    }
                    break;
                default:
                    event.setCancelled(true);
                    break;
            }

        }
    }

    private void setMaterial(Player other, Material material, Player player, String message, InventoryClickEvent event) {
        if (isPlayerOnline(other, player, event)) {
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

            player.sendMessage(message);
            event.setCancelled(true);
        }
    }

    private boolean isPlayerOnline(Player other, Player sender, InventoryClickEvent event) {
        if (other == null) {
            event.setCancelled(true);
            sender.closeInventory();
            sender.sendMessage(ConfigFile.OFFLINEPLAYER);
            return false;
        }
        return true;
    }
}
