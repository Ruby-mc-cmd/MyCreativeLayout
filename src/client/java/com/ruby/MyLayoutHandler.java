package com.ruby;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class MyLayoutHandler {

    public static void apply() {
        Minecraft mc = Minecraft.getInstance();

        mc.execute(() -> {
            if (!(mc.screen instanceof CreativeModeInventoryScreen screen)) {
                return;
            }

            CreativeModeInventoryScreen.ItemPickerMenu menu =
                    (CreativeModeInventoryScreen.ItemPickerMenu) screen.getMenu();

            menu.items.clear();

            for (int i = 0; i < 504; i++) {
                ItemStack stack = new ItemStack(Items.DIAMOND);

                stack.set(
                        DataComponents.CUSTOM_NAME,
                        Component.literal("ダイヤ #" + (i + 1))
                );

                menu.items.add(stack);
            }

            menu.scrollTo(0.0F);
            mc.execute(() -> menu.scrollTo(0.0F));

            System.out.println("[MyLayout] Creative items replaced & scrollbar fully reset");
        });
    }
}
