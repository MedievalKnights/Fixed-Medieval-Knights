package com.mygdx.game;

import java.util.HashMap;
import java.util.Random;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class World {
	int worldLength = 2;
	int worldWidth = 2;
	int deltaX;
	int deltaY;
	int seed;
	double rand;
	int num = 0;
	int max = 5;
	int min = 0;
	Player player;
	boolean hasPlayer;
	Region[][] world = new Region[worldLength * 2][worldWidth * 2];
	public World() {
		getRandom();
		for (int i = 0; i < worldLength * 2; i++) {
			for (int j = 0; j < worldWidth * 2; j++) {
				world[i][j] = new Region(512 * (i - worldLength), 512 * (j - worldWidth),seed);
			}
		}
	}
	public void getRandom() {
			HashMap<Integer, Integer> seeds;
			seeds = new HashMap();
			seeds.put(0, -20000);
			seeds.put(1, -10000);
			seeds.put(2, 0);
			seeds.put(3, 10000);
			seeds.put(4, 20000);
			///////////////////////////////////////////////
			Random random = new Random();
			num= random.nextInt(4);
			System.out.println(num);
			seed = seeds.get(num);
			System.out.println(seed);
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
				world[i][j] = new Region(512 * (i - worldLength + x), 512 * (j - worldWidth + y),seed);
			}
		}
	}

	public void setPlayer(Player play) {
		player = play;
		hasPlayer = true;
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