package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class CopierTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        ItemUtil.giveItems(other, configFile.getCopier());

        sender.sendMessage(messages.getGivenCopier());
        if (configFile.isVictimMessage()) other.sendMessage(messages.getReceivedCopier());
    }

    @Override
    public String getName() {
        return "COPIER";
    }

}
