package com.ruby;

import net.minecraft.network.chat.Component;

public class LayoutManager {

    private static final LayoutManager INSTANCE = new LayoutManager();
    private boolean isMyLayout;
    private final LayoutConfig config = new LayoutConfig();

    private LayoutManager() {
        this.isMyLayout = config.load();
    }

    public static LayoutManager getInstance() { return INSTANCE; }

    public void toggleLayout() {
        isMyLayout = !isMyLayout;
        config.save(isMyLayout);
        applyCurrentLayout();
    }

    public void applyCurrentLayout() {
        if (isMyLayout) {
            MyLayoutHandler.apply();
        } else {
            VanillaLayoutHandler.apply();
        }
    }

    public Component getButtonText() {
        return isMyLayout ? Component.literal("My Layout") : Component.literal("Vanilla Layout");
    }

    public boolean isMyLayout() {
        return isMyLayout;
    }
}
