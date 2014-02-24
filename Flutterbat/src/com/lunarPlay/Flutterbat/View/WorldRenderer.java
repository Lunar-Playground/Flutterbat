package com.lunarPlay.Flutterbat.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.lunarPlay.Flutterbat.Flutterbat;
import com.lunarPlay.Flutterbat.Model.Player;

public class WorldRenderer {

	protected World world;
	protected SpriteBatch batch;
	protected Player player;
	protected OrthographicCamera cam;
	protected Texture playerTexture;
	protected ShapeRenderer sr;
	
	protected float width, height;
	
	public WorldRenderer(World world) {
		this.world = world;
		
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		playerTexture = new Texture("data/images/player.png");
		playerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		if(Flutterbat.DEBUG) {
			sr = new ShapeRenderer();
		}
	}
	
	public void render() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		player = world.getPlayer();
		
		cam.position.set(player.getPosition(), 0);
		cam.update();
		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		batch.draw(playerTexture, 
				player.getBounds().x, player.getBounds().y, 
				player.getBounds().width / 2, player.getBounds().height / 2, 
				player.getBounds().width, player.getBounds().height, 
				1, 1, 
				player.getRotation(), 
				0, 0, playerTexture.getWidth(), playerTexture.getHeight(), 
				false, false);
		batch.end();
		
		if(Flutterbat.DEBUG) {
			sr.setProjectionMatrix(cam.combined);
			sr.begin(ShapeType.Line);
			sr.setColor(Color.CYAN);
			sr.rect(player.getBounds().x, player.getBounds().y, player.getBounds().width, player.getBounds().height);
//			sr.setColor(Color.BLUE);
//			sr.rect(player.getDummy1().getBounds().x, player.getDummy1().getBounds().y, 
//					player.getDummy1().getBounds().width, player.getDummy1().getBounds().height);
			sr.setColor(Color.MAGENTA);
			sr.rect(player.getDummy2().getBounds().x, player.getDummy2().getBounds().y, 
					player.getDummy2().getBounds().width, player.getDummy2().getBounds().height);
			sr.end();
			sr.begin(ShapeType.Filled);
			sr.setColor(Color.BLUE);
			sr.rect(player.getDummy1().getBounds().x, player.getDummy1().getBounds().y, 
					player.getDummy1().getBounds().width, player.getDummy1().getBounds().height);
			sr.end();
		}
	}
	
	public void dispose() {
		batch.dispose();
		playerTexture.dispose();
	}
}
