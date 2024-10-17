package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class HotPotatoTroll implements Troll {

    private final ConfigFile configFile;
    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {

        ItemStack hotPotato = configFile.getHotPotato();
        ItemUtil.giveItems(other, hotPotato);

        sender.sendMessage(messages.getGivesHotPotato());
    }

    @Override
    public String getName() {
        return "HOT_POTATO";
    }
}
