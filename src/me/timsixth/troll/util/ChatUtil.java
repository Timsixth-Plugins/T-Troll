package me.timsixth.troll.util;

import org.bukkit.ChatColor;

public class ChatUtil {
	
	public static String chatColor(String fix) {
		return ChatColor.translateAlternateColorCodes('&', fix);
	}

}
