package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Enemies {
    int armor;
    Texture image;
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
    
	float elapsedTime = 0;
	String anim = "walkingSouth";
    TextureAtlas walkNorthAtlas;
    TextureAtlas walkSouthAtlas;
    Animation<TextureRegion> walkNorthAnimation;
    Animation<TextureRegion> walkSouthAnimation;
    
    public Enemies(int ARMOR, int SPEED, String NAME, String DESC, Texture IMG, int X, int Y, int MaxX, int MaxY) {      
        hpBar = new EnemyHPBar();
        hpBar.setEnemy(this);
        saBar = new EnemyStaminaBar();
        saBar.setEnemy(this);
        armor = ARMOR;
        speed = SPEED;
        image=IMG;
        x = X;
        y = Y;
        diagSpeed = (float) Math.sqrt((speed * speed) / 2);
 
     
    }
	public TextureRegion getAnimation() {
        elapsedTime += Gdx.graphics.getDeltaTime();
        TextureRegion ret;
        if (anim.equals("walkingNorth")) {
            ret = walkNorthAnimation.getKeyFrame(elapsedTime, true);
        }
        else if (anim.equals("walkingSouth")) {
            ret = walkSouthAnimation.getKeyFrame(elapsedTime, true);
        }
        else {
            ret = walkNorthAnimation.getKeyFrame(elapsedTime, true);
        }
        return ret;
       
    }
	public Texture getImg() {
        return image;
    }
    
    public void render(SpriteBatch batch) {
        hpBar.draw(batch);
        //saBar.draw(batch);
        
        batch.draw(getImg(), x, y , 128, 128);
        //batch.draw(getAnimation(), x, y , 128, 128);
        
    }
}
