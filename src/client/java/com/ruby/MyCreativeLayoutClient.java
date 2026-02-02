package com.ruby;

import net.fabricmc.api.ClientModInitializer;

public class MyCreativeLayoutClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		// いまは何もしない
		System.out.println("MyCreativeLayout loaded");
	}
}
