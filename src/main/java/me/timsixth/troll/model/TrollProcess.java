package me.timsixth.troll.model;

import lombok.Getter;
import org.bukkit.Material;

import java.util.UUID;

@Getter
public class TrollProcess {

    private final UUID senderUuid;
    private final UUID victimUuid;
    private final TrolledUserProperties trolledUser;

    public TrollProcess(UUID senderUuid, UUID victimUuid) {
        this.senderUuid = senderUuid;
        this.victimUuid = victimUuid;
        this.trolledUser = new TrolledUserProperties();
    }
}
