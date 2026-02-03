package com.ruby;

public class MyLayoutState {

    private static boolean usingMyLayout = false;

    public static boolean isUsingMyLayout() {
        return usingMyLayout;
    }

    public static void setUsingMyLayout(boolean value) {
        usingMyLayout = value;
    }
}
