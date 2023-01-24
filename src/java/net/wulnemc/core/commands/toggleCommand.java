package net.wulnemc.core.commands;

import net.wulnemc.wulne.Command.Command;
import net.wulnemc.wulne.Module.Module;
import net.wulnemc.wulne.Util.sendChatUtil;
import net.wulnemc.wulne.WulneClient;

public class toggleCommand extends Command {
    public toggleCommand() {
        super("toggleCommand",new String[] {"toggle"});
    }

    @Override
    public void run(String[] args) {
        if(args.length == 0){
            sendChatUtil.INSTANCE.sendMessage(".Toggle <功能名称>");
            return;
        }
        String moduleName = args[0];
        Module mod = WulneClient.INSTANCE.moduleManager.getModuleByName(moduleName);
        if(mod == null){
            sendChatUtil.INSTANCE.sendMessage("Module \"" + args[0] + "\" Not Found!");
            return;
        }
        mod.setEnabled(!mod.isEnabled());
        sendChatUtil.INSTANCE.sendMessage(mod.getName() + " was toggled");
    }
}
