package com.ruby.mixin.client;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CreativeModeInventoryScreen.class)
public interface CreativeScreenAccessor {

    @Invoker("selectTab")
    void ruby$selectTab(CreativeModeTab tab);

    @Accessor("scrollOffs")
    void ruby$setScrollOffs(float value);
}
