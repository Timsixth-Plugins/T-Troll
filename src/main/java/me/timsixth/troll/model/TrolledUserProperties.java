package me.timsixth.troll.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter
@Setter
@ToString
public class TrolledUserProperties {

    private boolean frozen;
    private boolean fakeAdmin;
    private boolean minecartTroll;
    private boolean canNotDropGlass;
    private String hackerTrollCode;
    private int level;
    private float exp;
    private final ItemStack[] inventory;
    private final ItemStack[] armor;
    private boolean enderman;
    private boolean loweredReach;
    private boolean swapLavaWater;
    private boolean oneHeart;
    private double health;
    private double maxHealth;

    public TrolledUserProperties() {
        inventory = new ItemStack[36];
        armor = new ItemStack[4];
    }

    public void toggleOneHeart(Player other) {
        AttributeInstance attribute = other.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        if (!oneHeart) {
            maxHealth = attribute.getBaseValue();
            health = other.getHealth();

            attribute.setBaseValue(2);
            other.setHealth(2);

            oneHeart = true;
        } else {
            attribute.setBaseValue(maxHealth);
            other.setHealth(health);

            oneHeart = false;
        }
    }
}
