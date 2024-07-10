package me.timsixth.troll.util;

import lombok.RequiredArgsConstructor;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiredArgsConstructor
public class UniversalItemMeta {
    private final ItemMeta meta;

    public boolean hasLocalizedName() {
        try {
            Method method = meta.getClass().getMethod("hasItemName");
            method.setAccessible(true);

            return (boolean) method.invoke(meta);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return meta.hasLocalizedName();
        }
    }

    public void setLocalizedName(String localizeName) {
        try {
            Method method = meta.getClass().getMethod("setItemName", String.class);
            method.setAccessible(true);

            method.invoke(meta, localizeName);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            meta.setLocalizedName(localizeName);
        }
    }

    public String getLocalizedName() {
        try {
            Method method = meta.getClass().getMethod("getItemName");
            method.setAccessible(true);

            return (String) method.invoke(meta);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            return meta.getLocalizedName();
        }
    }

    public ItemMeta toItemMeta() {
        return meta;
    }

}
