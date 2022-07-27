package me.timsixth.troll.util;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;
@UtilityClass
public class ChatUtil {
	
	public static String chatColor(String text) {
		return ChatColor.translateAlternateColorCodes('&', text);
	}

}
