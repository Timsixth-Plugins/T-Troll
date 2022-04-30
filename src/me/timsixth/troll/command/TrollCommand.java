package me.timsixth.troll.command;

import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.InvManager;
import me.timsixth.troll.manager.UserManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TrollCommand implements CommandExecutor {
	
	private final InvManager invManager;
	private final UserManager userManager;
	
	public TrollCommand(InvManager invManager,UserManager userManager) {
		this.invManager = invManager;
		this.userManager = userManager;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (sender instanceof Player) {
			if (!sender.hasPermission(ConfigFile.PERMISSION)) {
				sender.sendMessage(ConfigFile.NO_PERMISSION);
				return true;
			}
			Player player = (Player) sender;

			if (args.length == 0) {
				player.sendMessage(ConfigFile.CORRECT_USE);
				return true;
			} else if (args.length == 1) {
				if (!userManager.containsPlayer(player)) {
					Player other = Bukkit.getPlayerExact(args[0]);
					if (other != null) {
						userManager.addPlayer(player, other);
						player.openInventory(invManager.showTrollingInventory());
					} else {
						player.sendMessage(ConfigFile.OFFLINEPLAYER);
					}
				} else {
					userManager.removePlayer(player);
					Player other = Bukkit.getPlayerExact(args[0]);
					if (other != null) {
						userManager.addPlayer(player, other);
						player.openInventory(invManager.showTrollingInventory());
					} else {
						player.sendMessage(ConfigFile.OFFLINEPLAYER);
					}
				}
				return true;
			}
		} else {
			System.out.println("Only players can use this command");
		}
		return true;
	}

}