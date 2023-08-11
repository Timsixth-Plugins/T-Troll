package me.timsixth.troll.listener;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import me.timsixth.troll.util.XSound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.util.Collections;
import java.util.Optional;
import java.util.Random;

@RequiredArgsConstructor
public class InventoryClickListener implements Listener {

    private final TrollManager trollManager;
    private final TrollPlugin trollPlugin;

    private final Messages messages;
    private final ConfigFile configFile;

    @EventHandler
    private void onClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equalsIgnoreCase(configFile.getGuiName())) {
            if (event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR) {
                return;
            }
            Player player = (Player) event.getWhoClicked();

            Optional<Troll> trollBySenderUuid = trollManager.getTrollBySenderUuid(player.getUniqueId());
            if (!trollBySenderUuid.isPresent()) {
                return;
            }

            TrolledUserProperties trolledUser = trollBySenderUuid.get().getTrolledUser();
            Player other = Bukkit.getPlayer(trollBySenderUuid.get().getVictimUuid());

            switch (event.getRawSlot()) {
                case 0:
                    if (isPlayerOnline(other, player, event)) {
                        other.getWorld().createExplosion(other.getLocation(), configFile.getPowerOfExplosion());
                        player.sendMessage(messages.getBlowup());
                        event.setCancelled(true);
                    }
                    break;
                case 1:
                    if (isPlayerOnline(other, player, event)) {
                        switchFakeAdmin(player, trolledUser, other, !trolledUser.isFakeAdmin());
                        event.setCancelled(true);
                    }
                    break;
                case 2:
                    if (isPlayerOnline(other, player, event)) {
                        String msgToOther = configFile.getFakeOpFormat().replace("{NICK}", other.getName());
                        String msgToSender = messages.getGaveOp().replace("{NICK}", other.getName());
                        other.sendMessage(msgToOther);
                        player.sendMessage(msgToSender);
                        event.setCancelled(true);
                    }
                    break;
                case 3:
                    if (isPlayerOnline(other, player, event)) {
                        if (!trolledUser.isFrozen()) {
                            trolledUser.setFrozen(true);
                            player.sendMessage(messages.getFrezzedPlayer());
                        } else {
                            trolledUser.setFrozen(false);
                            player.sendMessage(messages.getUnfreezed());
                        }
                        event.setCancelled(true);
                    }
                    break;
                case 4:
                    if (isPlayerOnline(other, player, event)) {
                        Vector vector = new Vector(0, 100, 0);
                        other.setVelocity(vector);
                        player.sendMessage(messages.getLauchedPlayer());
                        event.setCancelled(true);
                    }
                    break;
                case 5:
                    if (isPlayerOnline(other, player, event)) {
                        other.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 200, 0, true));
                        other.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 200, 0, true));
                        other.sendTitle(ChatUtil.chatColor("&c&lCRASH"), "");
                        player.sendMessage(messages.getSendCrash());
                        event.setCancelled(true);
                    }
                    break;
                case 6:
                    if (isPlayerOnline(other, player, event)) {
                        other.kickPlayer(messages.getFakeBan());
                        player.sendMessage(messages.getBannedPlayer());
                        event.setCancelled(true);
                    }
                    break;
                case 7:
                    setMaterial(other, Material.WEB, player, messages.getSpawnWeb(), event);
                    break;
                case 8:
                    if (isPlayerOnline(other, player, event)) {
                        Location location = other.getLocation();
                        double y = location.getY() + 10;
                        location.setY(y);

                        location.getBlock().setType(Material.ANVIL);
                        player.sendMessage(messages.getSpawnAnvil());
                        event.setCancelled(true);
                    }
                    break;
                case 9:
                    setMaterial(other, Material.LAVA, player, messages.getSpawnLava(), event);
                    break;
                case 10:
                    setMaterial(other, Material.WATER, player, messages.getSpawnWater(), event);
                    break;
                case 11:
                    if (isPlayerOnline(other, player, event)) {
                        other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.0, 0, 1), EntityType.ZOMBIE);
                        other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.1, 0, 0), EntityType.ZOMBIE);
                        other.getLocation().getWorld().spawnEntity(other.getLocation().subtract(1.0, 0, 1), EntityType.ZOMBIE);
                        player.sendMessage(messages.getSpawnZombie());
                        event.setCancelled(true);
                    }
                    break;
                case 12:
                    if (isPlayerOnline(other, player, event)) {
                        Location summonLocation = other.getLocation().add(0.0, 6, 0.0);
                        for (int i = 0; i < 5; i++) {
                            summonLocation.getWorld().spawnEntity(summonLocation.add(0, i, 0), EntityType.ARROW);
                        }
                        player.sendMessage(messages.getSpawnArrow());
                        event.setCancelled(true);
                    }
                    break;
                case 13:
                    if (isPlayerOnline(other, player, event)) {
                        other.getWorld().strikeLightning(other.getLocation());
                        player.sendMessage(messages.getStrikeLightning());
                        event.setCancelled(true);
                    }
                    break;
                case 14:
                    if (isPlayerOnline(other, player, event)) {
                        other.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200, 0, true));
                        player.sendMessage(messages.getPoisoned());
                        event.setCancelled(true);
                    }
                    break;
                case 15:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = other.getLocation();
                        location.setYaw(location.getYaw() + 180.0F);
                        other.teleport(location);

                        player.sendMessage(messages.getRotated());
                        event.setCancelled(true);
                    }
                    break;
                case 16:
                    if (isPlayerOnline(other, player, event)) {
                        XSound.play(other, "CREEPER_HISS");

                        player.sendMessage(messages.getCreeperHiss());
                        event.setCancelled(true);
                    }
                    break;
                case 17:
                    if (isPlayerOnline(other, player, event)) {
                        trolledUser.setExp(other.getExp());
                        trolledUser.setLevel(other.getLevel());
                        other.setLevel(0);
                        other.setExp(0);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                other.setLevel(trolledUser.getLevel());
                                other.setExp(trolledUser.getExp());
                            }
                        }.runTaskLater(trollPlugin, 10 * 20L);

                        player.sendMessage(messages.getFakeExp());
                        event.setCancelled(true);
                    }
                    break;
                case 18:
                    if (isPlayerOnline(other, player, event)) {
                        other.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 100, true));

                        player.sendMessage(messages.getSpeed());
                        event.setCancelled(true);
                    }
                    break;
                case 19:
                    if (isPlayerOnline(other, player, event)) {
                        XSound.play(other, "ENTITY_GHAST_SCREAM");

                        player.sendMessage(messages.getScare());
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
                        player.sendMessage(messages.getTeleport());
                        event.setCancelled(true);
                    }
                    break;
                case 21:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = other.getLocation().subtract(0.0, 20.0, 0.0);
                        location.getBlock().setType(Material.AIR);
                        location.add(0.0, 1.0, 0.0).getBlock().setType(Material.AIR);
                        other.teleport(location);

                        other.getInventory().addItem(new ItemStack(Material.WOOD_PICKAXE));

                        player.sendMessage(messages.getWoodenPick());
                        if (configFile.isVictimMessage()) other.sendMessage(messages.getWoodenPickOther());
                        event.setCancelled(true);
                    }
                    break;
                case 22:
                    if (isPlayerOnline(other, player, event)) {

                        Location location = other.getLocation().getWorld().getSpawnLocation();

                        if (location.getWorld().getName().contains("nether") || location.getWorld().getName().contains("end")) {
                            player.sendMessage(messages.getOnlyInOverworld());
                            event.setCancelled(true);
                            return;
                        }

                        while (location.getWorld().getBlockAt(location).getType() != Material.AIR) {
                            location = location.add(0.0, 1.0, 0.0);
                        }

                        other.teleport(location);
                        player.sendMessage(messages.getSpawnTp());
                        event.setCancelled(true);
                    }
                    break;
                case 23:
                    if (isPlayerOnline(other, player, event)) {
                        trollManager.fakeInventoryClear(other);

                        player.sendMessage(messages.getFilledInv());
                        event.setCancelled(true);
                    }
                    break;
                case 24:
                    if (isPlayerOnline(other, player, event)) {

                        if (other.getInventory().getItemInHand().getType().equals(Material.AIR)) {
                            player.sendMessage(messages.getNoHandItem());
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

                            player.sendMessage(messages.getDroppedHandItem());
                            event.setCancelled(true);
                        }
                    }
                    break;
                case 25:
                    if (isPlayerOnline(other, player, event)) {

                        for (int i = 1; i <= 30; ++i) {
                            int random = (int) (Math.random() * 9.99999999E8);
                            other.sendMessage(ChatUtil.chatColor("&7" + random + random + random));
                        }
                        player.sendMessage(messages.getSpammed());
                        event.setCancelled(true);
                    }
                    break;
                case 26:
                    if (isPlayerOnline(other, player, event)) {

                        Location otherLocation = other.getLocation();
                        Location playerLocation = player.getLocation();

                        other.teleport(playerLocation);
                        XSound.play(other, "ENDERMAN_TELEPORT");
                        player.teleport(otherLocation);
                        XSound.play(player, "ENDERMAN_TELEPORT");

                        player.sendMessage(messages.getSwapped());
                        event.setCancelled(true);
                    }
                    break;
                case 27:
                    if (isPlayerOnline(other, player, event)) {

                        other.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 400, 3, true));
                        other.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 400, 3, true));
                        other.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 400, 3, true));
                        other.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 400, 3, true));

                        player.sendMessage(messages.getDrunk());
                        if (configFile.isVictimMessage())
                            other.sendMessage(messages.getDrunkOther().replace("{NICK}", other.getName()));
                        event.setCancelled(true);
                    }
                    break;
                case 28:
                    if (isPlayerOnline(other, player, event)) {

                        other.sendMessage(messages.getFakeJoinOther());
                        player.sendMessage(messages.getFakeJoin());
                        event.setCancelled(true);
                    }
                    break;
                case 29:
                    if (isPlayerOnline(other, player, event)) {

                        Inventory otherInventory = other.getInventory();
                        player.openInventory(otherInventory);

                        player.sendMessage(messages.getOpenInv());
                        event.setCancelled(true);
                    }
                    break;
                case 30:
                    if (isPlayerOnline(other, player, event)) {
                        PlayerInventory otherInventory = other.getInventory();

                        if (otherInventory.getHelmet() == null || otherInventory.getHelmet().getType() == Material.AIR) {
                            otherInventory.setHelmet(new ItemStack(Material.PUMPKIN));
                        } else {
                            if (otherInventory.firstEmpty() == -1) {
                                other.getLocation().getWorld().dropItemNaturally(other.getLocation(), otherInventory.getHelmet());
                            } else {
                                otherInventory.setItem(otherInventory.firstEmpty(), otherInventory.getHelmet());
                            }
                            otherInventory.setHelmet(new ItemStack(Material.PUMPKIN));
                        }
                        player.sendMessage(messages.getPutOnPumpkin());
                        event.setCancelled(true);
                    }
                    break;
                case 31:
                    if (isPlayerOnline(other, player, event)) {
                        Slime slimeEntity = (Slime) other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.5, 1, 0), EntityType.SLIME);
                        slimeEntity.setCustomName(messages.getSlimeName());
                        if (configFile.isVictimMessage()) other.sendMessage(messages.getNewFriend());
                        player.sendMessage(messages.getYouGetSlime());
                        event.setCancelled(true);
                    }
                    break;
                case 32:
                    if (isPlayerOnline(other, player, event)) {
                        PlayerInventory otherInventory = other.getInventory();
                        Location otherLocation = other.getLocation();
                        if (otherInventory.firstEmpty() == -1) {
                            other.getLocation().getWorld().dropItemNaturally(other.getLocation(), new ItemStack(Material.MINECART, 1));
                        } else {
                            otherInventory.addItem(new ItemStack(Material.MINECART, 1));
                        }
                        otherLocation.getBlock().setType(Material.RAILS);
                        toggleMinecartTroll(player, trolledUser, other, true);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                if (trolledUser.isMinecartTroll()) {
                                    toggleMinecartTroll(player, trolledUser, other, false);
                                }
                            }
                        }.runTaskLater(trollPlugin, 10 * 20L);
                        event.setCancelled(true);
                    }
                    break;
                case 33:
                    if (isPlayerOnline(other, player, event)) {
                        if (!(configFile.getHackerTrollBookContent().contains("{CODE}"))) {
                            player.sendMessage(ChatColor.DARK_RED + "Not configured. Messages.bookContent must include " + ChatColor.GRAY + "\"{CODE}\"");
                            event.setCancelled(true);
                            return;
                        }
                        if (other.getInventory().firstEmpty() == -1) {
                            player.sendMessage(ChatColor.GRAY + "Player has a full inventory.");
                            event.setCancelled(true);
                            return;
                        }
                        Random random = new Random();
                        int code = random.nextInt(995);
                        trolledUser.setHackerTrollCode(code + "C");

                        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
                        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
                        bookMeta.setTitle(configFile.getHackerTrollBookTitle().replace("{NICK}", other.getName()));
                        bookMeta.setAuthor(configFile.getHackerTrollBookAuthor());
                        bookMeta.setPages(Collections.singletonList(configFile.getHackerTrollBookContent().replace("{CODE}", code + "C")));
                        writtenBook.setItemMeta(bookMeta);

                        player.sendMessage(messages.getHackerTroll());
                        player.getInventory().addItem(writtenBook);
                        event.setCancelled(true);
                    }
                    break;
                default:
                    event.setCancelled(true);
                    break;
            }
        }
    }

    private void switchFakeAdmin(Player player, TrolledUserProperties trolledUser, Player other, boolean fakeAdmin) {
        trolledUser.setFakeAdmin(fakeAdmin);
        if (configFile.isVictimMessage()) other.sendMessage(messages.getAdminNow());
        String msg = messages.getGaveAdmin().replace("{NICK}", other.getName());
        player.sendMessage(msg);
    }

    private void toggleMinecartTroll(Player player, TrolledUserProperties trolledUser, Player other, boolean minecartTroll) {
        trolledUser.setMinecartTroll(minecartTroll);
        if (minecartTroll) {
            player.sendMessage(messages.getMinecartToTroller());
            if (configFile.isVictimMessage()) other.sendMessage(messages.getMinecartToVictim());
        } else {
            if (configFile.isVictimMessage()) other.sendMessage(messages.getMinecartNotDone());
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
            sender.sendMessage(messages.getOfflinePlayer());
            return false;
        }
        return true;
    }
}
