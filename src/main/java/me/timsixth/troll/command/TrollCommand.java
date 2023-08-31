package me.timsixth.troll.command;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.InventoryManager;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.model.Troll;
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

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (sender instanceof Player) {
            if (!sender.hasPermission(configFile.getPermission())) {
                sender.sendMessage(messages.getNoPermission());
                return true;
            }
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(messages.getCorrectUse());
                return true;
            } else if (args.length == 1) {
                Player other = Bukkit.getPlayerExact(args[0]);

                Optional<Troll> trollBySenderUuid = trollManager.getTrollBySenderUuid(player.getUniqueId());
                trollBySenderUuid.ifPresent(trollManager::removeTroll);
                if (other != null) {
                    trollManager.createNewTroll(new Troll(player.getUniqueId(), other.getUniqueId()));
                    player.openInventory(inventoryManager.showTrollingInventory());
                } else {
                    player.sendMessage(messages.getOfflinePlayer());
                }
                return true;
            }
        } else {
            Bukkit.getLogger().info("Only players can use this command");
        }
        return true;
    }
}
