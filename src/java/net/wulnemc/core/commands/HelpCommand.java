package net.wulnemc.core.commands;

import net.wulnemc.wulne.Command.Command;
import net.wulnemc.wulne.Util.sendChatUtil;

public class HelpCommand extends Command {
    public HelpCommand() {
        super("HelpCommand",new String[] {"help"});
    }

    @Override
    public void run(String[] args) {
        sendChatUtil.INSTANCE.sendMessage("---------------Help---------------");
        sendChatUtil.INSTANCE.sendMessage(".bind <Module> <Key>绑定按键");
        sendChatUtil.INSTANCE.sendMessage(".toggle <Module> 启用模块");
        sendChatUtil.INSTANCE.sendMessage(".help 客户端帮助菜单");
    }
}
