package net.wulnemc.Api.WulnePluginDevApi;

import net.minecraft.client.Minecraft;
import net.wulnemc.core.ClientJava;
import net.wulnemc.core.ClientKotlin;

import java.util.ArrayList;

public class ClientMainManager {
    public static ArrayList<ClientBase> clients = new ArrayList<>();

    public void load() {
        clients.add(new ClientJava());
        clients.add(new ClientKotlin());
    }

    public void onInit(Minecraft mc) {
        for (ClientBase b : clients) {
            b.onInit(mc);
        }
    }

    public void onStart(Minecraft mc) {
        for (ClientBase b : clients) {
            b.onStart(mc);
        }
    }

    public void onStop(Minecraft mc) {
        for (ClientBase b : clients) {
            b.onStop(mc);
        }
    }
}
