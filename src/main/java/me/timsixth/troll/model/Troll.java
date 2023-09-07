package me.timsixth.troll.model;

import org.bukkit.entity.Player;

public interface Troll {

    void executeTroll(Player other, Player sender, TrolledUserProperties userProperties);

    String getName();
}
