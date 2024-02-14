package me.timsixth.troll.config;

import lombok.AccessLevel;
import lombok.Getter;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.util.ChatUtil;

@Getter
public class Messages {

    @Getter(value = AccessLevel.NONE)
    private final TrollPlugin trollPlugin;

    private String correctUse;
    private String noPermission;
    private String blowup;
    private String adminNow;
    private String gaveAdmin;
    private String gaveOp;
    private String frezzedPlayer;
    private String unfreezed;
    private String lauchedPlayer;
    private String sendCrash;
    private String offlinePlayer;
    private String fakeBan;
    private String bannedPlayer;
    private String spawnWeb;
    private String spawnAnvil;
    private String spawnWater;
    private String spawnLava;
    private String spawnZombie;
    private String spawnArrow;
    private String strikeLightning;
    private String poisoned;
    private String rotated;
    private String creeperHiss;
    private String fakeExp;
    private String speed;
    private String scare;
    private String teleport;
    private String woodenPick;
    private String woodenPickOther;
    private String spawnTp;
    private String onlyInOverworld;
    private String filledInv;
    private String noHandItem;
    private String droppedHandItem;
    private String spammed;
    private String swapped;
    private String drunk;
    private String drunkOther;
    private String fakeJoin;
    private String fakeJoinOther;
    private String openInv;
    private String putOnPumpkin;
    private String adminCorrectUse;
    private String filesReloaded;
    private String slimeName;
    private String youGetSlime;
    private String newFriend;
    private String minecartToTroller;
    private String minecartToVictim;
    private String minecartDone;
    private String minecartNotDone;
    private String hackerTroll;
    private String giveRandomPotionEffect;
    private String giveGlassToPlayer;
    private String getGlassButCanNotDrop;
    private String giveRewardFromAdmin;
    private String getRewardFromAdmin;
    private String burnPlayer;
    private String madeHunger;
    private String hitPlayer;

    public Messages(TrollPlugin trollPlugin) {
        this.trollPlugin = trollPlugin;
        loadMessages();
    }

    void loadMessages() {
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
        onlyInOverworld = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.spawntpNetherError"));
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
        slimeName = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.slime_name"));
        newFriend = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.newFriend"));
        youGetSlime = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.you_get_slime"));
        minecartToTroller = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.minecart_toTroller"));
        minecartToVictim = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.minecart_toVictim"));
        minecartDone = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.minecart_taskDone"));
        minecartNotDone = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.minecart_taskNotDone"));
        hackerTroll = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.hackerTroll"));
        adminCorrectUse = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.admin_correct_use"));
        filesReloaded = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.files_reloaded"));
        giveRandomPotionEffect = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.give_random_potion_effect"));
        giveGlassToPlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.give_glass"));
        getGlassButCanNotDrop = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.get_glass"));
        giveRewardFromAdmin = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.give_reward"));
        getRewardFromAdmin = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.get_reward_from_admin"));
        burnPlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.burn_player"));
        madeHunger = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.made_hunger"));
        hitPlayer = ChatUtil.chatColor(trollPlugin.getConfig().getString("messages.hit_player"));
    }
}
