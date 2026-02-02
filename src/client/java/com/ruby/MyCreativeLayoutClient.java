package com.ruby;

import net.fabricmc.api.ClientModInitializer;

public class MyCreativeLayoutClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		System.out.println("MyCreativeLayout loaded");
	}
}
