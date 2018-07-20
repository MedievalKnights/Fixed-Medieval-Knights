package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class EnemyHPBar {
	Enemies enemy;
	ShapeRenderer sr = new ShapeRenderer();
	int width = 200;
	final int height = 20;

	public void setEnemy(Enemies enemy) {
		enemy=enemy;
	}
	
	public void draw(SpriteBatch batch) {
		batch.end();
		sr.begin(ShapeType.Filled);
		// 149, 153, 160
		sr.setColor(77f, 77f, 77f, 1f);
		sr.rect(38, 790, 225, 65);

		// System.out.println("Hallo");
		int x = Gdx.graphics.getWidth() / 2;
		int y = Gdx.graphics.getHeight() / 2;
		float HPP = enemy.maxHP / enemy.currentHP;
		sr.setColor(1 - HPP, 1 * HPP, 0f, 0.8f);
		// sr.rect(15-x, y-80, width, height);
		sr.rect(50, 825, width, height);
		sr.end();
		batch.begin();
	}
}
