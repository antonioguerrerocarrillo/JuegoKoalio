package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
        SpriteBatch batch ;
        BitmapFont font;
	public void create() {
            font = new BitmapFont();
            batch = new SpriteBatch();
		this.setScreen(new MainScreen(this));
                
	}
}
