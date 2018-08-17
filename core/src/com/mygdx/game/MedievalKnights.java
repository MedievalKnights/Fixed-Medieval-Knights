package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GLTexture;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Menu;

public class MedievalKnights extends ApplicationAdapter {

	public SpriteBatch batch;

	int gameState = 0;

	Menu menuScreen = new Menu();
	GameScreen gameScreen = new GameScreen();
	OptionScreen optionScreen = new OptionScreen();

	@Override
	public void create() {
		batch = new SpriteBatch();
		if (gameState == 0)
			menuScreen.create(this);
		SoundHandler.init();

	}

	@Override
	public void render() {
		if (gameState == 0)
			menuScreen.render(batch);
		if (gameState == 1)
			gameScreen.render(batch);
		if (gameState == 2) {
			optionScreen.render(batch);
		}
	}

	@Override
	public void dispose() {
		if (gameState == 0)
			// menuScreen.dispose();
			if (gameState == 1)
				gameScreen.dispose();
	}

	public void startMenu() {
		menuScreen = new Menu(); 
		menuScreen.create(this);
	}
	
	public void startGame() {
		gameScreen.create(this);
		SoundHandler.stopMainMenuMusic();
	}

	public void startOptionScreen() {
		optionScreen.create(this);
		SoundHandler.stopMainMenuMusic();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
}
