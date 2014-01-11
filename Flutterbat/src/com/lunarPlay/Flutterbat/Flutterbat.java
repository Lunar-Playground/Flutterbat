package com.lunarPlay.Flutterbat;

import com.badlogic.gdx.Game;
import com.lunarPlay.Flutterbat.Screens.SplashScreen;

public class Flutterbat extends Game {

	public static final String NAME = "Flutter Bat";
	public static final String VERSION = "0.0.0.01 Pre-Alpha";
	public static final String COMPANY = "Lunar Playground";
	public static final int YEAR_RELEASE = 2014;

	public static final int APP_WIDTH = 960;
	public static final int APP_HEIGHT = 640;
	public static final boolean RESIZABLE = false;
	
	@Override
	public void create() {		
		this.setScreen(new SplashScreen(this));
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
}
