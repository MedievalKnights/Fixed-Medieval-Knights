package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

public class Menu {
	Stage stage;
	TextButton textButton;
	TextButton genericButton;
	TextButtonStyle buttonStyle;
	BitmapFont font;
	Skin skin;
	Skin skin2;
	Skin skin3;
	TextureAtlas buttonAtlas;
	SpriteBatch batch;
	Texture background;
	Pixmap pixmap;
	Texture texture;
	TextButton startButton;
	TextButton optionButton; 
	TextButton exitButton; 
	
	MedievalKnights game; 

	Pixmap backgroundMap;

	public void create(MedievalKnights game) {
		stage = new Stage();
		font = new BitmapFont();
		skin = new Skin();
		skin2 = new Skin(); 
		skin3 = new Skin(); 
		
		this.game = game; 
		
		Gdx.input.setInputProcessor(stage);

		skin.add("default", font);
		skin2.add("default", font);
		skin3.add("default", font);

		
		skin.add("startButton", new Texture("buttons/startButton.jpg"));
		skin2.add("optionButton", new Texture("buttons/optionButton.jpg"));
		skin3.add("exitButton", new Texture("buttons/exitButton.jpg"));
		

		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		TextButton.TextButtonStyle textButtonStyle2 = new TextButton.TextButtonStyle();
		TextButton.TextButtonStyle textButtonStyle3 = new TextButton.TextButtonStyle();
		
		textButtonStyle.up = skin.newDrawable("startButton", Color.GRAY);
		textButtonStyle.down = skin.newDrawable("startButton", Color.DARK_GRAY);
		textButtonStyle.over = skin.newDrawable("startButton", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		
		textButtonStyle2.up = skin2.newDrawable("optionButton", Color.GRAY);
		textButtonStyle2.down = skin2.newDrawable("optionButton", Color.DARK_GRAY);
		textButtonStyle2.over = skin2.newDrawable("optionButton", Color.LIGHT_GRAY);
		textButtonStyle2.font = skin2.getFont("default");

		textButtonStyle3.up = skin3.newDrawable("exitButton", Color.GRAY);
		textButtonStyle3.down = skin3.newDrawable("exitButton", Color.DARK_GRAY);
		textButtonStyle3.over = skin3.newDrawable("exitButton", Color.LIGHT_GRAY);
		textButtonStyle3.font = skin3.getFont("default");

		

		skin.add("default", textButtonStyle);
		skin2.add("default", textButtonStyle2);
		skin3.add("default", textButtonStyle3);


		texture = new Texture("temp/background.jpg");
		
		startButton = new TextButton("", skin);
		optionButton = new TextButton("", skin2);
		exitButton = new TextButton("", skin3);
		
		startButton.setBounds(Gdx.graphics.getWidth()/2-128, Gdx.graphics.getHeight()*0.35f-64, 256, 128);
		optionButton.setBounds(Gdx.graphics.getWidth()*0.25f-128, Gdx.graphics.getHeight()*0.15f-64, 256, 128);
		exitButton.setBounds(Gdx.graphics.getWidth()*0.75f-128, Gdx.graphics.getHeight()*0.15f-64, 256, 128);

		//startButton.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);

		stage.addActor(startButton);
		stage.addActor(optionButton);
		stage.addActor(exitButton);

	}

	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		stage.act();
		stage.draw();
		
		getButtonInput(); 
	}

	public void dispose() {
		batch.dispose();
		background.dispose();

	}
	public void getButtonInput() {
		if(startButton.isPressed()) {
			game.startGame();

		}
		if(optionButton.isPressed()) {
			game.startOptionScreen();

		}
		if(exitButton.isPressed()) {
			System.exit(0);

		}
	}
	
	
}
