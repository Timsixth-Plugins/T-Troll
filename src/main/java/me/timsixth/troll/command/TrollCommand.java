package me.timsixth.troll.command;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.InvManager;
import me.timsixth.troll.manager.UserManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class TrollCommand implements CommandExecutor {
	
	private final InvManager invManager;
	private final UserManager userManager;
	

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
				Player other = Bukkit.getPlayerExact(args[0]);
				if (userManager.trollExists(userManager.getTrollBySenderUuid(player.getUniqueId()))) {
					userManager.removeTroll(userManager.getTrollBySenderUuid(player.getUniqueId()));
				}
				if (other != null) {
					userManager.createNewTroll(new Troll(player.getUniqueId(), other.getUniqueId(), new TrolledUserProperties()));
					player.openInventory(invManager.showTrollingInventory());
				} else {
					player.sendMessage(ConfigFile.OFFLINEPLAYER);
				}
				return true;
			}
		} else {
			System.out.println("Only players can use this command");
		}
		return true;
	}

}
