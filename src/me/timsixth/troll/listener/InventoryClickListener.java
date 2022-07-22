package me.timsixth.troll.listener;

import me.timsixth.troll.Main;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.*;

public class InventoryClickListener implements Listener {

    private final UserManager userManager;
    private final Main main;



    public InventoryClickListener(Main main,UserManager userManager) {
        this.userManager = userManager;
        this.main = main;
    }
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(ConfigFile.GUI_NAME)) {
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            Player player = (Player) event.getWhoClicked();
            TrolledUserProperties user = userManager.getTrollBySenderUuid(player.getUniqueId()).getTrolledUser();
            Player other = Bukkit.getPlayer(userManager.getTrollBySenderUuid(player.getUniqueId()).getVictimUuid());

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
                        if (!user.isFakeAdmin()) {
                            user.setFakeAdmin(true);
                            other.sendMessage(ConfigFile.ADMIN_NOW);
                            String msg = ConfigFile.GAVE_ADMIN.replace("{NICK}", other.getName());
                            player.sendMessage(msg);
                        } else {
                            user.setFakeAdmin(false);
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
                        if (!user.isFrozen()) {
                            user.setFrozen(true);
                            player.sendMessage(ConfigFile.FREZZED_PLAYER);
                        } else {
                            user.setFrozen(false);
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
                        other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.0, 0, 1), EntityType.ZOMBIE);
                        other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.1, 0, 0), EntityType.ZOMBIE);
                        other.getLocation().getWorld().spawnEntity(other.getLocation().subtract(1.0, 0, 1), EntityType.ZOMBIE);
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
                case 15:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = other.getLocation();
                        location.setYaw(location.getYaw() + 180.0F);
                        other.teleport(location);

                        player.sendMessage(ConfigFile.ROTATED);
                        event.setCancelled(true);
                    }
                    break;
                case 16:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = other.getLocation();
                        other.playSound(location, Sound.CREEPER_HISS, 3.5F, 0.5F);

                        player.sendMessage(ConfigFile.CREEPER_HISS);
                        event.setCancelled(true);
                    }
                    break;
                case 17:
                    if (isPlayerOnline(other, player, event)) {
                        user.setExp(other.getExp());
                        user.setLevel(other.getLevel());
                        other.setLevel(0);
                        other.setExp(0);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                other.setLevel(user.getLevel());
                                other.setExp(user.getExp());
                            }
                        }.runTaskLater(main, 10 * 20L);

                        player.sendMessage(ConfigFile.FAKE_EXP);
                        event.setCancelled(true);
                    }
                    break;
                case 18:
                    if (isPlayerOnline(other, player, event)) {
                        other.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 100, true));

                        player.sendMessage(ConfigFile.SPEED);
                        event.setCancelled(true);
                    }
                    break;
                case 19:
                    if (isPlayerOnline(other, player, event)) {
                        Location location = other.getLocation();
                        other.playSound(location, Sound.GHAST_SCREAM2, 7.0F, 1.0F);

                        player.sendMessage(ConfigFile.SCARE);
                        event.setCancelled(true);
                    }
                    break;
                case 20:
                    if (isPlayerOnline(other, player, event)) {

                        Random random = new Random();
                        Location location = other.getLocation().add(random.nextInt(21), 0.0, random.nextInt(21));

                        while (location.getWorld().getBlockAt(location).getType() != Material.AIR) {
                            location = other.getLocation().add(random.nextInt(21), 1.0, random.nextInt(21));

                        }

                        other.teleport(location);
                        player.sendMessage(ConfigFile.TELEPORT);
                        event.setCancelled(true);
                    }
                    break;
                case 21:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = other.getLocation().subtract(0.0,20.0,0.0);
                        location.getBlock().setType(Material.AIR);
                        location.add(0.0,1.0,0.0).getBlock().setType(Material.AIR);
                        other.teleport(location);

                        other.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE));

                        player.sendMessage(ConfigFile.WOODEN_PICK);
                        other.sendMessage(ConfigFile.WOODEN_PICK_OTHER);
                        event.setCancelled(true);
                    }
                    break;
                case 22:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = Bukkit.getServer().getWorld("world").getSpawnLocation();

                        while (location.getWorld().getBlockAt(location).getType() != Material.AIR) {
                            location = location.add(0.0,1.0,0.0);
                        }

                        other.teleport(location);
                        player.sendMessage(ConfigFile.SPAWN_TP);
                        event.setCancelled(true);
                    }
                    break;
                case 23:
                    if (isPlayerOnline(other, player, event)) {
                        userManager.fakeInventoryClear(other, main);

                        player.sendMessage(ConfigFile.FILLED_INV);
                        event.setCancelled(true);
                    }
                    break;
                case 24:
                    if (isPlayerOnline(other, player, event)) {

                        if (other.getInventory().getItemInHand().getType().equals(Material.AIR)) {
                            player.sendMessage(ConfigFile.NO_HAND_ITEM);
                            event.setCancelled(true);
                        } else {
                            ItemStack handItem = other.getInventory().getItemInHand();
                            handItem.setAmount(other.getInventory().getItemInHand().getAmount());
                            ItemMeta handItemMeta = handItem.getItemMeta();
                            handItemMeta.getDisplayName();
                            handItem.setItemMeta(handItemMeta);
                            other.getInventory().remove(handItem);
                            Location otherLocation = other.getLocation();
                            otherLocation.getWorld().dropItemNaturally(otherLocation, handItem);

                            player.sendMessage(ConfigFile.DROPPED_HAND_ITEM);
                            event.setCancelled(true);
                        }
                    }
                    break;
                case 25:
                    if (isPlayerOnline(other, player, event)) {

                        for(int i = 1; i <= 30; ++i) {
                            int random = (int)(Math.random() * 9.99999999E8);
                            other.sendMessage("§7" + Integer.toString(random) + Integer.toString(random) + Integer.toString(random));
                        }
                        player.sendMessage(ConfigFile.SPAMMED);
                        event.setCancelled(true);
                    }
                    break;
                case 26:
                    if (isPlayerOnline(other, player, event)) {

                        Location otherLocation = other.getLocation();
                        Location playerLocation = player.getLocation();

                        other.teleport(playerLocation);
                        other.playSound(playerLocation, Sound.ENDERMAN_TELEPORT, 3.5F, 0.5F);
                        player.teleport(otherLocation);
                        player.playSound(otherLocation, Sound.ENDERMAN_TELEPORT, 3.5F, 0.5F);


                        player.sendMessage(ConfigFile.SWAPPED);
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
