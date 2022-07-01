package me.timsixth.troll.manager;

import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvManager {

	public Inventory showTrollingInventory() {
		Inventory inv = Bukkit.createInventory(null, 45, ConfigFile.GUI_NAME);
		
		ItemStack tnt = ItemUtil.createItem(new ItemStack(Material.TNT), "&9&lTroll &8- &7Blow up the player");
		ItemStack fakeAdmin  = ItemUtil.createItem(new ItemStack(Material.INK_SACK,1, (short)1), "&9&lTroll &8- &7Give fake admin to player");
		ItemStack fakeOp = ItemUtil.createItem(new ItemStack(Material.COMMAND), "&9&lTroll &8- &7Give fake op to player");
		ItemStack freeze = ItemUtil.createItem(new ItemStack(Material.ICE), "&9&lTroll &8- &7Freeze/UnFreeze the player");
		ItemStack rocket = ItemUtil.createItem(new ItemStack(Material.REDSTONE_BLOCK), "&9&lTroll &8- &7Launch rocket with player in to cosmos");
		ItemStack fakecrash = ItemUtil.createItem(new ItemStack(Material.INK_SACK), "&9&lTroll &8- &7Give fake crash to player");
		ItemStack fakeban = ItemUtil.createItem(new ItemStack(Material.BARRIER), "&9&lTroll &8- &7Give fake ban to player");
		ItemStack web = ItemUtil.createItem(new ItemStack(Material.WEB),"&9&lTroll &8- &7Spawns webs under the player");
		ItemStack anvil = ItemUtil.createItem(new ItemStack(Material.ANVIL),"&9&lTroll &8- &7Will spawn anvil above the player");
		ItemStack lavaBucket = ItemUtil.createItem(new ItemStack(Material.LAVA_BUCKET),"&9&lTroll &8- &7Spawns lava under the player");
		ItemStack waterBucket = ItemUtil.createItem(new ItemStack(Material.WATER_BUCKET),"&9&lTroll &8- &7Spawns water under the player");
		ItemStack zombieMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG,1,(short) 54),"&9&lTroll &8- &7Spawns a zombie at the player location");
		ItemStack arrows = ItemUtil.createItem(new ItemStack(Material.ARROW),"&9&lTroll &8- &7Spawns few arrows above the player (*)");
		ItemStack lightning = ItemUtil.createItem(new ItemStack(Material.FLINT_AND_STEEL),"&9&lTroll &8- &7Strikes the player with lightning (*)");
		ItemStack poisonedPotato = ItemUtil.createItem(new ItemStack(Material.POISONOUS_POTATO),"&9&lTroll &8- &7Make your victim suffer from poison (*)");
		ItemStack compass = ItemUtil.createItem(new ItemStack(Material.COMPASS),"&9&lTroll &8- &7Rotate your victim 180° (*)");
		ItemStack creeperMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG,1,(short) 50),"&9&lTroll &8- &7Terrify your victim with creeper sound (*)");
		ItemStack expBottle = ItemUtil.createItem(new ItemStack(Material.EXP_BOTTLE),"&9&lTroll &8- &7Take exp from your victim for 10 seconds (*)");
//		ItemStack feather = ItemUtil.createItem(new ItemStack(Material.FEATHER),"&9&lTroll &8- &7Apply uncontrollable speed to your victim (*)");
//		ItemStack fireball = ItemUtil.createItem(new ItemStack(Material.FIREBALL),"&9&lTroll &8- &7Scare your victim with loud sound (*)");
//		ItemStack compass2 = ItemUtil.createItem(new ItemStack(Material.COMPASS),"&9&lTroll &8- &7Teleport your victim in random place within 20 blocks range (*)");

		inv.setItem(0, tnt);
		inv.setItem(1, fakeAdmin);
		inv.setItem(2, fakeOp);
		inv.setItem(3, freeze);
		inv.setItem(4, rocket);
		inv.setItem(5, fakecrash);
		inv.setItem(6, fakeban);
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
//		inv.setItem(18, feather);
//		inv.setItem(19, fireball);
//		inv.setItem(20, compass2);


		return inv;
	}
	
}
