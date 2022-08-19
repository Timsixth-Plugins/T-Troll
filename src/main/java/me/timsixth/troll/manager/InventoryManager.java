package me.timsixth.troll.manager;

import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    public Inventory showTrollingInventory() {
        Inventory inv = Bukkit.createInventory(null, 45, ConfigFile.GUI_NAME);

        ItemStack tnt = ItemUtil.createItem(new ItemStack(Material.TNT), ConfigFile.GUI_PREFIX + " &7Blow up the player");
        ItemStack fakeAdmin = ItemUtil.createItem(new ItemStack(Material.INK_SACK, 1, (short) 1), ConfigFile.GUI_PREFIX + " &7Give fake admin to player");
        ItemStack fakeOp = ItemUtil.createItem(new ItemStack(Material.COMMAND), ConfigFile.GUI_PREFIX + " &7Give fake op to player");
        ItemStack freeze = ItemUtil.createItem(new ItemStack(Material.ICE), ConfigFile.GUI_PREFIX + " &7Freeze/UnFreeze the player");
        ItemStack rocket = ItemUtil.createItem(new ItemStack(Material.REDSTONE_BLOCK), ConfigFile.GUI_PREFIX + " &7Launch rocket with player in to cosmos");
        ItemStack fakeCrash = ItemUtil.createItem(new ItemStack(Material.INK_SACK), ConfigFile.GUI_PREFIX + " &7Give fake crash to player");
        ItemStack fakeBan = ItemUtil.createItem(new ItemStack(Material.BARRIER), ConfigFile.GUI_PREFIX + " &7Give fake ban to player");
        ItemStack web = ItemUtil.createItem(new ItemStack(Material.WEB), ConfigFile.GUI_PREFIX + " &7Spawns webs under the player");
        ItemStack anvil = ItemUtil.createItem(new ItemStack(Material.ANVIL), ConfigFile.GUI_PREFIX + " &7Will spawn anvil above the player");
        ItemStack lavaBucket = ItemUtil.createItem(new ItemStack(Material.LAVA_BUCKET), ConfigFile.GUI_PREFIX + " &7Spawns lava under the player");
        ItemStack waterBucket = ItemUtil.createItem(new ItemStack(Material.WATER_BUCKET), ConfigFile.GUI_PREFIX + " &7Spawns water under the player");
        ItemStack zombieMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 54), ConfigFile.GUI_PREFIX + "&9&lTroll &8- &7Spawns zombies at the player location");
        ItemStack arrows = ItemUtil.createItem(new ItemStack(Material.ARROW), ConfigFile.GUI_PREFIX + " &7Spawns few arrows above the player");
        ItemStack lightning = ItemUtil.createItem(new ItemStack(Material.FLINT_AND_STEEL), ConfigFile.GUI_PREFIX + " &7Strikes the player with lightning");
        ItemStack poisonedPotato = ItemUtil.createItem(new ItemStack(Material.POISONOUS_POTATO), ConfigFile.GUI_PREFIX + " &7Make your victim suffer from poison");
        ItemStack compass = ItemUtil.createItem(new ItemStack(Material.COMPASS), ConfigFile.GUI_PREFIX + " &7Rotate your victim 180°");
        ItemStack creeperMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 50), ConfigFile.GUI_PREFIX + "&9&lTroll &8- &7Terrify your victim with creeper sound");
        ItemStack expBottle = ItemUtil.createItem(new ItemStack(Material.EXP_BOTTLE), ConfigFile.GUI_PREFIX + " &7Take exp from your victim for 10 seconds");
        ItemStack feather = ItemUtil.createItem(new ItemStack(Material.FEATHER), ConfigFile.GUI_PREFIX + " &7Apply uncontrollable speed to your victim");
        ItemStack fireball = ItemUtil.createItem(new ItemStack(Material.FIREBALL), ConfigFile.GUI_PREFIX + " &7Scare your victim with loud sound");
        ItemStack compass2 = ItemUtil.createItem(new ItemStack(Material.COMPASS), ConfigFile.GUI_PREFIX + " &7Teleport your victim in random place within 20 blocks range");
        ItemStack woodenPickaxe = ItemUtil.createItem(new ItemStack(Material.WOOD_PICKAXE), ConfigFile.GUI_PREFIX + " &7Teleport your victim 20 blocks below his current location with wooden pickaxe");
        ItemStack bed = ItemUtil.createItem(new ItemStack(Material.BED), ConfigFile.GUI_PREFIX + " &7Teleport your victim to overworld spawn point");
        ItemStack dirt = ItemUtil.createItem(new ItemStack(Material.DIRT), ConfigFile.GUI_PREFIX + " &7Clear your victims whole inventory for 10 seconds!");
        ItemStack stonePickaxe = ItemUtil.createItem(new ItemStack(Material.STONE_PICKAXE), ConfigFile.GUI_PREFIX + " &7Drop item in player's hand");
        ItemStack paper = ItemUtil.createItem(new ItemStack(Material.PAPER), ConfigFile.GUI_PREFIX + " &7Spams players chat");
        ItemStack eye = ItemUtil.createItem(new ItemStack(Material.EYE_OF_ENDER), ConfigFile.GUI_PREFIX + " &7Swaps the positions with the player");
        ItemStack drunk = ItemUtil.createItem(new ItemStack(Material.POTION), ConfigFile.GUI_PREFIX + " &7Applies drunk effect to player");
        ItemStack map = ItemUtil.createItem(new ItemStack(Material.MAP), ConfigFile.GUI_PREFIX + " &7Sends fake join message to player");
        ItemStack chest = ItemUtil.createItem(new ItemStack(Material.CHEST), ConfigFile.GUI_PREFIX + " &7Opens players inventory");
        ItemStack pumpkin = ItemUtil.createItem(new ItemStack(Material.PUMPKIN), ConfigFile.GUI_PREFIX + " &7Put on pumpkin on trolled player's head ");
        //ItemStack diamondOre = ItemUtil.createItem(new ItemStack(Material.DIAMOND_ORE), ConfigFile.GUI_PREFIX + " ");

        inv.setItem(0, tnt);
        inv.setItem(1, fakeAdmin);
        inv.setItem(2, fakeOp);
        inv.setItem(3, freeze);
        inv.setItem(4, rocket);
        inv.setItem(5, fakeCrash);
        inv.setItem(6, fakeBan);
        inv.setItem(7, web);
        inv.setItem(8, anvil);
        inv.setItem(9, lavaBucket);
        inv.setItem(10, waterBucket);
        inv.setItem(11, zombieMonsterEgg);
        inv.setItem(12, arrows);
        inv.setItem(13, lightning);
        inv.setItem(14, poisonedPotato);
        inv.setItem(15, compass);
        inv.setItem(16, creeperMonsterEgg);
        inv.setItem(17, expBottle);
        inv.setItem(18, feather);
        inv.setItem(19, fireball);
        inv.setItem(20, compass2);
        inv.setItem(21, woodenPickaxe);
        inv.setItem(22, bed);
        inv.setItem(23, dirt);
        inv.setItem(24, stonePickaxe);
        inv.setItem(25, paper);
        inv.setItem(26, eye);
        inv.setItem(27, drunk);
        inv.setItem(28, map);
        inv.setItem(29, chest);
        inv.setItem(30, pumpkin);
       // inv.setItem(31,diamondOre);

        return inv;
    }

}
