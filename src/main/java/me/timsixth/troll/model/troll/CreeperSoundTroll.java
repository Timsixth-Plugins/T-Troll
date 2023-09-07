package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.XSound;
import org.bukkit.entity.Player;
@RequiredArgsConstructor
public class CreeperSoundTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        XSound.play(other, "CREEPER_HISS");

        sender.sendMessage(messages.getCreeperHiss());
    }

    @Override
    public String getName() {
        return "CREEPER_SOUND";
    }
}
