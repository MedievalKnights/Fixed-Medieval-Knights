package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;

public class Enemies {
    int armor;
	public float currentHP = (float) 100.0;
    public float maxHP = (float) 100.0;
    public float currentSA = (float) 100.0;
    public float maxSA = (float) 100.0;
    float speed; 
    float runSpeedMultiplier;
    float diagSpeed;
    float diagSpeedMultiplier;
    float tempSpeed; 
    float x;
    float y;
    
    EnemyHPBar hpBar= new EnemyHPBar();
    EnemyStaminaBar saBar= new EnemyStaminaBar();
    
    public Enemies(int ARMOR, int SPEED, String NAME, String DESC, Texture IMG, int X, int Y, int MaxX, int MaxY) {      
        hpBar = new EnemyHPBar();
        hpBar.setEnemy(this);
        saBar = new EnemyStaminaBar();
        saBar.setEnemy(this);
        armor = ARMOR;
        speed = SPEED;
        x = X;
        y = Y;
        diagSpeed = (float) Math.sqrt((speed * speed) / 2);
 
     
    }
}
