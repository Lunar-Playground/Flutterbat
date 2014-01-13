package com.lunarPlay.Flutterbat.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.lunarPlay.Flutterbat.Model.Player;

public class WorldRenderer {

	protected World world;
	protected SpriteBatch batch;
	protected Player player;
	protected OrthographicCamera cam;
	protected Texture playerTexture;
	
	protected float width, height;
	
	public WorldRenderer(World world) {
		this.world = world;
		batch = new SpriteBatch();
		
		width = Gdx.graphics.getWidth() / 20;
		height = Gdx.graphics.getHeight() / 20;
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();
		
		playerTexture = new Texture("data/images/player.png");
		playerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
	}
	
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		player = world.getPlayer();
		batch.begin();
		batch.draw(playerTexture, 
				player.getPosition().x - playerTexture.getWidth() / 2, player.getPosition().y - playerTexture.getHeight() / 2, 
				0, 0, 
				player.getWidth(), player.getHeight(), 
				1, 1, 
				player.getRotation(), 
				0, 0, playerTexture.getWidth(), playerTexture.getHeight(), 
				false, false);
		batch.end();
	}
	
	public void dispose() {
		batch.dispose();
		playerTexture.dispose();
	}
}
