package me.timsixth.troll.manager;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
@RequiredArgsConstructor
public class UserManager {

    private final TrollPlugin trollPlugin;

    private final List<Troll> trolls = new ArrayList<>();

    public void createNewTroll(Troll troll){
        trolls.add(troll);
    }
    public boolean trollExists(Troll troll){
        return trolls.contains(troll);
    }

    public void removeTroll(Troll troll){
        trolls.remove(troll);
    }

    public Troll getTrollBySenderUuid(UUID uuid){
        return trolls.stream()
                .filter(troll -> troll.getSenderUuid().equals(uuid))
                .findAny()
                .orElse(null);
    }
    public Troll getTrollByVictimUuid(UUID uuid){
        return trolls.stream()
                .filter(trolledUser -> trolledUser.getVictimUuid().equals(uuid))
                .findAny()
                .orElse(null);
    }


    public void fakeInventoryClear(Player player) {
        TrolledUserProperties trolledUserProperties = getTrollByVictimUuid(player.getUniqueId()).getTrolledUser();

        for(int i = 0; i <= 35; ++i) {
            trolledUserProperties.getInventory()[i] = player.getInventory().getItem(i);
        }
        trolledUserProperties.getArmor()[0] = player.getInventory().getHelmet();
        trolledUserProperties.getArmor()[1] = player.getInventory().getChestplate();
        trolledUserProperties.getArmor()[2] = player.getInventory().getLeggings();
        trolledUserProperties.getArmor()[3] = player.getInventory().getBoots();

        player.getInventory().clear();
        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);

        new BukkitRunnable() {
            @Override
            public void run() {
                for(int j = 0; j <= 35; ++j) {
                    player.getInventory().setItem(j, trolledUserProperties.getInventory()[j]);
                }

                player.getInventory().setHelmet(trolledUserProperties.getArmor()[0]);
                player.getInventory().setChestplate(trolledUserProperties.getArmor()[1]);
                player.getInventory().setLeggings(trolledUserProperties.getArmor()[2]);
                player.getInventory().setBoots(trolledUserProperties.getArmor()[3]);
            }
        }.runTaskLater(trollPlugin, 10 * 20L);

    }
}
