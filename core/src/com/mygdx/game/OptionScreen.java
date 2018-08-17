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

	TextButton backButton;
	Skin skinButton1;
	TextButtonStyle textButtonStyle;
	BitmapFont font;

	TextureAtlas buttonAtlas;

	MedievalKnights game;

	public void create(MedievalKnights game) {
		stage = new Stage();
		skin = new Skin();
		this.game = game;
		Pixmap pixmap = new Pixmap((int) Gdx.graphics.getWidth() / 4, (int) Gdx.graphics.getHeight() / 10,
				Pixmap.Format.RGB888);
		pixmap.setColor(Color.GRAY);
		pixmap.fill();
		texture = new Texture(pixmap);
		skin.add("background", texture);

		Gdx.input.setInputProcessor(stage);

		game.gameState += 2;

		//

		skinButton1 = new Skin();
		font = new BitmapFont();
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();

		skinButton1.add("default", font);
		skinButton1.add("backButton", new Texture("buttons/startButton.jpg"));

		textButtonStyle.up = skinButton1.newDrawable("backButton", Color.GRAY);
		textButtonStyle.down = skinButton1.newDrawable("backButton", Color.DARK_GRAY);
		textButtonStyle.over = skinButton1.newDrawable("backButton", Color.LIGHT_GRAY);
		textButtonStyle.font = skinButton1.getFont("default");

		skinButton1.add("default", textButtonStyle);

		backButton = new TextButton("", skinButton1);

		backButton.setBounds(Gdx.graphics.getWidth() / 12, Gdx.graphics.getHeight() / 12, 256, 128);

		stage.addActor(backButton);

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
		if (backButton.isPressed()) {
			System.out.println("backButton");
			dispose(); 
			game.startMenu();
		}
	}

}
