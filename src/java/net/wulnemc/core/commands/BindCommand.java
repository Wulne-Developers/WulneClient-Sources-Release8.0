package net.wulnemc.core.commands;

import net.wulnemc.wulne.Command.Command;
import net.wulnemc.wulne.Module.Module;
import net.wulnemc.wulne.Util.sendChatUtil;
import net.wulnemc.wulne.WulneClient;
import org.lwjgl.input.Keyboard;

public class BindCommand extends Command {
    public BindCommand() {
        super("BindCommand",new String[] {"bind"});
    }

    @Override
    public void run(String[] args) {
        if (args.length < 2) {
            sendChatUtil.INSTANCE.sendMessage(".bind <Module> <Key>");
            return;
        }

        Module mod = WulneClient.INSTANCE.moduleManager.getModuleByName(args[0]);
        if (mod == null) {
            sendChatUtil.INSTANCE.sendMessage("Module \"" + args[0] + "\" Not Found!");
            return;
        }

        int keyNum;
        mod.setKey(keyNum = Keyboard.getKeyIndex(args[1].toUpperCase()));
        args[1] = keyNum == 0 ? "None" : args[1].toUpperCase();
        sendChatUtil.INSTANCE.sendMessage("Module \"" + mod.getName() + "\" Was Bound to " + args[1]);
    }
}
