package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.scenes.scene2d.ui.*;

public class coin extends Image {
    TextureRegion stand, jump;
    Animation walk;
    public static Texture items;
    float time = 0;
    float xVelocity = 0;
    float yVelocity = 0;
    boolean canJump = false;
    boolean isFacingRight = true;
    TiledMapTileLayer layer;

    final float GRAVITY = -2.5f;
    final float MAX_VELOCITY = 10f;
    final float DAMPING = 0.87f;
    public static Texture loadTexture (String file) {
		return new Texture(Gdx.files.internal(file));
    }
    public coin() {
        final float width = 18;
        final float height = 26;
        this.setSize(1, height / width);
        items = loadTexture("items.png");
        Texture koalaTexture = new Texture("koalio.png");
        walk = new Animation(0.2f, new TextureRegion(items, 128, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32),
			new TextureRegion(items, 192, 32, 32, 32), new TextureRegion(items, 160, 32, 32, 32));
        TextureRegion[][] grid = TextureRegion.split(koalaTexture, (int) width, (int) height);   
        walk.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
    }

    public void act(float delta) {
        time = time + delta;

    }

    public void draw(Batch batch, float parentAlpha) {
        TextureRegion frame;

       
            frame = (TextureRegion) walk.getKeyFrame(time);
       
            batch.draw(frame, this.getX(), this.getY(), this.getWidth(), this.getHeight());
       
          
    }

 
}
