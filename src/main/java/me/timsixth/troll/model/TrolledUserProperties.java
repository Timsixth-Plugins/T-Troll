package me.timsixth.troll.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
@ToString
public class TrolledUserProperties {

    private boolean frozen;
    private boolean fakeAdmin;
    private int level;
    private float exp;
//    private boolean diamondsUnderPlayer;
    private final ItemStack[] inventory;
    private final ItemStack[] armor;

    public TrolledUserProperties() {
        inventory = new ItemStack[36];
        armor = new ItemStack[4];
    }
}
