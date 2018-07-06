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

	Animation<TextureRegion> background = new Animation<TextureRegion>(1f,atlasBack.getRegions());
	int num=0;
	public static final int RESX=16;
	public static final int RESY=16;
	int regionX;
	int regionY;
	Tile[][] region = new Tile[RESX][RESY];
	public Region(int rX, int rY) {
		regionX = rX;
		regionY = rY;
		for(int i = 0; i < RESX;i++) {
			for(int j = 0; j < RESY;j++) {
				System.out.println(num);
				if(i>=8)
					region[i][j] = new Tile(i*64+regionX,j*64+regionY,background.getKeyFrame(num+5));
				else	
				region[i][j] = new Tile(i*64+regionX,j*64+regionY,background.getKeyFrame(num));
			}
		}
	}
	
	public void render(SpriteBatch batch) {
		for(int i = 0; i < 16;i++) {
			for(int j = 0; j < 16;j++) {
				Tile t = region[i][j];
				batch.draw(t.getTile(), t.getX(), t.getY(), 64, 64);
			}
		}
	}
}
