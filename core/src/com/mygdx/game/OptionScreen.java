package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class OptionScreen {
	
	World world;
	MedievalKnights game;
	Player player;
	Enemies Daddy;
	KeyInput inputs;
	TextureRegion background;

	public void create(MedievalKnights game) {
		
		world = new World();
		this.game = game;
		inputs = new KeyInput();
	
		// background = new Texture("atlases/Grass_Complete_RPG.png");
		player = new Player(5, 2, "John", "A Guy", new Texture("sprites/New_Piskel.png"), 150, 150, 999999999,
				999999999);
		inputs.setPlayer(player);
		world.setPlayer(player);
		
		Daddy = new Enemies(0, 1, "Jack", "A typical coder", new Texture ("sprites/slime.png"), 150, 150, 999999999, 999999999);
		
		Gdx.input.setInputProcessor(inputs);

		game.gameState++;
	}

	public void render(SpriteBatch batch) {
		SoundHandler.gameScreenMusic();
		player.move();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		world.render(batch);
		player.render(batch);
		//batch.draw(player.getImg(), player.getX() - 32, player.getY() - 32, 128, 128);

		batch.setProjectionMatrix(player.camera.combined);
		batch.end();
	}

	public void dispose() {
		game.getBatch().dispose();
	}
}