package me.timsixth.troll.manager;

import me.timsixth.troll.model.Troll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TrollManager {
    private final List<Troll> trolls = new ArrayList<>();

    public void addTrolls(Troll... trolls) {
        this.trolls.addAll(Arrays.asList(trolls));
    }

    public Optional<Troll> getTrollByName(String name) {
        return this.trolls.stream()
                .filter(troll -> troll.getName().equalsIgnoreCase(name))
                .findAny();
    }
}
