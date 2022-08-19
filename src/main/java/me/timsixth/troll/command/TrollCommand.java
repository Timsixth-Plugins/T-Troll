package me.timsixth.troll.command;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.manager.InventoryManager;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Optional;

@RequiredArgsConstructor
public class TrollCommand implements CommandExecutor {

    private final InventoryManager inventoryManager;
    private final TrollManager trollManager;

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

                Optional<Troll> trollBySenderUuid = trollManager.getTrollBySenderUuid(player.getUniqueId());
                trollBySenderUuid.ifPresent(trollManager::removeTroll);
                if (other != null) {
                    trollManager.createNewTroll(new Troll(player.getUniqueId(), other.getUniqueId(), new TrolledUserProperties()));
                    player.openInventory(inventoryManager.showTrollingInventory());
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
