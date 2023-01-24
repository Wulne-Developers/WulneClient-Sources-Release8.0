package net.wulnemc.wulne.Util

import net.minecraft.client.Minecraft
import net.minecraft.client.resources.I18n
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting

object sendChatUtil {
    private val mc = Minecraft.getMinecraft()

    fun sendMessage(msg: String) {
        var msg = msg
        if (mc.theWorld != null) {
            val translated = I18n.format(msg)
            if (translated != null) {
                msg = translated
            }
            mc.ingameGUI.getChatGUI().printChatMessage(ChatComponentText(EnumChatFormatting.YELLOW.toString() + "[" + "Wulne" + "]" + EnumChatFormatting.GRAY + msg))
        } else {
            println(msg)
        }
    }

    fun sendMessageClean(msg: String?) {
        var msg = msg
        if (mc.theWorld != null) {
            val translated = I18n.format(msg)
            if (translated != null) {
                msg = translated
            }
            mc.ingameGUI.getChatGUI().printChatMessage(ChatComponentText(msg))
        } else {
            println(msg)
        }
    }
}