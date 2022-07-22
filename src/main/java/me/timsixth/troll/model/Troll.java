package me.timsixth.troll.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class Troll {

    private final UUID senderUuid;
    private final UUID victimUuid;
    private final TrolledUserProperties trolledUser;
}
