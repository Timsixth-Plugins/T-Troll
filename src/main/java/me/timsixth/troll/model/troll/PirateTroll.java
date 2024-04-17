package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ItemUtil;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@RequiredArgsConstructor
public class PirateTroll implements Troll {

    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        Location location = findOceanBiome(other.getLocation());

        double distance = other.getLocation().distance(location);

        if (distance > 200) {
            if (configFile.isVictimMessage()) other.sendMessage(messages.getCanNotBePirate());
            return;
        }

        ItemUtil.giveItems(other, new ItemStack(Material.JUNGLE_BOAT));
        other.teleport(location);

        if (configFile.isVictimMessage()) other.sendMessage(messages.getYouArePirate());
        sender.sendMessage(messages.getPlayerIsPirateNow().replace("{NICK}", other.getName()));
    }

    @Override
    public String getName() {
        return "PIRATE";
    }

    private Location findOceanBiome(Location location) {
        World world = location.getWorld();
        int locX = location.getBlockX();
        int locZ = location.getBlockZ();

        Location biomeLocation = new Location(world, 0, 70, 0);
        int radius = 100;

        for (int x = locX - radius; x <= locX + radius; x += radius) {
            for (int z = locZ - radius; z <= locZ + radius; z += radius) {
                Biome biome = world.getBiome(x, z);

                if (!biome.name().contains("OCEAN")) continue;

                biomeLocation = new Location(world, x + 8, 70, z + 8);
            }
        }

        return biomeLocation;
    }
}
