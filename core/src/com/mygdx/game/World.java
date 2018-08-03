package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	int worldLength = 2;
	int worldWidth = 2;
	int deltaX;
	int deltaY;
	Player player;
	Enemies Enemy;
	boolean hasPlayer;
	boolean hasEnemy;
	Region[][] world = new Region[worldLength * 2][worldWidth * 2];
	public World() {
		for (int i = 0; i < worldLength * 2; i++) {
			for (int j = 0; j < worldWidth * 2; j++) {
				world[i][j] = new Region(512 * (i - worldLength), 512 * (j - worldWidth));
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		if (hasPlayer) {
			if (deltaX != (int) player.x / 512 || deltaY != (int) player.y / 512) {
				deltaX = (int) player.x / 512;
				deltaY = (int) player.y / 512;
				changeChunks(deltaX, deltaY);
			}
		}
		for (int i = 0; i < worldLength * 2; i++) {
			for (int j = 0; j < worldWidth * 2; j++) {
				world[i][j].render(batch);
			}
		}

	}

	public void changeChunks(int x, int y) {
		for (int i = 0; i < worldLength * 2; i++) {
			for (int j = 0; j < worldWidth * 2; j++) {
				world[i][j] = new Region(512 * (i - worldLength + x), 512 * (j - worldWidth + y));
			}
		}
	}

	public void setPlayer(Player play) {
		player = play;
		hasPlayer = true;
	}
	public void setEnemy(Enemies enemy) {
		Enemy = enemy;
		hasEnemy = true;
	}

	public int getWorldX() {
		return worldLength * 1024;
	}

	public int getWorldY() {
		return worldWidth * 1024;
	}

	public boolean isWalkable(float x, float y) {
		boolean isWalkable = true;
		return isWalkable;
	}
}