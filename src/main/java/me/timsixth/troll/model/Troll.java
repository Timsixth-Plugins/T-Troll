package me.timsixth.troll.model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class Troll {

    private final UUID senderUuid;
    private final UUID victimUuid;
    private final TrolledUserProperties trolledUser;

    public Troll(UUID senderUuid, UUID victimUuid) {
        this.senderUuid = senderUuid;
        this.victimUuid = victimUuid;
        this.trolledUser = new TrolledUserProperties();
    }
}
