package com.lunarPlay.Flutterbat;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = Flutterbat.NAME + " - " + Flutterbat.COMPANY;
		cfg.useGL20 = false;
		cfg.width = Flutterbat.APP_WIDTH;
		cfg.height = Flutterbat.APP_HEIGHT;
		cfg.resizable = Flutterbat.RESIZABLE;
		
		new LwjglApplication(new Flutterbat(), cfg);
	}
}
