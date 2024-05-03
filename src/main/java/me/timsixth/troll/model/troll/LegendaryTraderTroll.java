package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

@RequiredArgsConstructor
public class LegendaryTraderTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Villager villagerEntity = (Villager) other.getLocation().getWorld().spawnEntity(other.getLocation().add(1, 1,-0.5), EntityType.VILLAGER);
        villagerEntity.setCustomName(messages.getNameOfLegendaryTrader());
        sender.sendMessage(messages.getSpawnLegendaryTrader());
    }

    @Override
    public String getName() {
        return "LEGENDARY_TRADER";
    }
}