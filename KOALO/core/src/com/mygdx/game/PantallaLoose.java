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
public class PantallaLoose implements Screen {
    MyGdxGame game;
    BitmapFont font;
     private Texture  imagenFinal;
     OrthographicCamera camera;
     
    PantallaLoose(MyGdxGame games) {
        game = games;
        camera = new OrthographicCamera();
    }
    @Override
    public void render(float delta) {
        
           Gdx.gl.glClearColor(0, 0, 0.20f, 1);
           Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
           imagenFinal = new Texture(Gdx.files.internal("perdiste.jpg"));
           //System.out.println("puntos "+ score);
           camera.update();
           game.batch.setProjectionMatrix(camera.combined);

           game.batch.begin();
           game.batch.draw(imagenFinal, 0, 0, 800,480);
           game.font.draw(game.batch, "Lo siento has perdido ", 300, 300);
           game.batch.end();

           if (Gdx.input.isTouched()) {
               game.setScreen((Screen) new MainScreen(game));
               //dispose();
           }   
    }

    @Override
    public void show() {
        
    }

    @Override
    public void resize(int width, int height) {
       
    }

    @Override
    public void pause() {
       
    }

    @Override
    public void resume() {
        
    }

    @Override
    public void hide() {
     }

    @Override
    public void dispose() {
        }
}
