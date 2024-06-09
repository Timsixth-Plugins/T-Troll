package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.XSound;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.sql.SQLException;

@RequiredArgsConstructor
public class WardenSoundTroll implements Troll {


    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        XSound.play(other, "ENTITY_WARDEN_ANGRY");
        sender.sendMessage(messages.getWardenSound());
    }

    @Override
    public String getName() {
        return "WARDEN_SOUND";
    }
}
