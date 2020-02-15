package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class Bicho extends Image {
    TextureRegion stand, jump;
    Animation walk;

    float time = 0;
    float xVelocity = 0;
    float yVelocity = 0;
    boolean canJump = false;
    boolean isFacingRight = true;
    TiledMapTileLayer layer;


    final float MAX_VELOCITY = 10f;

    public Bicho() {
        final float width = 20;
        final float height = 25;
        this.setSize(1, height / width);

        Texture koalaTexture = new Texture("planta2.png");
        TextureRegion[][] grid = TextureRegion.split(koalaTexture, (int) width, (int) height);

        stand = grid[0][0];
        //jump = grid[0][1];
        //walk = new Animation(0.15f, grid[0][0], grid[0][0], grid[0][0]);
        //walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public void act(float delta) {
        time = time + delta;
        
       // System.out.println("koala x " +this.getX());
        
        float x = this.getX();
        float y = this.getY();
        float xChange = xVelocity * delta;
        float yChange = yVelocity * delta;

        //xVelocity = -1 * MAX_VELOCITY;
        
        //this.setPosition(x + xChange, y + yChange);

        
    }

    public void draw(Batch batch, float parentAlpha) {
        TextureRegion frame;

        frame = stand;
        

        if (isFacingRight) {
            batch.draw(frame, this.getX(), this.getY(), this.getWidth(), this.getHeight());
        } else {
            batch.draw(frame, this.getX() + this.getWidth(), this.getY(), -1 * this.getWidth(), this.getHeight());
        }
    }
}