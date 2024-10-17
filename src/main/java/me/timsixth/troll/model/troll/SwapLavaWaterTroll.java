package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class SwapLavaWaterTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        boolean swapLavaWater = !userProperties.isSwapLavaWater();
        userProperties.setSwapLavaWater(swapLavaWater);

        String message = swapLavaWater ? messages.getSwapWaterToLava() : messages.getSwapWaterFromLava();

        sender.sendMessage(message);
    }

    @Override
    public String getName() {
        return "SWAP_LAVA_WATER";
    }
}
