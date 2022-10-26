package me.timsixth.troll.command;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

@RequiredArgsConstructor
public class AdminTrollCommand implements CommandExecutor {

    private final ConfigFile configFile;
    private final Messages messages;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission(configFile.getPermission())) {
            sender.sendMessage(messages.getNoPermission());
            return true;
        }
        if (args.length == 0) {
            sender.sendMessage(messages.getAdminCorrectUse());
        } else if (args.length == 1) {
            configFile.reloadConfig();
            sender.sendMessage(messages.getFilesReloaded());
        } else {
            sender.sendMessage(messages.getAdminCorrectUse());
        }

        return false;
    }
}
