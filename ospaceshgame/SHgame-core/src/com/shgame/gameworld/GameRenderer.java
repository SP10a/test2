package com.shgame.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.shgame.game.MySHgame;
import com.shgame.shhelpers.AssetLoader;
import com.shgame.ui.HelpAbout;
import com.shgame.ui.MultiPlayer;
import com.shgame.ui.Options;
import com.shgame.ui.SinglePlay;

public class GameRenderer {

	// в конструкторе класса инициализируются обьекты экрана и установка координат обьектов
	
	private MySHgame game;
	private GameWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	private TextureRegion bg;
	public static TextureRegion singlePlayBtn,singlePlayBtnDown;
    public static TextureRegion multiPlayerBtn,multiPlayerBtnDown;
    public static TextureRegion optionsBtn,optionsBtnDown;
    public static TextureRegion helpAboutBtn,helpAboutBtnDown;
    
    // флаги нажатия и отпускания кнопок на экране
    public static boolean touchBtn = false;
    public static boolean upBtn = false;
    
    public SinglePlay SPBtn;
    public MultiPlayer MPBtn;
	public Options OPBtn;
	public HelpAbout HABtn;
	
	// номер нажатой кнопки экрана
    public static int nmbBtn = 0;
    
	public float gameWidth,gameHeight;
	
	// координаты кнопок и их размер
	public float wx,wy,wy1,wy2,wy3, wWidth, wHeight;
	
	public GameRenderer(GameWorld world, float width, float height, MySHgame game) {
	    this.game = game;
		
		myWorld = world;
	    gameWidth=width;
	    gameHeight=height;
	    
	    SPBtn = world.getSPBtn();
	    MPBtn = world.getMPBtn();
	    OPBtn = world.getOPBtn();
	    HABtn = world.getHABtn();
	    
	    wx=SPBtn.wx;
	    wy=SPBtn.wy;
	    wWidth=SPBtn.btnWidth;
	    wHeight=SPBtn.btnHeight;
	    
	    wy1=MPBtn.wy;
	    wy2=OPBtn.wy;
	    wy3=HABtn.wy;
	    
	    cam = new OrthographicCamera();
	    cam.setToOrtho(true, width, height);
	    
	    batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        
	    shapeRenderer = new ShapeRenderer();
	    shapeRenderer.setProjectionMatrix(cam.combined);
	    initAssets();
	}
	
	private void initAssets() {
        bg = AssetLoader.bg;
        singlePlayBtn = AssetLoader.singlePlayBtn;
        singlePlayBtnDown = AssetLoader.singlePlayBtnDown;
        multiPlayerBtn = AssetLoader.multiPlayerBtn;
        multiPlayerBtnDown = AssetLoader.multiPlayerBtnDown;
        optionsBtn = AssetLoader.optionsBtn;
        optionsBtnDown = AssetLoader.optionsBtnDown;
        helpAboutBtn = AssetLoader.helpAboutBtn;
        helpAboutBtnDown = AssetLoader.helpAboutBtnDown;
	}
	
	public void render() {
	    //Gdx.app.log("GameRenderer", "render");
	    batcher.begin();
        batcher.disableBlending();
        batcher.draw(bg, 0, 0, gameWidth, gameHeight);
        
        batcher.draw(singlePlayBtn, wx, wy, wWidth, wHeight);
        batcher.draw(multiPlayerBtn, wx, wy1, wWidth, wHeight);
        batcher.draw(optionsBtn, wx, wy2, wWidth, wHeight);
        batcher.draw(helpAboutBtn, wx, wy3, wWidth, wHeight);
        
        if(touchBtn)
        	switch(nmbBtn){
        	case 1:
        		batcher.draw(singlePlayBtnDown, wx, wy, wWidth, wHeight);
        		//game.setScreen(game.singleplay);
        		break;
        	case 2:	
        		batcher.draw(multiPlayerBtnDown, wx, wy1, wWidth, wHeight);
        		//game.setScreen(game.multiplay);
        		break;
        	case 3:	
        		batcher.draw(optionsBtnDown, wx, wy2, wWidth, wHeight);
        		//game.setScreen(game.options);
        		//game.setScreen(game.multiplay);
        		break;
        	case 4:	
        		batcher.draw(helpAboutBtnDown, wx, wy3, wWidth, wHeight);
        		/*try {
        			Thread.sleep(100, 0);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}*/
        		//game.setScreen(game.helpabout);
        		Gdx.app.log("Screen", "getscreen:  " + game.getScreen());
        		break;
        	}
        if(upBtn)
        	switch(nmbBtn){
        	case 1:
        		game.setScreen(game.singleplay);
        		break;
        	case 2:	
        		game.setScreen(game.multiplay);
        		break;
        	case 3:	
        		//game.setScreen(game.options);
        		game.setScreen(game.multiplay);
        		break;
        	case 4:	
        		game.setScreen(game.helpabout);
        		break;
        	}
        upBtn=false;
        batcher.end();

	}
}
