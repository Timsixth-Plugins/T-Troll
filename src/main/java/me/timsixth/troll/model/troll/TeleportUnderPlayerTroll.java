package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
@RequiredArgsConstructor
public class TeleportUnderPlayerTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;
    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location location = other.getLocation().subtract(0.0, 20.0, 0.0);
        location.getBlock().setType(Material.AIR);
        location.add(0.0, 1.0, 0.0).getBlock().setType(Material.AIR);
        other.teleport(location);

        other.getInventory().addItem(new ItemStack(Material.WOODEN_PICKAXE));

        sender.sendMessage(messages.getWoodenPick());
        if (configFile.isVictimMessage()) other.sendMessage(messages.getWoodenPickOther());
    }

    @Override
    public String getName() {
        return "TELEPORT_UNDER_PLAYER";
    }
}
