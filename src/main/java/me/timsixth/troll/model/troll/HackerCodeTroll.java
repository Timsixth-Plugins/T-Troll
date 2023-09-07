package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.ConfigFile;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Collections;
import java.util.Random;

@RequiredArgsConstructor
public class HackerCodeTroll implements Troll {
    private final Messages messages;
    private final ConfigFile configFile;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        if (!(configFile.getHackerTrollBookContent().contains("{CODE}"))) {
            sender.sendMessage(ChatUtil.chatColor("&4Not configured. Messages.bookContent must include &7 \"{CODE}\""));
            return;
        }
        if (other.getInventory().firstEmpty() == -1) {
            sender.sendMessage(ChatUtil.chatColor("&7Player has a full inventory."));
            return;
        }
        Random random = new Random();
        int code = random.nextInt(995);
        userProperties.setHackerTrollCode(code + "C");

        ItemStack writtenBook = new ItemStack(Material.WRITTEN_BOOK);
        BookMeta bookMeta = (BookMeta) writtenBook.getItemMeta();
        bookMeta.setTitle(configFile.getHackerTrollBookTitle().replace("{NICK}", other.getName()));
        bookMeta.setAuthor(configFile.getHackerTrollBookAuthor());
        bookMeta.setPages(Collections.singletonList(configFile.getHackerTrollBookContent().replace("{CODE}", code + "C")));
        writtenBook.setItemMeta(bookMeta);

        sender.sendMessage(messages.getHackerTroll());
        sender.getInventory().addItem(writtenBook);
    }

    @Override
    public String getName() {
        return "HACKER_CODE";
    }
}
