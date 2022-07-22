package me.timsixth.troll.model;

import org.bukkit.inventory.ItemStack;


public class TrolledUserProperties {

    private boolean frozen;
    private boolean fakeAdmin;
    private int level;
    private float exp;

    final ItemStack[] inv = new ItemStack[36];
    final ItemStack[] armor = new ItemStack[4];

    public ItemStack[] getInventory() { return inv; }

    public ItemStack[] getArmor() { return armor; }

    public boolean isFrozen() {
        return frozen;
    }

    public void setFrozen(boolean frozen) {
        this.frozen = frozen;
    }

    public boolean isFakeAdmin() {
        return fakeAdmin;
    }

    public void setFakeAdmin(boolean fakeAdmin) {
        this.fakeAdmin = fakeAdmin;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public float getExp() {
        return exp;
    }

    public void setExp(float exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "TrolledUserProperties{" +
                ", frozen=" + frozen +
                ", fakeAdmin=" + fakeAdmin +
                ", level=" + level +
                ", exp=" + exp +
                '}';
    }
}
