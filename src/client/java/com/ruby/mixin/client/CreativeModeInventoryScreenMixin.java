package com.ruby.mixin.client;

import com.ruby.LayoutManager;
import com.ruby.MyLayoutHandler;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen.ItemPickerMenu;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CreativeModeInventoryScreen.class)
public abstract class CreativeModeInventoryScreenMixin {

    @Inject(
            method = "selectTab(Lnet/minecraft/world/item/CreativeModeTab;)V",
            at = @At("TAIL")
    )
    private void ruby$onTabChanged(CreativeModeTab tab, CallbackInfo ci) {
        CreativeModeInventoryScreen screen = (CreativeModeInventoryScreen) (Object) this;

        ((CreativeScreenAccessor) screen).ruby$setScrollOffs(0.0F);

        if (screen.getMenu() instanceof ItemPickerMenu menu) {
            menu.scrollTo(0.0F);
        }
        
        if (LayoutManager.getInstance().isMyLayout()) {
            MyLayoutHandler.apply();
        }
    }
}
