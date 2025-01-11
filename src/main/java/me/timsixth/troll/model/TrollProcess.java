package me.timsixth.troll.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class TrollProcess {

    private final UUID senderUuid;
    private final UUID victimUuid;
    private final TrolledUserProperties trolledUser;
    private boolean cached;

    public TrollProcess(UUID senderUuid, UUID victimUuid) {
        this.senderUuid = senderUuid;
        this.victimUuid = victimUuid;
        this.trolledUser = new TrolledUserProperties();
        this.cached = false;
    }
}
