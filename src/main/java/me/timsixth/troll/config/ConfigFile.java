package me.timsixth.troll.config;

import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.util.ChatUtil;

public class ConfigFile {
	
	public static final String PERMISSION = TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("permission");
	public static final String GUI_NAME = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("guiname"));
	public static final String FAKEADMIN_FORMAT = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("fakeadmin_format"));
	public static final String FAKEOP_FORMAT = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("fakeop_format"));
	public static final float POWER_OF_EXPLOSION = TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getInt("power_explosion");
	public static final String CORRECT_USE = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.correctuse"));
	public static final String NO_PERMISSION = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.nopermission"));
	public static final String BLOWUP = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.blowup"));
	public static final String ADMIN_NOW = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.adminnow"));
	public static final String GAVE_ADMIN = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.gaveadmin"));
	public static final String GAVE_OP = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.gaveop"));
	public static final String FREZZED_PLAYER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.frozeplayer"));
	public static final String UNFREEZED = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.unfreeze"));
	public static final String LAUCHED_PLAYER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.lauchedplyaer"));
	public static final String SENDCRASH = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.sendcrash"));
	public static final String OFFLINEPLAYER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.offlineplayer"));
	public static final String FAKEBAN = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.fakeban"));
	public static final String BANNED_PLAYER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.bannedplayer"));
	public static final String SPAWN_WEB = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawnweb"));
	public static final String SPAWN_ANVIL = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawnanvil"));
	public static final String SPAWN_WATER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawnwater"));
	public static final String SPAWN_LAVA = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawnlava"));
	public static final String SPAWN_ZOMBIE = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawnzombie"));
	public static final String SPAWN_ARROW = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawnarrow"));
	public static final String STRIKE_LIGHTNING = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.strikelightning"));
	public static final String POISONED = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.poisoned"));
	public static final String ROTATED = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.rotated"));
	public static final String CREEPER_HISS = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.creeperhiss"));
	public static final String FAKE_EXP = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.fakeexp"));
	public static final String SPEED = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.speed"));
	public static final String SCARE = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.scare"));
	public static final String TELEPORT = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.teleport"));
	public static final String WOODEN_PICK = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.wooden_pick"));
	public static final String WOODEN_PICK_OTHER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.wooden_pick_other"));
	public static final String SPAWN_TP = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spawntp"));
	public static final String FILLED_INV = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.filledinv"));
	public static final String NO_HAND_ITEM = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.nohanditem"));
	public static final String DROPPED_HAND_ITEM = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.droppedhanditem"));
	public static final String SPAMMED = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.spammed"));
	public static final String SWAPPED = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.swapped"));
	public static final String DRUNK = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.drunk"));
	public static final String DRUNK_OTHER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.drunkother"));
	public static final String FAKE_JOIN = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.fakejoin"));
	public static final String FAKE_JOIN_OTHER = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.fakejoinother"));
	public static final String OPEN_INV = ChatUtil.chatColor(TrollPlugin.getPlugin(TrollPlugin.class).getConfig().getString("messages.openinv"));

}
