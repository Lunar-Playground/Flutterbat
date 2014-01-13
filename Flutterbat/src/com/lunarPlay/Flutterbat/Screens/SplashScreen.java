package com.lunarPlay.Flutterbat.Screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
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
		splashTexture = new Texture("data/images/splashLogo.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		splash = new Sprite(splashTexture);
		splash.setX(Gdx.graphics.getWidth() / 2 - splash.getWidth() / 2);
		splash.setY(Gdx.graphics.getHeight() / 2 - splash.getHeight() / 2);
		
		splash.setColor(1f, 1f, 1f, 0f);

		batch = new SpriteBatch();
		
		Tween.registerAccessor(Sprite.class, new AlphaTween());
		
		manager = new TweenManager();
		
		TweenCallback cb = new TweenCallback() {
			@Override
			public void onEvent(int type, BaseTween<?> source) {
				tweenComplete();
			}
		};
		
		Tween.to(splash, AlphaTween.ALPHA, 2f)
				.ease(TweenEquations.easeInQuad)
				.target(1f)
				.repeatYoyo(1, 2f)
				.setCallback(cb)
				.setCallbackTriggers(TweenCallback.COMPLETE)
				.start(manager);
	}

	public void tweenComplete() {
		game.setScreen(new MainMenuScreen(game));
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
