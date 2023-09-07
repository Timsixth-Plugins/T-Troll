package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class FakeOpTroll implements Troll {

    private final ConfigFile configFile;
    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        String msgToOther = configFile.getFakeOpFormat().replace("{NICK}", other.getName());
        String msgToSender = messages.getGaveOp().replace("{NICK}", other.getName());
        other.sendMessage(msgToOther);
        sender.sendMessage(msgToSender);
    }

    @Override
    public String getName() {
        return "FAKE_OP";
    }
}
