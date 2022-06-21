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
		
		ItemStack tnt = ItemUtil.createItem(new ItemStack(Material.TNT), "&cBlow up the player");
		ItemStack fakeAdmin  = ItemUtil.createItem(new ItemStack(Material.INK_SACK,1, (short)1), "&cGive fake admin to player");
		ItemStack fakeOp = ItemUtil.createItem(new ItemStack(Material.COMMAND), "&cGive fake op to player");
		ItemStack freeze = ItemUtil.createItem(new ItemStack(Material.ICE), "&9Freeze/UnFreeze the player");
		ItemStack rocket = ItemUtil.createItem(new ItemStack(Material.REDSTONE_BLOCK), "&eLaunch rocket with player in to cosmos");
		ItemStack fakecrash = ItemUtil.createItem(new ItemStack(Material.INK_SACK), "&eGive fake crash to player");
		ItemStack fakeban = ItemUtil.createItem(new ItemStack(Material.BARRIER), "&eGive fake ban to player");
		ItemStack web = ItemUtil.createItem(new ItemStack(Material.WEB),"&eSpawns webs under the player");
		ItemStack anvil = ItemUtil.createItem(new ItemStack(Material.ANVIL),"&eWill spawn anvil above the player");
		ItemStack lavaBucket = ItemUtil.createItem(new ItemStack(Material.LAVA_BUCKET),"&eSpawns lava under the player");
		ItemStack waterBucket = ItemUtil.createItem(new ItemStack(Material.WATER_BUCKET),"&eSpawns water under the player");
		ItemStack zombieMonsterEgg = ItemUtil.createItem(new ItemStack(Material.MONSTER_EGG,1,(short) 54),"&eSpawns a zombie at the player location");
		ItemStack arrows = ItemUtil.createItem(new ItemStack(Material.ARROW),"&eSpawns few arrows above the player (*)");
		ItemStack lightning = ItemUtil.createItem(new ItemStack(Material.FLINT_AND_STEEL),"&eStrikes the player with lightning (*)");
		ItemStack poisonedPotato = ItemUtil.createItem(new ItemStack(Material.POISONOUS_POTATO),"&eMake your victim suffer from poison (*)");


		inv.setItem(0, tnt);
		inv.setItem(1, fakeAdmin);
		inv.setItem(2, fakeOp);
		inv.setItem(3, freeze);
		inv.setItem(4, rocket);
		inv.setItem(5, fakecrash);
		inv.setItem(6, fakeban);
		inv.setItem(7,web);
		inv.setItem(8,anvil);
		inv.setItem(9,lavaBucket);
		inv.setItem(10,waterBucket);
		inv.setItem(11,zombieMonsterEgg);
		inv.setItem(12,arrows);
		inv.setItem(13,lightning);
		inv.setItem(14,poisonedPotato);

		return inv;
	}
	
}
