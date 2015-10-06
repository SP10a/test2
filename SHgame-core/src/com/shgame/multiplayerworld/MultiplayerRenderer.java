package com.shgame.multiplayerworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.shgame.game.MySHgame;
import com.shgame.shhelpers.AssetLoader;
import com.shgame.uiMultiplayer.BackMult;


public class MultiplayerRenderer {

	private MySHgame game;
	private MultiplayerWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher,spriteBatcher;
	
	public static boolean touchBtn = false;
	public static boolean upBtn = false;
	public BackMult myBackBtn;
	public float gameWidth,gameHeight, wx, wy, wWidth, wHeight;
	
	public static TextureRegion backBtn, backBtnDown;    
	private TextureRegion bg;
	
    public static BitmapFont text;
	
	public MultiplayerRenderer(MultiplayerWorld world, float width, float height, MySHgame game){
		myWorld = world;
		gameWidth = width;
		gameHeight = height;
        this.game = game;
        
        initAssets();
        
        myBackBtn = world.getBackBtn();
        
        wx = myBackBtn.wx;
        wy = myBackBtn.wy;
        wWidth = myBackBtn.btnWidth;
        wHeight = myBackBtn.btnHeight;
        
        cam = new OrthographicCamera();
	    cam.setToOrtho(true, width, height);
	    
	    batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        
        spriteBatcher = new SpriteBatch();
        spriteBatcher.setProjectionMatrix(cam.combined);
        
	    shapeRenderer = new ShapeRenderer();
	    shapeRenderer.setProjectionMatrix(cam.combined);
	}
	
	private void initAssets() {
		backBtn = AssetLoader.backBtn;
        backBtnDown = AssetLoader.backBtnDown;
        bg = AssetLoader.bg;
        text = AssetLoader.text;
	}
	
	public void render(){
        
		batcher.begin();
        
		batcher.draw(bg, 0, 0, gameWidth, gameHeight);
		batcher.draw(backBtn, wx, wy, wWidth, wHeight);
		text.getData().setScale(1.2f, -1f);
		text.draw(batcher, "Cooming soon", gameWidth - gameWidth/3, gameHeight/2);
		
        if(touchBtn)
        	batcher.draw(backBtnDown, wx, wy, wWidth, wHeight);

        if(upBtn)
        	game.setScreen(game.menu);
        upBtn=false;
        batcher.end();
        
	}
}
