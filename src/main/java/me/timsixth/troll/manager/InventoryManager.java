package me.timsixth.troll.manager;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class InventoryManager {
    
    private final ConfigFile configFile;

    public Inventory showTrollingInventory() {
        Inventory inv = Bukkit.createInventory(null, 45,configFile.getGuiName());

        ItemStack tnt = ItemUtil.createItem(new ItemStack(Material.TNT),  configFile.getGuiPrefix() + " &7Blow up the player");
        ItemStack fakeAdmin = ItemUtil.createItem(new ItemStack(Material.INK_SACK, 1, (short) 1),  configFile.getGuiPrefix() + " &7Give fake admin to player");
        ItemStack fakeOp = ItemUtil.createItem(new ItemStack(Material.COMMAND),  configFile.getGuiPrefix() + " &7Give fake op to player");
        ItemStack freeze = ItemUtil.createItem(new ItemStack(Material.ICE),  configFile.getGuiPrefix() + " &7Freeze/UnFreeze the player");
        ItemStack rocket = ItemUtil.createItem(new ItemStack(Material.REDSTONE_BLOCK),  configFile.getGuiPrefix() + " &7Launch rocket with player in to cosmos");
        ItemStack fakeCrash = ItemUtil.createItem(new ItemStack(Material.INK_SACK),  configFile.getGuiPrefix() + " &7Give fake crash to player");
        ItemStack fakeBan = ItemUtil.createItem(new ItemStack(Material.BARRIER),  configFile.getGuiPrefix() + " &7Give fake ban to player");
        ItemStack web = ItemUtil.createItem(new ItemStack(Material.WEB),  configFile.getGuiPrefix() + " &7Spawns webs under the player");
        ItemStack anvil = ItemUtil.createItem(new ItemStack(Material.ANVIL),  configFile.getGuiPrefix() + " &7Will spawn anvil above the player");
        ItemStack lavaBucket = ItemUtil.createItem(new ItemStack(Material.LAVA_BUCKET),  configFile.getGuiPrefix() + " &7Spawns lava under the player");
        ItemStack waterBucket = ItemUtil.createItem(new ItemStack(Material.WATER_BUCKET),  configFile.getGuiPrefix() + " &7Spawns water under the player");
        ItemStack zombieMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 54),  configFile.getGuiPrefix() + "&9&lTroll &8- &7Spawns zombies at the player location");
        ItemStack arrows = ItemUtil.createItem(new ItemStack(Material.ARROW),  configFile.getGuiPrefix() + " &7Spawns few arrows above the player");
        ItemStack lightning = ItemUtil.createItem(new ItemStack(Material.FLINT_AND_STEEL),  configFile.getGuiPrefix() + " &7Strikes the player with lightning");
        ItemStack poisonedPotato = ItemUtil.createItem(new ItemStack(Material.POISONOUS_POTATO),  configFile.getGuiPrefix() + " &7Make your victim suffer from poison");
        ItemStack compass = ItemUtil.createItem(new ItemStack(Material.COMPASS),  configFile.getGuiPrefix() + " &7Rotate your victim 180°");
        ItemStack creeperMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG, 1, (short) 50),  configFile.getGuiPrefix() + "&9&lTroll &8- &7Terrify your victim with creeper sound");
        ItemStack expBottle = ItemUtil.createItem(new ItemStack(Material.EXP_BOTTLE),  configFile.getGuiPrefix() + " &7Take exp from your victim for 10 seconds");
        ItemStack feather = ItemUtil.createItem(new ItemStack(Material.FEATHER),  configFile.getGuiPrefix() + " &7Apply uncontrollable speed to your victim");
        ItemStack fireball = ItemUtil.createItem(new ItemStack(Material.FIREBALL),  configFile.getGuiPrefix() + " &7Scare your victim with loud sound");
        ItemStack compass2 = ItemUtil.createItem(new ItemStack(Material.COMPASS),  configFile.getGuiPrefix() + " &7Teleport your victim in random place within 20 blocks range");
        ItemStack woodenPickaxe = ItemUtil.createItem(new ItemStack(Material.WOOD_PICKAXE),  configFile.getGuiPrefix() + " &7Teleport your victim 20 blocks below his current location with wooden pickaxe");
        ItemStack bed = ItemUtil.createItem(new ItemStack(Material.BED),  configFile.getGuiPrefix() + " &7Teleport your victim to overworld spawn point");
        ItemStack dirt = ItemUtil.createItem(new ItemStack(Material.DIRT),  configFile.getGuiPrefix() + " &7Clear your victims whole inventory for 10 seconds!");
        ItemStack stonePickaxe = ItemUtil.createItem(new ItemStack(Material.STONE_PICKAXE),  configFile.getGuiPrefix() + " &7Drop item in player's hand");
        ItemStack paper = ItemUtil.createItem(new ItemStack(Material.PAPER),  configFile.getGuiPrefix() + " &7Spams players chat");
        ItemStack eye = ItemUtil.createItem(new ItemStack(Material.EYE_OF_ENDER),  configFile.getGuiPrefix() + " &7Swaps the positions with the player");
        ItemStack drunk = ItemUtil.createItem(new ItemStack(Material.POTION),  configFile.getGuiPrefix() + " &7Applies drunk effect to player");
        ItemStack map = ItemUtil.createItem(new ItemStack(Material.MAP),  configFile.getGuiPrefix() + " &7Sends fake join message to player");
        ItemStack chest = ItemUtil.createItem(new ItemStack(Material.CHEST),  configFile.getGuiPrefix() + " &7Opens players inventory");
        ItemStack pumpkin = ItemUtil.createItem(new ItemStack(Material.PUMPKIN),  configFile.getGuiPrefix() + " &7Put on pumpkin on trolled player's head ");

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

        return inv;
    }
}
