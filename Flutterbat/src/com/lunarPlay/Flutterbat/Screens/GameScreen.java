package com.lunarPlay.Flutterbat.Screens;

import com.badlogic.gdx.Screen;
import com.lunarPlay.Flutterbat.Flutterbat;
import com.lunarPlay.Flutterbat.View.World;
import com.lunarPlay.Flutterbat.View.WorldRenderer;

public class GameScreen implements Screen {

	protected Flutterbat game;
	protected World world;
	protected WorldRenderer render;
	
	public GameScreen(Flutterbat game) {
		this.game = game;
		world = new World(game);
		render = new WorldRenderer(world);
	}
	
	@Override
	public void render(float delta) {
		world.update();
		render.render();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		
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
		world.dispose();
		render.dispose();
	}

}
