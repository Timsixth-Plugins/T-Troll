package me.timsixth.troll.command;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.TrollProcess;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.timsixth.guilibrary.core.manager.YAMLMenuManager;
import pl.timsixth.guilibrary.core.model.Menu;

import java.util.Optional;

@RequiredArgsConstructor
public class TrollCommand implements CommandExecutor {

    private final YAMLMenuManager menuManager;
    private final TrollProcessManager trollProcessManager;

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

                if (other != null) {
                    trollProcessManager.createNewTroll(new TrollProcess(player.getUniqueId(), other.getUniqueId()));

                    Optional<Menu> menuOptional = menuManager.getMenuByName("trollsGui");

                    if (!menuOptional.isPresent()) return true;

                    player.openInventory(menuManager.createMenu(menuOptional.get()));
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
