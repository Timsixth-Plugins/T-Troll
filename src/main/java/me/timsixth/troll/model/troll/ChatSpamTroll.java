package me.timsixth.troll.model.troll;

import lombok.RequiredArgsConstructor;
import me.timsixth.troll.config.Messages;
import me.timsixth.troll.model.Troll;
import me.timsixth.troll.model.TrolledUserProperties;
import me.timsixth.troll.util.ChatUtil;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class ChatSpamTroll implements Troll {

    private final Messages messages;

    @Override
    public void executeTroll(Player other, Player sender, TrolledUserProperties userProperties) {
        for (int i = 1; i <= 30; ++i) {
            int random = (int) (Math.random() * 9.99999999E8);
            other.sendMessage(ChatUtil.chatColor("&7" + random + random + random));
        }
        sender.sendMessage(messages.getSpammed());
    }

    @Override
    public String getName() {
        return "CHAT_SPAM";
    }
}
