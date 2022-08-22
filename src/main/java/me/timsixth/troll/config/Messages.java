package me.timsixth.troll.config;

import lombok.Getter;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.util.ChatUtil;

@Getter
public class Messages {

    private final String correctUse;
    private final String noPermission;
    private final String blowup;
    private final String adminNow;
    private final String gaveAdmin;
    private final String gaveOp;
    private final String frezzedPlayer;
    private final String unfreezed;
    private final String lauchedPlayer;
    private final String sendCrash;
    private final String offlinePlayer;
    private final String fakeBan;
    private final String bannedPlayer;
    private final String spawnWeb;
    private final String spawnAnvil;
    private final String spawnWater;
    private final String spawnLava;
    private final String spawnZombie;
    private final String spawnArrow;
    private final String strikeLightning;
    private final String poisoned;
    private final String rotated;
    private final String creeperHiss;
    private final String fakeExp;
    private final String speed;
    private final String scare;
    private final String teleport;
    private final String woodenPick;
    private final String woodenPickOther;
    private final String spawnTp;
    private final String filledInv;
    private final String noHandItem;
    private final String droppedHandItem;
    private final String spammed;
    private final String swapped;
    private final String drunk;
    private final String drunkOther;
    private final String fakeJoin;
    private final String fakeJoinOther;
    private final String openInv;

    private final String putOnPumpkin;

    public Messages(TrollPlugin trollPlugin) {
        correctUse = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.correctuse"));
        noPermission = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.nopermission"));
        blowup = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.blowup"));
        adminNow = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.adminnow"));
        gaveAdmin = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.gaveadmin"));
        gaveOp = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.gaveop"));
        frezzedPlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.frozeplayer"));
        unfreezed = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.unfreeze"));
        lauchedPlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.lauchedplyaer"));
        sendCrash = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.sendcrash"));
        offlinePlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.offlineplayer"));
        fakeBan = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.fakeban"));
        bannedPlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.bannedplayer"));
        spawnWeb = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawnweb"));
        spawnAnvil = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawnanvil"));
        spawnWater = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawnwater"));
        spawnLava = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawnlava"));
        spawnZombie = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawnzombie"));
        spawnArrow = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawnarrow"));
        strikeLightning = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.strikelightning"));
        poisoned = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.poisoned"));
        rotated = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.rotated"));
        creeperHiss = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.creeperhiss"));
        fakeExp = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.fakeexp"));
        speed = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.speed"));
        scare = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.scare"));
        teleport = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.teleport"));
        woodenPick = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.wooden_pick"));
        woodenPickOther = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.wooden_pick_other"));
        spawnTp = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawntp"));
        filledInv = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.filledinv"));
        noHandItem = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.nohanditem"));
        droppedHandItem = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.droppedhanditem"));
        spammed = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spammed"));
        swapped = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.swapped"));
        drunk = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.drunk"));
        drunkOther = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.drunkother"));
        fakeJoin = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.fakejoin"));
        fakeJoinOther = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.fakejoinother"));
        openInv = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.openinv"));
        putOnPumpkin = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.put_on_pumpkin"));
    }
}
