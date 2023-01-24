package net.wulnemc.wulne.Command;

import net.wulnemc.core.commands.BindCommand;
import net.wulnemc.core.commands.HelpCommand;
import net.wulnemc.core.commands.toggleCommand;
import net.wulnemc.wulne.WulneClientKotlin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandManager {
    public static List<Command> commands = new ArrayList<>();

    public void load() {
        addCommand(new HelpCommand());
        addCommand(new BindCommand());
        addCommand(new toggleCommand());

        WulneClientKotlin.pluginManager.onCommandManagerLoad(this);
    }

    public void addCommand(Command cmd) {
        commands.add(cmd);
    }

    public static Command getCommandByName(String name) {
        for (Command cmd : commands) {
            if (cmd == null) {
                continue;
            }
            String[] names = cmd.getNames();
            for (String myName : names) {
                if (myName.equalsIgnoreCase(name)) {
                    return cmd;
                }
            }
        }
        return null;
    }
}
