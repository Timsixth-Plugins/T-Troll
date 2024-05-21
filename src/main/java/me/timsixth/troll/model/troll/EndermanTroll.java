package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class EndermanTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {

        if (userProperties.isEnderman()) {
            userProperties.setEnderman(false);
            sender.sendMessage(messages.getEndermanModeDisabled());

            if (configFile.isVictimMessage()) other.sendMessage(messages.getYouAreNotEndermanNow());
        } else {
            userProperties.setEnderman(true);

            ItemUtil.giveItems(other, new ItemStack(Material.ENDER_PEARL, 16));

            sender.sendMessage(messages.getEndermanModeEnabled());

            if (configFile.isVictimMessage()) other.sendMessage(messages.getYouAreEnderman());
        }

    }

    @Override
    public String getName() {
        return "ENDERMAN";
    }
}
