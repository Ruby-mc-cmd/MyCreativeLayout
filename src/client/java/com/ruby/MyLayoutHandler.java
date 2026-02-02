package com.ruby;

import net.minecraft.client.Minecraft;

public class MyLayoutHandler {

    public static void apply() {
        Minecraft mc = Minecraft.getInstance();

        mc.execute(() -> {
            System.out.println("[MyLayout]");
        });
    }
}