package me.timsixth.troll.manager;

import org.bukkit.entity.Player;

import java.util.*;

public class UserManager {

    private final Map<UUID, UUID> otherPlayers = new HashMap<>();
    private final List<UUID> fakeAdmins = new ArrayList<>();
    private final List<UUID> frozenPlayers = new ArrayList<>();

    private final Map<UUID, Integer> fakeExp = new HashMap<>();


    public void savePlayerExp(Player player) { fakeExp.put(player.getUniqueId(), player.getTotalExperience()); }
    public int getPrevPlayerExp(Player player) { return fakeExp.get(player.getUniqueId()); }
    public void setPlayerExp(Player player) { player.setTotalExperience(getPrevPlayerExp(player)); }

    public Map<UUID, Integer> getFakeExp() {
        return fakeExp;
    }

    public void addPlayer(Player sender, Player other) {
        otherPlayers.put(sender.getUniqueId(), other.getUniqueId());
    }

    public void removePlayer(Player sender) {
        otherPlayers.remove(sender.getUniqueId(), null);
    }

    public boolean containsPlayer(Player player) {
        return otherPlayers.containsKey(player.getUniqueId());
    }

    public UUID getPlayer(Player sender) {
        return otherPlayers.get(sender.getUniqueId());
    }

    public void freezePlayer(Player player) {
        frozenPlayers.add(player.getUniqueId());
    }

    public void unFreeze(Player player) {
        frozenPlayers.remove(player.getUniqueId());
    }

    public boolean isFrozen(Player player) {
        return frozenPlayers.contains(player.getUniqueId());
    }

    public void giveFakeAdmin(Player player) {
        fakeAdmins.add(player.getUniqueId());
    }

    public void removeFakeAdmin(Player player) {
        fakeAdmins.remove(player.getUniqueId());
    }

    public boolean isFakeAdmin(Player player) {
        return fakeAdmins.contains(player.getUniqueId());
    }


}
