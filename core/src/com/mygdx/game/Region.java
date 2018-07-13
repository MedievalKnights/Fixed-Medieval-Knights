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
	int num = 0;
	int scale = 10;
	int[] keyFrameValues = { 0, 1, 2, 3, 4, 5 };
	float[] threshholdValues = { 0.6f, 0.3f, 0f, -0.3f };
	public static final int RESX = 16;
	public static final int RESY = 16;
	int regionX;
	int regionY;
	Tile[][] region = new Tile[RESX][RESY];

	public Region(int rX, int rY) {
		regionX = rX;
		regionY = rY;
		for (int i = 0; i < RESX; i++) {
			for (int j = 0; j < RESY; j++) {
				double value = noise.eval((i + (rX / 64)) / scale, (j + (rY / 64)) / scale, 0.0);
				for (int k = 0; k < threshholdValues.length; k++) {
					if (value > threshholdValues[k]) {
						region[i][j] = new Tile(i * 64 + regionX, j * 64 + regionY, background.getKeyFrame(keyFrameValues[k]));
						k = threshholdValues.length;
					}
					else if(k == threshholdValues.length-1) {
						region[i][j] = new Tile(i * 64 + regionX, j * 64 + regionY, background.getKeyFrame(keyFrameValues[k]));
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
}