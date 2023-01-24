package net.wulnemc.core;

import net.minecraft.client.Minecraft;
import net.wulnemc.Api.WulnePluginDevApi.ClientBase;
import net.wulnemc.wulne.Event.EventManager;
import org.lwjgl.opengl.Display;

import java.awt.*;

public class ClientJava extends ClientBase {
    public ClientJava() {
        super("WulneClientJava","Release 8.0",new String[] {"Frish2021","ImNotEcy"});
    }

    public static ClientJava INSTANCE = new ClientJava();

    @Override
    public void onInit(Minecraft mc) {
        super.onInit(mc);
        if (SystemTray.isSupported()) {
            try {
                INSTANCE.displayTray();
            } catch (AWTException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.err.println("System tray not supported!");
        }
        System.out.println("Initing...");
        Display.setTitle("WulneClient " + getVersion() + " || Minecraft 1.8.9");
        create("WulneClient");
        create("WulneClient/Module");
        create("WulneClient/Plugins");
        create("WulneClient/ClickGui");
        EventManager.register(this);
    }

    @Override
    public void onStart(Minecraft mc) {
        super.onStart(mc);
        System.out.println("Starting...");
        Display.setTitle("WulneClient " + getVersion());
    }

    @Override
    public void onStop(Minecraft mc) {
        super.onStop(mc);
        System.out.println("Stopping...");
        EventManager.register(this);
    }

    public void displayTray() throws AWTException {
        //Obtain only one instance of the SystemTray object
        SystemTray tray = SystemTray.getSystemTray();

        //If the icon is a file
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        //Alternative (if the icon is on the classpath):
        //Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png"));

        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("System tray icon demo");
        tray.add(trayIcon);

        trayIcon.displayMessage("WulneClient Logger", "WulneClient Starting...", TrayIcon.MessageType.INFO);
    }
}
