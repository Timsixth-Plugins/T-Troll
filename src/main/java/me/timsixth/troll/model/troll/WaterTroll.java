package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import static me.timsixth.troll.util.ItemUtil.setMaterial;

@RequiredArgsConstructor
public class WaterTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        setMaterial(other, Material.WATER);
        sender.sendMessage(messages.getSpawnWater());
    }

    @Override
    public String getName() {
        return "WATER";
    }
}
