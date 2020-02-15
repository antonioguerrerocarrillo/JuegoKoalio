package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.maps.tiled.*;
import com.badlogic.gdx.maps.tiled.renderers.*;
import com.badlogic.gdx.scenes.scene2d.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MainScreen implements Screen {
    
    final int balasEnemigas = 5;
    
    MyGdxGame game;
    Stage stage;
    TiledMap map;
    OrthogonalTiledMapRenderer renderer;
    OrthographicCamera camera;
    Koala koala;
    ArrayList<coin> coins = new ArrayList();
    ArrayList<Balas> balas = new ArrayList();
    ArrayList<Tortuga> tortugas = new ArrayList();
    ArrayList<Bicho> bichos = new ArrayList();

    MainScreen(MyGdxGame aThis) {
        this.game = aThis;
    }
    
    public void show() {
        map = new TmxMapLoader().load("level4.tmx");
        final float pixelsPerTile = 16;
        renderer = new OrthogonalTiledMapRenderer(map, 1 / pixelsPerTile);
        camera = new OrthographicCamera();

        stage = new Stage();
        stage.getViewport().setCamera(camera);

        koala = new Koala();
        koala.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        koala.setPosition(10, 10);
        stage.addActor(koala);
        
        this.loadCoins(0, 0);
        //this.loadTortuga(0, 0);
        this.loadBicho(0, 0);
        
        for(int i = 0; i < balasEnemigas; i++){
            this.spanwBalas();
        }
                
    }

    public void render(float delta) {
        Gdx.gl.glClearColor(0.5f, 0.5f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.position.x = koala.getX();
        camera.update();

        renderer.setView(camera);
        renderer.render();
        
        this.cogerMoneda();
        this.morirBicho();
        this.morirBala();
        
        stage.act(delta);
        stage.draw();
    }

    public void dispose() {
    }

    public void hide() {
    }

    public void pause() {
    }
    public void cogerMoneda(){
        
        Iterator<coin> iter = coins.iterator();
                
        while(iter.hasNext()){
            coin con = iter.next();
            if(koala.getX() < con.getX() +1 && con.getX() -1 < koala.getX() && koala.getY() < con.getY() +1 && con.getY() -1 < koala.getY() ) {
                System.out.println("entra");
            //con.setY(-10);
                con.remove();
            }
            
        }
        
    
    }
     public void morirBicho(){
        
        Iterator<Bicho> iter = bichos.iterator();
                
        while(iter.hasNext()){
            Bicho bicho = iter.next();
            if(koala.getX() < bicho.getX() +1 && bicho.getX() -1 < koala.getX() && koala.getY() < bicho.getY() +1 && bicho.getY() -1 < koala.getY() ) {
                System.out.println("pum muerto");
                //con.setY(-10); 
                 game.setScreen((Screen) new PantallaLoose(game));
                 dispose();
                 koala.remove();
            }
            
        }
        
    
    }
        public void morirBala(){
        
        Iterator<Balas> iter = balas.iterator();
                
        while(iter.hasNext()){
            Balas bicho = iter.next();
            if(koala.getX() < bicho.getX() +1 && bicho.getX() -1 < koala.getX() && koala.getY() < bicho.getY() +1 && bicho.getY() -1 < koala.getY() ) {
                System.out.println("pum muerto");
            //con.setY(-10);
                koala.remove();
            }
            
        }
        
    
    }
    public void resize(int width, int height) {
        camera.setToOrtho(false, 20 * width / height, 20);
    }

    public void resume() {
    }
      private void spawnBicho(float x, float y){
        
        Bicho bicho = new Bicho();
        bicho.setPosition(x, y);
        stage.addActor(bicho);
        bichos.add(bicho);
        
    }
    private void spawnCoin(float x, float y){
        
        coin coin = new coin();
        coin.setPosition(x, y);
        stage.addActor(coin);
        coins.add(coin);
        
    }
   
    private void spanwBalas(){
        
        Balas bala = new Balas();
        float x =(float) Math.random()* 260+139;
        float y = (float) (Math.random()* 18+7);
        bala.setPosition(x, y);
        stage.addActor(bala);
        balas.add(bala);
        
    }
      /*private void spanwTortuga(float x, float y){
       
        Tortuga tortuga = new Tortuga();
        tortuga.layer = (TiledMapTileLayer) map.getLayers().get("walls");
        tortuga.setPosition(x, y);
        stage.addActor(tortuga);
        tortugas.add(tortuga);
        
    }*/
     /* private void loadTortuga(float startX, float startY) {
         
        TiledMapTileLayer tortugas = (TiledMapTileLayer) map.getLayers().get("tortuga");
        
        float endX = startX + tortugas.getWidth();
        float endY = startY + tortugas.getHeight();

        int x = (int) startX;
        while (x < endX) {

            int y = (int) startY;
            while (y < endY) {
                if (tortugas.getCell(x, y) != null) {
                    if (tortugas.getProperties().get("tortuga", Boolean.class) == false) {
                        tortugas.setCell(x, y, null);
                        this.spanwTortuga(x,y);
                    }
                }
                y = y + 1;
            }
            x = x + 1;
        }

    }*/
     private void loadCoins(float startX, float startY) {
         
        TiledMapTileLayer coins = (TiledMapTileLayer) map.getLayers().get("coins");
        
        float endX = startX + coins.getWidth();
        float endY = startY + coins.getHeight();

        int x = (int) startX;
        while (x < endX) {

            int y = (int) startY;
            while (y < endY) {
                if (coins.getCell(x, y) != null) {
                    if (coins.getProperties().get("coins", Boolean.class) == false) {
                        coins.setCell(x, y, null);
                        this.spawnCoin(x, y);
                    }
                }
                y = y + 1;
            }
            x = x + 1;
        }
        
    }
     private void loadBicho(float startX, float startY) {
         
        TiledMapTileLayer bicho = (TiledMapTileLayer) map.getLayers().get("bicho");
        
        float endX = startX + bicho.getWidth();
        float endY = startY + bicho.getHeight();

        int x = (int) startX;
        while (x < endX) {

            int y = (int) startY;
            while (y < endY) {
                if (bicho.getCell(x, y) != null) {
                    if (bicho.getProperties().get("bicho", Boolean.class) == false) {
                        bicho.setCell(x, y, null);
                        this.spawnBicho(x, y);
                    }
                }
                y = y + 1;
            }
            x = x + 1;
        }
     }
}
