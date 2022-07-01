package me.timsixth.troll.manager;

import me.timsixth.troll.model.Troll;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserManager {
    private final List<Troll> trolls = new ArrayList<>();

    public void createNewTroll(Troll troll){
        trolls.add(troll);
    }
    public boolean trollExists(Troll troll){
        return trolls.contains(troll);
    }

    public void removeTroll(Troll troll){
        trolls.remove(troll);
    }

    public Troll getTrollBySenderUuid(UUID uuid){
        return trolls.stream()
                .filter(troll -> troll.getSenderUuid().equals(uuid))
                .findAny()
                .orElse(null);
    }
    public Troll getTrollByVictimUuid(UUID uuid){
        return trolls.stream()
                .filter(trolledUser -> trolledUser.getVictimUuid().equals(uuid))
                .findAny()
                .orElse(null);
    }
}
