package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class LuckyNameTagTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {

        ItemUtil.giveItems(other, configFile.getLuckyNameTag());

        if (configFile.isVictimMessage()) other.sendMessage(messages.getReceivedLuckyNameTag());

        sender.sendMessage(messages.getGivenLuckyNameTag());
    }

    @Override
    public String getName() {
        return "LUCKY_NAME_TAG";
    }
}
