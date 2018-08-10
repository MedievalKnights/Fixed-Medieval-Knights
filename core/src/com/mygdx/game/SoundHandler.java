package com.mygdx.game; 

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundHandler {
	private static Music mainMenuMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/mainMenuMusic.mp3"));
	private static Music gameScreenMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/Wack_ass_song.mp3"));
//	private static Music piano = Gdx.audio.newMusic(Gdx.files.internal("sounds/piano.mp3"));
	//private static Music bossMusic = Gdx.audio.newMusic(Gdx.files.internal("sounds/BossBattle.wav"));
	
	//private static Sound slash = Gdx.audio.newSound(Gdx.files.internal("sounds/slash.wav"));
	private static long slashID = 0;
	
	public static void init() {
		mainMenuMusic.setLooping(true);
		mainMenuMusic.play();
	}
	
	public static void stopMainMenuMusic() { 
		mainMenuMusic.stop();
	}
public static void gameScreenMusic() {
	gameScreenMusic.setLooping(true);
	gameScreenMusic.play();
	}
	/*
	public static float getRandomPitch() {
		float pitch = new Random().nextFloat()*1.5f+0.5f;
		return pitch;
	}
	*/
}