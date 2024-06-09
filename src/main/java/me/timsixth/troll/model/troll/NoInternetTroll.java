package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class NoInternetTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        other.kickPlayer("Internal Exception: java.net.SocketException: Connection reset");
        sender.sendMessage(messages.getNoInternet());
    }

    @Override
    public String getName() {
        return "NO_INTERNET";
    }
}
