package com.lunarPlay.Flutterbat;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.lunarPlay.Flutterbat.Screens.SplashScreen;

public class Flutterbat extends Game {

	public static final String NAME = "Flutter Bat";
	public static final String VERSION = "0.0.02 Pre-Alpha";
	public static final String COMPANY = "Lunar Playground";
	public static final int YEAR_RELEASE = 2014;

	public static final String LOG = "Flutterbat";
	public static final String LOG_DEBUG = "Debug";
	public static final boolean DEBUG = true;
	
	public static final int APP_WIDTH = 960;
	public static final int APP_HEIGHT = 640;
	public static final boolean USEGL20 = true;
	public static final boolean RESIZABLE = false;
	
	public static final Color FONT_COLOR_LEGAL = Color.WHITE;
	public static final Color FONT_COLOR_BUTTON = new Color(1f, 0.6f, 0.1f, 1f);
	
	@Override
	public void create() {
		setScreen(new SplashScreen(this));
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
