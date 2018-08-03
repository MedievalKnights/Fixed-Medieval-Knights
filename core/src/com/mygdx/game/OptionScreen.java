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

public class OptionScreen {
	Stage stage;
	SpriteBatch batch;
	Texture background;
	Texture texture;
	Skin skin; 

	MedievalKnights game;


	public void create(MedievalKnights game) {
		stage = new Stage();
		skin = new Skin();
		this.game = game;
		Pixmap pixmap = new Pixmap((int)Gdx.graphics.getWidth()/4,(int)Gdx.graphics.getHeight()/10, Pixmap.Format.RGB888);
		pixmap.setColor(Color.GRAY);
		pixmap.fill();
		texture = new Texture(pixmap); 
		skin.add("background", texture);
		
		Gdx.input.setInputProcessor(stage);
		
		
		game.gameState+=2;


	}

	public void render(SpriteBatch batch) {
		batch.begin();
		batch.draw(texture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();
		
		stage.act();
		stage.draw();
		
	}

	public void dispose() {
		batch.dispose();
		background.dispose();

	}

	public void getButtonInput() {

	}

}
