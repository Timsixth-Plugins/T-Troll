package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class SwitchFakeAdminTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        userProperties.setFakeAdmin(!userProperties.isFakeAdmin());

        if (configFile.isVictimMessage()) other.sendMessage(messages.getAdminNow());

        String msg = messages.getGaveAdmin().replace("{NICK}", other.getName());
        sender.sendMessage(msg);
    }

    @Override
    public String getName() {
        return "FAKE_ADMIN";
    }
}
