package com.mygdx.game;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	public void create() {
		this.setScreen(new MainScreen(this));
                
	}
}
