package net.wulnemc.wulne

import xu.zhixuan.wulne.Api.plugin.PluginManager

object WulneClientKotlin {
    lateinit var pluginManager: PluginManager

    fun load() {
        pluginManager = PluginManager()
    }
}