package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
@RequiredArgsConstructor
public class BlowUpTroll implements Troll {

    private final ConfigFile configFile;
    private final Messages messages;

    @Override
    public void executeTroll(Player other,Player sender ,TrolledUserProperties userProperties) {
        other.getWorld().createExplosion(other.getLocation(), configFile.getPowerOfExplosion());
        sender.sendMessage(messages.getBlowup());
    }

    @Override
    public String getName() {
        return "BLOW_UP";
    }
}
