package me.timsixth.troll.manager;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
public class TrollProcessManager {

    private final TrollPlugin trollPlugin;

    private final List<TrollProcess> trolls = new ArrayList<>();

    public void createNewTroll(TrollProcess troll) {
        if (trolls.contains(troll)) return;

        trolls.add(troll);
    }

    public void removeTroll(TrollProcess troll) {
        trolls.remove(troll);
    }

    public Optional<TrollProcess> getTrollBySenderUuid(UUID uuid) {
        return trolls.stream()
                .filter(troll -> troll.getSenderUuid().equals(uuid))
                .findAny();
    }

    public Optional<TrollProcess> getTrollByVictimUuid(UUID uuid) {
        return trolls.stream()
                .filter(trolledUser -> trolledUser.getVictimUuid().equals(uuid))
                .findAny();
    }

    public void fakeInventoryClear(Player player) {
        Optional<TrollProcess> trollByVictimUuid = getTrollByVictimUuid(player.getUniqueId());
        if (!trollByVictimUuid.isPresent()) {
            return;
        }

        TrolledUserProperties trolledUserProperties = trollByVictimUuid.get().getTrolledUser();

        for (int i = 0; i <= 35; ++i) {
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
                for (int j = 0; j <= 35; ++j) {
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
