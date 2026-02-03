package com.ruby;

import com.ruby.mixin.client.CreativeScreenAccessor;
import net.fabricmc.fabric.api.client.itemgroup.v1.FabricCreativeInventoryScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;

public class VanillaLayoutHandler {

    public static void apply() {
        Minecraft mc = Minecraft.getInstance();

        mc.execute(() -> {
            if (!(mc.screen instanceof CreativeModeInventoryScreen screen)) return;
            if (!(screen instanceof FabricCreativeInventoryScreen fabric)) return;
            if (mc.player == null || mc.level == null) return;

            CreativeModeTab tab = fabric.getSelectedItemGroup();
            if (tab == null) {
                tab = CreativeModeTabs.getDefaultTab();
            }

            ResourceKey<CreativeModeTab> key =
                    BuiltInRegistries.CREATIVE_MODE_TAB
                            .getResourceKey(tab)
                            .orElse(null);

            if (key == CreativeModeTabs.OP_BLOCKS) {
                tab = CreativeModeTabs.getDefaultTab();
            }

            ((CreativeScreenAccessor) screen).ruby$selectTab(tab);
            CreativeModeInventoryScreen.ItemPickerMenu menu =
                    (CreativeModeInventoryScreen.ItemPickerMenu) screen.getMenu();
            menu.scrollTo(0.0F);
            ((CreativeScreenAccessor) screen).ruby$setScrollOffs(0.0F);
            MyLayoutState.setUsingMyLayout(false);

            System.out.println("[VanillaLayout] Restored vanilla layout (tab click emulated)");
        });
    }
}
