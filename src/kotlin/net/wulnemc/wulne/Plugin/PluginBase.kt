package xu.zhixuan.wulne.Api.plugin

import net.wulnemc.wulne.Command.CommandManager
import net.wulnemc.wulne.Module.ModuleManager

interface PluginBase {
    fun getModuleManager(modManager: ModuleManager)
    fun getCommandManager(cmdManager: CommandManager)
}