package me.timsixth.troll.config;

import me.timsixth.troll.Main;
import me.timsixth.troll.util.ChatUtil;

public class ConfigFile {
	
	public static final String PERMISSION = Main.getMain().getConfig().getString("permission");
	public static final String GUI_NAME = ChatUtil.chatColor(Main.getMain().getConfig().getString("guiname"));
	public static final String FAKEADMIN_FORMAT = ChatUtil.chatColor(Main.getMain().getConfig().getString("fakeadmin_format"));
	public static final String FAKEOP_FORMAT = ChatUtil.chatColor(Main.getMain().getConfig().getString("fakeop_format"));
	public static final float POWER_OF_EXPLOSION = Main.getMain().getConfig().getInt("power_explosion");
	
	public static final String CORRECT_USE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.correctuse"));
	public static final String NO_PERMISSION = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.nopermission"));
	public static final String BLOWUP = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.blowup"));
	public static final String ADMIN_NOW = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.adminnow"));
	public static final String GAVE_ADMIN = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.gaveadmin"));
	public static final String GAVE_OP = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.gaveop"));
	public static final String FREZZED_PLAYER = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.frozeplayer"));
	public static final String UNFREEZED = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.unfreeze"));
	public static final String LAUCHED_PLAYER = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.lauchedplyaer"));
	public static final String SENDCRASH = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.sendcrash"));
	public static final String OFFLINEPLAYER = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.offlineplayer"));
	public static final String FAKEBAN = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.fakeban"));
	public static final String BANNED_PLAYER = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.bannedplayer"));
	public static final String SPAWN_WEB = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.spawnweb"));
	public static final String SPAWN_ANVIL = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.spawnanvil"));
	public static final String SPAWN_WATER = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.spawnwater"));
	public static final String SPAWN_LAVA = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.spawnlava"));
	public static final String SPAWN_ZOMBIE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.spawnzombie"));
	public static final String SPAWN_ARROW = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.spawnarrow"));
	public static final String STRIKE_LIGHTNING = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.strikelightning"));
	public static final String POISONED = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.poisoned"));
	public static final String ROTATED = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.rotated"));
	public static final String CREEPER_HISS = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.creeperhiss"));
	public static final String FAKE_EXP = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.fakeexp"));
	public static final String SPEED = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.speed"));
	public static final String SCARE = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.scare"));
	public static final String TELEPORT = ChatUtil.chatColor(Main.getMain().getConfig().getString("messages.teleport"));







}
