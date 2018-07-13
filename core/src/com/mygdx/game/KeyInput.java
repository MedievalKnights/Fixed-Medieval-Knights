package com.mygdx.game;

import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;

public class KeyInput implements InputProcessor {
	Player player;

	// public void setGS(GameScreen ga) {
	// gs = ga;
	// }

	public void setPlay(Player ga) {
		player = ga;
	}

	public boolean keyDown(int keycode) {
		System.out.println(keycode);
		switch (keycode) {
		case Keys.W:
			player.setmUp(true);
			player.setAnim("walkingNorth");

			break;
		case Keys.A:
			player.setmLeft(true);
			break;
		case Keys.S:
			player.setmDown(true);
			player.setAnim("walkingSouth");
			break;
		case Keys.D:
			player.setmRight(true);
			break;
		case Keys.UP:
			player.setmUp(true);
			break;
		case Keys.LEFT:
			player.setmLeft(true);
			break;
		case Keys.RIGHT:
			player.setmRight(true);
			break;
		case Keys.DOWN:
			player.setmDown(true);
			break;
		case Keys.SHIFT_LEFT:
			if (player.currentSA >= 4) {
				player.setRunning(true);
			}
			else {
				player.setRunning(false);
			}
			break;
		case Keys.SHIFT_RIGHT:
			if (player.currentSA >= 4) {
				player.setRunning(true);
			}
			else {
				player.setRunning(false);
			}
			break;

		}

		return false;
	}

	public void setPlayer(Player players) {
		player = players;

	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.W:
			player.setmUp(false);
			break;
		case Keys.A:
			player.setmLeft(false);
			break;
		case Keys.S:
			player.setmDown(false);
			break;
		case Keys.D:
			player.setmRight(false);
			break;
		case Keys.UP:
			player.setmUp(false);
			break;
		case Keys.LEFT:
			player.setmLeft(false);
			break;
		case Keys.RIGHT:
			player.setmRight(false);
			;
			break;
		case Keys.DOWN:
			player.setmDown(false);
			break;
		case Keys.SHIFT_LEFT:

			player.setRunning(false);

			break;
		case Keys.SHIFT_RIGHT:
			player.setRunning(false);
			break;
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
