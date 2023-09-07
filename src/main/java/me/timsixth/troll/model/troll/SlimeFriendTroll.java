package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;

@RequiredArgsConstructor
public class SlimeFriendTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Slime slimeEntity = (Slime) other.getLocation().getWorld().spawnEntity(other.getLocation().add(0.5, 1, 0), EntityType.SLIME);
        slimeEntity.setCustomName(messages.getSlimeName());
        if (configFile.isVictimMessage()) other.sendMessage(messages.getNewFriend());
        sender.sendMessage(messages.getYouGetSlime());
    }

    @Override
    public String getName() {
        return "SLIME";
    }
}
