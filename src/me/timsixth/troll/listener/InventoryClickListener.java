package me.timsixth.troll.listener;

import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;

public class InventoryClickListener implements Listener {

	private final UserManager userManager;

	public InventoryClickListener(UserManager userManager) {
		this.userManager = userManager;
	}

	@EventHandler
	public void onClick(InventoryClickEvent event) throws InterruptedException {
		if (event.getView().getTitle().equalsIgnoreCase(ConfigFile.GUI_NAME)) {
			if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
				return;
			}
			Player player = (Player) event.getWhoClicked();
			Player other = Bukkit.getPlayer(userManager.getPlayer(player));

			switch (event.getRawSlot()) {
			case 0:
				if (other != null) {
					other.getWorld().createExplosion(other.getLocation(), ConfigFile.POWER_OF_EXPLOSION);
					player.sendMessage(ConfigFile.BLOWUP);
					event.setCancelled(true);
				} else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}

				break;
			case 1:
				if (other != null) {
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
				} else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}

				break;
			case 2:
				if (other != null) {
					String msg = ConfigFile.FAKEOP_FORMAT.replace("{NICK}", other.getName());
					other.sendMessage(msg);
					String msg1 = ConfigFile.GAVE_OP.replace("{NICK}", other.getName());
					player.sendMessage(msg1);
					event.setCancelled(true);
				} else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}

				break;
			case 3:
				if (other != null) {
					if (!userManager.isFreeze(other)) {
						userManager.freezePlayer(other);
						player.sendMessage(ConfigFile.FREZZED_PLAYER);
					} else {
						userManager.unFreeze(other);
						player.sendMessage(ConfigFile.UNFREEZED);
					}
					event.setCancelled(true);
				} else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}
				break;
			case 4:
				if (other != null) {
					Vector vector = new Vector(0, 100, 0);
					other.setVelocity(vector);
					player.sendMessage(ConfigFile.LAUCHED_PLAYER);
					event.setCancelled(true);
				} else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}
				break;
			case 5:
				if (other != null) {
					other.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0, true));
					other.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true));
					other.sendTitle(ChatUtil.chatColor("&c&lCRASH"), null);
					player.sendMessage(ConfigFile.SENDCRASH);
					event.setCancelled(true);
				} else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}
				break;
			case 6:
				if (other != null) {
					other.kickPlayer(ConfigFile.FAKEBAN);
					player.sendMessage(ConfigFile.BANNED_PLAYER);
					event.setCancelled(true);
				}else {
					event.setCancelled(true);
					player.closeInventory();
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}
				break;
				case 7:
					setMaterial(other, Material.WEB, player, ConfigFile.SPAWN_WEB, event);
					break;
				case 8:
					if (other != null) {
						Location location = other.getLocation();
						double y = location.getY() + 10;
						location.setY(y);

						location.getBlock().setType(Material.ANVIL);
						player.sendMessage(ConfigFile.SPAWN_ANVIL);
						event.setCancelled(true);
					}else {
						event.setCancelled(true);
						player.closeInventory();
						player.sendMessage(ConfigFile.OFFLINEPLAYER);
					}
					break;
				case 9:
					setMaterial(other, Material.LAVA, player, ConfigFile.SPAWN_LAVA, event);
					break;
				case 10:
					setMaterial(other, Material.WATER, player, ConfigFile.SPAWN_WATER, event);

					break;
				case 11:
					if (other != null) {
						other.getLocation().getWorld().spawnEntity(other.getLocation(), EntityType.ZOMBIE);
						player.sendMessage(ConfigFile.SPAWN_ZOMBIE);
						event.setCancelled(true);
					}else {
						event.setCancelled(true);
						player.closeInventory();
						player.sendMessage(ConfigFile.OFFLINEPLAYER);
					}
					break;
				case 12:

					Location summonLocation = other.getLocation().add(0.0,6,0.0);
					for (int i = 0; i < 5; i++) {
						summonLocation.getWorld().spawnEntity(summonLocation.add(0,i,0), EntityType.ARROW);
					}
					player.sendMessage(ConfigFile.SPAWN_ARROW);
					event.setCancelled(true);

					break;
				case 13:

					other.getWorld().strikeLightning(other.getLocation());
					//
					player.sendMessage(ConfigFile.STRIKE_LIGHTNING);
					event.setCancelled(true);

					break;
				case 14:

					other.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0, true));

					player.sendMessage(ConfigFile.POISONED);
					event.setCancelled(true);

					break;

			default:
				event.setCancelled(true);
				break;
			}

		}
	}

	private void setMaterial(Player other, Material material, Player player, String message, InventoryClickEvent event) {
		if (other != null) {
			Block BlockBelow = other.getLocation().getBlock().getRelative(BlockFace.DOWN);
			Block BlockBelow2 = other.getLocation().subtract(1,0,0).getBlock().getRelative(BlockFace.DOWN);
			Block BlockBelow3 = other.getLocation().subtract(0,0,1).getBlock().getRelative(BlockFace.DOWN);
			Block BlockBelow4 = other.getLocation().add(1,0,0).getBlock().getRelative(BlockFace.DOWN);
			Block BlockBelow5 = other.getLocation().add(0,0,1).getBlock().getRelative(BlockFace.DOWN);

			BlockBelow.setType(material);
			BlockBelow2.setType(material);
			BlockBelow3.setType(material);
			BlockBelow4.setType(material);
			BlockBelow5.setType(material);

			player.sendMessage(message);
			event.setCancelled(true);
		}else {
			event.setCancelled(true);
			player.closeInventory();
			player.sendMessage(ConfigFile.OFFLINEPLAYER);
		}
	}
}
