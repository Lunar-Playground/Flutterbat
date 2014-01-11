package com.lunarPlay.Flutterbat.Screens;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lunarPlay.Flutterbat.Flutterbat;
import com.lunarPlay.Flutterbat.Tweens.AlphaTween;

public class SplashScreen implements Screen {

	protected Flutterbat game;
	protected SpriteBatch batch;
	protected Texture splashTexture;
	protected Sprite splash;
	protected TweenManager manager;
	protected Tween tween;
	
	public SplashScreen(Flutterbat game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		manager.update(delta);
		
		batch.begin();
		splash.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		manager = new TweenManager();
		splashTexture = new Texture("data/logo.png");
		splash = new Sprite(splashTexture);
		
		splash.setColor(1f, 1f, 1f, 0f);
		
		
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		splashTexture.dispose();
	}

}
