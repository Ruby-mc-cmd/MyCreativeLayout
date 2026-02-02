package com.ruby;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;

public class MyLayoutHandler {

    public static void apply() {
        // MyLayout のカスタム処理をここに記述
        // タブ順の変更、特定アイテム優先表示

        Minecraft mc = Minecraft.getInstance();
        if (mc.screen instanceof CreativeModeInventoryScreen screen) {
            // 実際のタブやアイテムを操作する処理を書く
            System.out.println("[MyLayout] 適用");
        }
    }
}
