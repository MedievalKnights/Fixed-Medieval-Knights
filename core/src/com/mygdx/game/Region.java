package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Region {
	TextureAtlas atlasBack = new TextureAtlas(Gdx.files.internal("atlases/TileSet(1).atlas"));

	Animation<TextureRegion> background = new Animation<TextureRegion>(1f, atlasBack.getRegions());
	OpenSimplexNoise noise = new OpenSimplexNoise();
	int seed;
	double rand;
	int num = 0;
	float scale = 20;
	int[] keyFrameValues = { 1, 2, 0, 5, 4, 3 };
	float[] threshholdValues = { 0.45f, 0.3f, 0.1f, 0, -0.2f };
	public static final int RESX = 16;
	public static final int RESY = 16;
	int regionX;
	int regionY;
	Tile[][] region = new Tile[RESX][RESY];

	public void getRandom() {
		rand = Math.random() * 10000;
		seed = (int) rand;
	}

	public Region(int rX, int rY) {
		getRandom();

		regionX = rX;
		regionY = rY;
		for (int i = 0; i < RESX; i++) {
			for (int j = 0; j < RESY; j++) {
				double value = noise.eval((i + (rX / 64)) / scale + seed, (j + (rY / 64)) / scale + seed, 0.0);
				for (int k = 0; k < threshholdValues.length; k++) {
					if (value > threshholdValues[k]) {
						region[i][j] = new Tile(i * 64 + regionX, j * 64 + regionY,
								background.getKeyFrame(keyFrameValues[k]), false);
						k = threshholdValues.length;
					} else if (k + 1 == threshholdValues.length) {
						region[i][j] = new Tile(i * 64 + regionX, j * 64 + regionY,
								background.getKeyFrame(keyFrameValues[k + 1]), true);
					}
				}
			}
		}
	}

	public void render(SpriteBatch batch) {
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				Tile t = region[i][j];
				batch.draw(t.getTile(), t.getX(), t.getY(), 64, 64);
			}
		}
	}

	public boolean canBeWalkedOn(int x, int y) {
		if (region[x][y].isObstacle) {
			return false;
		} else {
			return true;
		}
	}
}