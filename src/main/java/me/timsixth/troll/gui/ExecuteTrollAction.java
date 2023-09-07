package me.timsixth.troll.gui;

import me.timsixth.troll.TrollPlugin;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.manager.TrollManager;
import me.timsixth.troll.manager.TrollProcessManager;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrollProcess;
import me.timsixth.troll.model.TrolledUserProperties;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import pl.timsixth.guilibrary.core.model.MenuItem;
import pl.timsixth.guilibrary.core.model.action.AbstractAction;
import pl.timsixth.guilibrary.core.model.action.click.ClickAction;

import java.util.Optional;

public class ExecuteTrollAction extends AbstractAction implements ClickAction {

    private final Messages messages;
    private final TrollProcessManager trollProcessManager;
    private final TrollManager trollManager;

    public ExecuteTrollAction() {
        super("EXECUTE_TROLL");
        TrollPlugin trollPlugin = TrollPlugin.getPlugin(TrollPlugin.class);
        messages = trollPlugin.getMessages();
        trollProcessManager = trollPlugin.getTrollProcessManager();
        trollManager = trollPlugin.getTrollManager();
    }

    @Override
    public void handleClickEvent(InventoryClickEvent event, MenuItem menuItem) {
        String trollName = getArgs().get(0);
        Player player = (Player) event.getWhoClicked();

        Optional<TrollProcess> trollBySenderUuid = trollProcessManager.getTrollBySenderUuid(player.getUniqueId());
        Optional<Troll> trollOptional = trollManager.getTrollByName(trollName);

        if (!trollOptional.isPresent()) {
            event.setCancelled(true);
            return;
        }

        if (!trollBySenderUuid.isPresent()) {
            event.setCancelled(true);
            return;
        }

        TrolledUserProperties trolledUser = trollBySenderUuid.get().getTrolledUser();
        Player other = Bukkit.getPlayer(trollBySenderUuid.get().getVictimUuid());
        Troll troll = trollOptional.get();

        if (isPlayerOnline(other, player, event)) {
            troll.executeTroll(other, player, trolledUser);
            event.setCancelled(true);
        }
    }

    private boolean isPlayerOnline(Player other, Player sender, InventoryClickEvent event) {
        if (other == null) {
            event.setCancelled(true);
            sender.closeInventory();

            sender.sendMessage(messages.getOfflinePlayer());
            return false;
        }
        return true;
    }
}
