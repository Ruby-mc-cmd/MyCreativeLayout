package com.ruby;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;

public class VanillaLayoutHandler {

    public static void apply() {
        // VanillaLayout の処理
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen instanceof CreativeModeInventoryScreen screen) {
            System.out.println("[VanillaLayout] 適用");
            // 標準レイアウトに戻す処理を書く
        }
    }
}
