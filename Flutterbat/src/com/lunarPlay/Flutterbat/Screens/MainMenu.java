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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.lunarPlay.Flutterbat.Flutterbat;

public class MainMenu implements Screen {

	protected Flutterbat game;
	protected SpriteBatch batch;
	protected TextureAtlas atlas;
	protected Stage stage;
	protected Skin skin;

	/**
	 * Button Font
	 */
	protected BitmapFont bFont;
	/**
	 * Label Font
	 */
	protected BitmapFont lFont;
	
	protected TextButton bStart;
	protected TextButton bContinue;
	protected TextButton bLoad;
	protected TextButton bOptions;
	protected TextButton bQuit;
	
	protected Label lLegal;
	protected Label lVersion;
	
	public MainMenu(Flutterbat game) {
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
		
		// Style //
		LabelStyle lStyle = new LabelStyle();
		lStyle.font = lFont;
		lStyle.fontColor = Flutterbat.FONT_COLOR_LEGAL;
		
		bFont.scale(1);
		TextButtonStyle bStyle = new TextButtonStyle();
		bStyle.up = skin.getDrawable("ButtonNormal");
		bStyle.down = skin.getDrawable("ButtonPressed");
		bStyle.over = skin.getDrawable("ButtonHover");
		bStyle.font = bFont;
		bStyle.fontColor = Flutterbat.FONT_COLOR_BUTTON;
		// Style //

		// Label //
		if(lLegal == null) { lLegal = new Label("Programmed by NorthernSprint", lStyle); }
		lLegal.setX(5);
		lLegal.setY(5);
		
		if(lVersion == null) { lVersion = new Label(Flutterbat.VERSION, lStyle); }
		lVersion.setX(-5 + Gdx.graphics.getWidth() - lVersion.getWidth());
		lVersion.setY(5);
		// Label //
		
		// Button //
		if(bStart == null) { bStart = new TextButton("Start", bStyle); }
		bStart.setHeight(Gdx.graphics.getHeight() / 12);
		bStart.setWidth(Gdx.graphics.getWidth() * 2 / 3);
		bStart.setX(Gdx.graphics.getWidth() / 6);
		bStart.setY(Gdx.graphics.getHeight() / 2
				- bStart.getHeight() / 2);
		
		if(bContinue == null) { bContinue = new TextButton("Continue", bStyle); }
		bContinue.setHeight(Gdx.graphics.getHeight() / 12);
		bContinue.setWidth(Gdx.graphics.getWidth() * 2 / 3);
		bContinue.setX(Gdx.graphics.getWidth() / 6);
		bContinue.setY(Gdx.graphics.getHeight() / 2 
				- bContinue.getHeight() / 2
				- Gdx.graphics.getHeight() * 1 / 12);
		
		if(bLoad == null) { bLoad = new TextButton("Load", bStyle); }
		bLoad.setHeight(Gdx.graphics.getHeight() / 12);
		bLoad.setWidth(Gdx.graphics.getWidth() * 2 / 3);
		bLoad.setX(Gdx.graphics.getWidth() / 6);
		bLoad.setY(Gdx.graphics.getHeight() / 2 
				- bLoad.getHeight() / 2
				- Gdx.graphics.getHeight() * 2 / 12);
		
		if(bOptions == null) { bOptions = new TextButton("Options", bStyle); }
		bOptions.setHeight(Gdx.graphics.getHeight() / 12);
		bOptions.setWidth(Gdx.graphics.getWidth() * 2 / 3);
		bOptions.setX(Gdx.graphics.getWidth() / 6);
		bOptions.setY(Gdx.graphics.getHeight() / 2 
				- bOptions.getHeight() / 2
				- Gdx.graphics.getHeight() * 3 / 12);
		
		if(bQuit == null) { bQuit = new TextButton("Quit", bStyle); }
		bQuit.setHeight(Gdx.graphics.getHeight() / 12);
		bQuit.setWidth(Gdx.graphics.getWidth() * 2 / 3);
		bQuit.setX(Gdx.graphics.getWidth() / 6);
		bQuit.setY(Gdx.graphics.getHeight() / 2 
				- bQuit.getHeight() / 2
				- Gdx.graphics.getHeight() * 4 / 12);
		// Button //

		// Listener //
		bStart.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { return true; }
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				buttonStart();
			}
		});
		
		bContinue.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { return true; }
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				buttonContinue();
			}
		});
		
		bLoad.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { return true; }
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				buttonLoad();
			}
		});
		
		bOptions.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { return true; }
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				buttonOptions();
			}
		});
		
		bQuit.addListener(new InputListener() {
			public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) { return true; }
			public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
				buttonQuit();
			}
		});
		// Listener //
		
		stage.addActor(bStart);
		stage.addActor(bContinue);
		stage.addActor(bLoad);
		stage.addActor(bOptions);
		stage.addActor(bQuit);
		
		stage.addActor(lLegal);
		stage.addActor(lVersion);
	}

	protected void buttonQuit() {
		Gdx.app.exit();
	}

	protected void buttonOptions() {
		game.setScreen(new OptionsScreen(game));
	}

	protected void buttonLoad() {
		game.setScreen(new SaveSelectScreen(game));
	}

	protected void buttonContinue() {
		
	}

	protected void buttonStart() {
		
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		atlas = new TextureAtlas("data/images/buttons.pack");
		skin = new Skin();
		skin.addRegions(atlas);
		bFont = new BitmapFont(Gdx.files.internal("data/fonts/Fixedsys24.fnt"), false);
		lFont = new BitmapFont(Gdx.files.internal("data/fonts/Fixedsys8.fnt"), false);
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
		bStart.clear();
		bContinue.clear();
		bLoad.clear();
		bOptions.clear();
		bQuit.clear();
		
		batch.dispose();
		atlas.dispose();
		skin.dispose();
		bFont.dispose();
		lFont.dispose();
		stage.dispose();
	}

}
