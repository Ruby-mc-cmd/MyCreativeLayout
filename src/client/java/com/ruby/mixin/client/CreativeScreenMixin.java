package com.ruby.mixin.client;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.ruby.LayoutManager;

@Mixin(CreativeModeInventoryScreen.class)
public abstract class CreativeScreenMixin extends Screen {

	protected CreativeScreenMixin(Component title) { super(title); }

	@Inject(method = "init", at = @At("TAIL"))
	private void myCreativeLayout$onInit(CallbackInfo ci) {

		Button toggleButton = Button.builder(
				LayoutManager.getInstance().getButtonText(),
				button -> {
					LayoutManager.getInstance().toggleLayout();
					button.setMessage(LayoutManager.getInstance().getButtonText());
				}
		).bounds(this.width / 2 - 40, this.height- 24, 80, 16).build();

		this.addRenderableWidget(toggleButton);

		LayoutManager.getInstance().applyCurrentLayout();
	}
}
