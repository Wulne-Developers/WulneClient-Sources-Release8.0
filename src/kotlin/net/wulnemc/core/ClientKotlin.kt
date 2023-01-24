package net.wulnemc.core

import net.minecraft.client.Minecraft
import net.wulnemc.Api.WulnePluginDevApi.ClientBase
import net.wulnemc.wulne.Command.CommandManager
import net.wulnemc.wulne.Event.EventManager
import xu.zhixuan.wulne.Api.plugin.PluginManager

class ClientKotlin : ClientBase {
    constructor() : super("WulneClientKotlin","Release 8.0", arrayOf<String>("Frish2021", "ImNotEcy"))

    override fun onInit(mc: Minecraft?) {
        super.onInit(mc)
        EventManager.register(this)
    }

    override fun onStart(mc: Minecraft?) {
        super.onStart(mc)
    }

    override fun onStop(mc: Minecraft?) {
        super.onStop(mc)
        EventManager.unregister(this)
    }
}