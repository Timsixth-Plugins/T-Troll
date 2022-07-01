package me.timsixth.troll.model;

import java.util.UUID;

public class Troll {

    private final UUID senderUuid;
    private final UUID victimUuid;
    private final TrolledUserProperties trolledUser;

    public Troll(UUID senderUuid, UUID victimUuid, TrolledUserProperties trolledUser) {
        this.senderUuid = senderUuid;
        this.victimUuid = victimUuid;
        this.trolledUser = trolledUser;
    }

    public UUID getSenderUuid() {
        return senderUuid;
    }

    public TrolledUserProperties getTrolledUser() {
        return trolledUser;
    }

    public UUID getVictimUuid() {
        return victimUuid;
    }
}
