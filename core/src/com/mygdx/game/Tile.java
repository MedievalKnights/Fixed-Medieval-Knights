package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Tile {
	int x;
	int y;
	TextureRegion tile;
	boolean isObstacle;
	boolean isRendered;
	double speedModifier;

	public Tile(int X, int Y, TextureRegion background, boolean isOb) {
		x = X;
		y = Y;
		tile = background;
		isObstacle = isOb;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public TextureRegion getTile() {
		return tile;
	}

	public void setTile(TextureRegion tile) {
		this.tile = tile;
	}

	public boolean isObstacle() {
		return isObstacle;
	}

	public void setObstacle(boolean isObstacle) {
		this.isObstacle = isObstacle;
	}

	public boolean isRendered() {
		return isRendered;
	}

	public void setRendered(boolean isRendered) {
		this.isRendered = isRendered;
	}

	public double getSpeedModifier() {
		return speedModifier;
	}

	public void setSpeedModifier(double speedModifier) {
		this.speedModifier = speedModifier;
	}
	
}
