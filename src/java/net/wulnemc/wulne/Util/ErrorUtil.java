package net.wulnemc.wulne.Util;

import net.minecraft.util.EnumChatFormatting;

public class ErrorUtil {
    public static void printException(Exception e){
        for(int i = 0; i < 5; i++) {
            sendChatUtil.INSTANCE.sendMessageClean("");
        }

        sendChatUtil.INSTANCE.sendMessage(EnumChatFormatting.DARK_RED + "An error has occurred, please report the error to the developer!");
        sendChatUtil.INSTANCE.sendMessage(EnumChatFormatting.DARK_RED + e.toString());

        Throwable[] suppressed = e.getSuppressed();
        StackTraceElement[] stackTrace = e.getStackTrace();

        for(Throwable shit : suppressed){
            sendChatUtil.INSTANCE.sendMessage(EnumChatFormatting.DARK_RED + shit.getMessage());
        }

        for (StackTraceElement stackTraceElement : stackTrace) {
            sendChatUtil.INSTANCE.sendMessage(EnumChatFormatting.DARK_RED + stackTraceElement.toString());
        }
    }
}
