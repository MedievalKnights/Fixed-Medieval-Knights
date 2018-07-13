package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	int worldLength = 5;
	int worldWidth = 5;
	Region[][] world = new Region[worldLength][worldWidth];

	public World() {
		for (int i = 0; i < worldLength; i++) {
			for (int j = 0; j < worldWidth; j++) {
				world[i][j] = new Region(512 * i, 512 * j);
			}
		}

	}

	public void render(SpriteBatch batch) {
		for (int i = 0; i < worldLength; i++) {
			for (int j = 0; j < worldWidth; j++) {
				world[i][j].render(batch);
			}
		}
	}

	public int getWorldX() {
		return worldLength * 1024;
	}

	public int getWorldY() {
		return worldWidth * 1024;
	}
}