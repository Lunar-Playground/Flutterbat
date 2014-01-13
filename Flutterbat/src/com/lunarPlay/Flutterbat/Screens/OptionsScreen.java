package com.lunarPlay.Flutterbat.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.lunarPlay.Flutterbat.Flutterbat;

public class OptionsScreen implements Screen {
	
	protected Flutterbat game;
	protected SpriteBatch batch;
	protected TextureAtlas atlas;
	protected Stage stage;
	protected Skin skin;

	protected BitmapFont bFont;
	
	protected TextButton bBack;
	
	/**
	 * TODO: Add Options Script
	 * @param game
	 */
	public OptionsScreen(Flutterbat game) {
		this.game = game;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		batch.begin();
		stage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		if(stage == null) {
			stage = new Stage(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		}
		stage.clear();
		
		Gdx.input.setInputProcessor(stage);
		
		bFont.scale(1);
		TextButtonStyle bStyle = new TextButtonStyle();
		bStyle.up = skin.getDrawable("ButtonNormal");
		bStyle.down = skin.getDrawable("ButtonPressed");
		bStyle.over = skin.getDrawable("ButtonHover");
		bStyle.font = bFont;
		bStyle.fontColor = Flutterbat.FONT_COLOR_BUTTON;
		
		if(bBack == null) { bBack = new TextButton("Back", bStyle); }
		bBack.setHeight(Gdx.graphics.getHeight() / 12);
		bBack.setWidth(Gdx.graphics.getWidth() * 2 / 3);
		bBack.setX(Gdx.graphics.getWidth() / 6);
		bBack.setY(Gdx.graphics.getHeight() / 2 
				- bBack.getHeight() / 2
				- Gdx.graphics.getHeight() * 5 / 12);
		// Button //

		// Listener //
		bBack.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { return true; }
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				buttonBack();
			}
		});
		
		stage.addActor(bBack);
	}

	protected void buttonBack() {
		game.setScreen(new MainMenuScreen(game));
		this.clear();
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("data/images/buttons.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		bFont = new BitmapFont(Gdx.files.internal("data/fonts/Fixedsys24.fnt"), false);
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

	public void clear() {
		bBack.clear();
	}

	@Override
	public void dispose() {
		batch.dispose();
		atlas.dispose();
		skin.dispose();
		bFont.dispose();
		stage.dispose();
	}
}
