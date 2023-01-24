package net.wulnemc.Api.WulnePluginDevApi;

import net.minecraft.client.Minecraft;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class ClientBase {
    public String name;
    public String version;
    public String[] author;
    public Logger getLog = LogManager.getLogger();

    public ClientBase(String name,String version,String[] author) {
        this.name = name;
        this.version = version;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public String[] getAuthor() {
        return author;
    }

    public void onInit(Minecraft mc) {}
    public void onStart(Minecraft mc) {}
    public void onStop(Minecraft mc) {}

    public void create(String name) {
        File f = new File(name);
        if (!f.exists()) {
            f.mkdirs();
        }
    }
}
