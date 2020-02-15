/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author cuvil
 */
public class PantallaLoose {
    MyGdxGame game;
    SpriteBatch batch;
    BitmapFont font;
     private Texture  imagenFinal;
     final Koala koala = null;
     OrthographicCamera camera;
     
    PantallaLoose(MyGdxGame games) {
        game = games;
    }
   
    public void render(float delta) {
            Gdx.gl.glClearColor(0, 0, 0.2f, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            imagenFinal = new Texture(Gdx.files.internal("fondoFinal.jpg"));
            //System.out.println("puntos "+ score);
            camera.update();
            batch.setProjectionMatrix(camera.combined);

            batch.begin();
            batch.draw(imagenFinal, 0, 0, 800,480);
            koala.font.draw(koala.batch, "Lo siento has perdido ", 300, 300);
            koala.batch.end();

            if (Gdx.input.isTouched()) {
                game.setScreen((Screen) new MainScreen(game));
                //dispose();
            }
    }
}
