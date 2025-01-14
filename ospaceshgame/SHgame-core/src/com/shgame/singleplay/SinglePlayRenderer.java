package com.shgame.singleplay;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.shgame.shhelpers.AssetLoader;
import com.shgame.uiSingleplay.Bullet;
import com.shgame.uiSingleplay.Control;
import com.shgame.uiSingleplay.Fire;
import com.shgame.uiSingleplay.Guy;
import com.shgame.uiSingleplay.Reload;
import com.shgame.uiSingleplay.Seal;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_1;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_10;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_2;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_3;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_4;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_5;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_6;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_7;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_8;
import com.shgame.uiSingleplay.uiCostweapon.Costweapon_9;

public class SinglePlayRenderer {

	private SinglePlayWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher;
	private TextureRegion bg_sp, reload, control, guy, fire;
	
	// модельки человечка с разным оружием
	private TextureRegion guy1, guy2, guy3, guy4, guy5, guy6, guy7, guy8, guy9, guy10;
	private TextureRegion bullet, snip;
	private TextureRegion regSeal;
	
	// текстуры верхней полосы экрана игры с оружием,ценами и счетом очков
	private TextureRegion cw1, cw2, cw3, cw4, cw5, cw6, cw7, cw8, cw9, cw10;
	private TextureRegion scoreboard;
	
	public Control controlBtn;
	public Fire fireBtn;
	public Reload reloadBtn;
	public Guy guyBtn;
	public Bullet bul;
	public Seal [] seal = new Seal [10];
	public ArrayList<Seal> seal_list;
	
	public Costweapon_1 cw1Btn;
	public Costweapon_2 cw2Btn;
	public Costweapon_3 cw3Btn;
	public Costweapon_4 cw4Btn;
	public Costweapon_5 cw5Btn;
	public Costweapon_6 cw6Btn;
	public Costweapon_7 cw7Btn;
	public Costweapon_8 cw8Btn;
	public Costweapon_9 cw9Btn;
	public Costweapon_10 cw10Btn;
	
	// прямоугольники для проверки касания тюленя и пули
	public Rectangle boundSeal, boundBul;
	
	public static BitmapFont text;
	
	// колличество убийств, деньги и номер оружия в руках
	public static int kills = 0;
	public static int cash = 0;
	public static int change_weapon = 0;
	
	
	public float gameWidth,gameHeight;
	// координаты и размеры обьектов экрана игры
	public float rx,ry,rWidth,rHeight;
	public float cx, cy, cWidth, cHeight;
	public static float gx, gy, gWidth, gHeight;
	public float fx, fy, fWidth, fHeight;
	public static float bx, by, bWidth, bHeight;
	public static float sx, sy, sWidth, sHeight;
	public static int hp_seal;
	public static float cwx1,cwx2,cwx3,cwx4,cwx5,cwx6,cwx7,cwx8,cwx9,cwx10;
	public static float cwy, cwWidth, cwHeight;
	
	// урон взависимости от типа оружия в руках
	public static int damage;
	
	public SinglePlayRenderer(SinglePlayWorld world, float width, float height){
		myWorld = world;
		gameWidth = width;
		gameHeight = height;
		
		Random r = new Random((long)height/5);
		
		cam = new OrthographicCamera();
	    cam.setToOrtho(true, width, height);
	    
	    batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        
	    shapeRenderer = new ShapeRenderer();
	    shapeRenderer.setProjectionMatrix(cam.combined);
	    
	    initAssets();
	    
	    controlBtn = world.getControlBtn();
	    fireBtn = world.getFireBtn();
	    reloadBtn = world.getReloadBtn();
	    guyBtn = world.getGuyBtn();
	    bul = world.getBul();
	    seal[0] = world.getSeal();
	    seal[1] = world.getSeal();
	    //seal_list.set(0, world.getSeal());
	    
	    cw1Btn = world.getCw1Btn();
	    cw2Btn = world.getCw2Btn();
	    cw3Btn = world.getCw3Btn();
	    cw4Btn = world.getCw4Btn();
	    cw5Btn = world.getCw5Btn();
	    cw6Btn = world.getCw6Btn();
	    cw7Btn = world.getCw7Btn();
	    cw8Btn = world.getCw8Btn();
	    cw9Btn = world.getCw9Btn();
	    cw10Btn =  world.getCw10Btn();
	    
	    cx = controlBtn.wx;
	    cy = controlBtn.wy;
	    cWidth = controlBtn.btnWidth;
	    cHeight = controlBtn.btnHeight;
	    
	    rx = reloadBtn.wx;
	    ry = reloadBtn.wy;
	    rWidth = reloadBtn.btnWidth;
	    rHeight = reloadBtn.btnHeight;
	    
		gx = guyBtn.wx;
	    gy = guyBtn.wy;
	    gWidth = guyBtn.btnWidth;
	    gHeight = guyBtn.btnHeight;
	    
	    fx = fireBtn.wx;
	    fy = fireBtn.wy;
	    fWidth = fireBtn.btnWidth;
	    fHeight = fireBtn.btnHeight;
	    
	    bx = bul.wx;
	    by = bul.wy;
	    bWidth = bul.btnWidth;
	    bHeight = bul.btnHeight;
	    
	    sx = seal[0].wx;
	    sy = seal[0].wy;
	    sWidth = seal[0].wWidth;
	    sHeight = seal[0].wHeight;
	    hp_seal = seal[0].hit_points;
	    
	    boundSeal = seal[0].bounds;
	    boundBul = bul.bounds;
	    
	    cwx1 = cw1Btn.wx;
	    cwx2 = cw2Btn.wx;
	    cwx3 = cw3Btn.wx;
	    cwx4 = cw4Btn.wx;
	    cwx5 = cw5Btn.wx;
	    cwx6 = cw6Btn.wx;
	    cwx7 = cw7Btn.wx;
	    cwx8 = cw8Btn.wx;
	    cwx9 = cw9Btn.wx;
	    cwx10 = cw10Btn.wx;
	    
	    cwy = cw1Btn.wy;
	    cwWidth = cw1Btn.btnWidth;
	    cwHeight = cw1Btn.btnHeight;
	}
	
	private void initAssets() {
        bg_sp = AssetLoader.bg_sp;
        guy = AssetLoader.p11;
        guy1 = AssetLoader.p1;
        guy2 = AssetLoader.p2;
        guy3 = AssetLoader.p3;
        guy4 = AssetLoader.p4;
        guy5 = AssetLoader.p5;
        guy6 = AssetLoader.p6;
        guy7 = AssetLoader.p7;
        guy8 = AssetLoader.p8;
        guy9 = AssetLoader.p9;
        guy10 = AssetLoader.p10;
        control = AssetLoader.control;
        fire = AssetLoader.fire;
        reload = AssetLoader.reload;
        bullet = AssetLoader.bullet;
        snip = AssetLoader.snip;
        regSeal = AssetLoader.seal;
        cw1 = AssetLoader.cw1;
        cw2 = AssetLoader.cw2;
        cw3 = AssetLoader.cw3;
        cw4 = AssetLoader.cw4;
        cw5 = AssetLoader.cw5;
        cw6 = AssetLoader.cw6;
        cw7 = AssetLoader.cw7;
        cw8 = AssetLoader.cw8;
        cw9 = AssetLoader.cw9;
        cw10 = AssetLoader.cw10;
        scoreboard = AssetLoader.scoreboard;
        text = AssetLoader.text;
	}
	
	public void render(){
		
		//Gdx.app.log("height", "sHeight - " + sHeight + " sy - " + sy);
		batcher.begin();
        batcher.disableBlending();
        batcher.draw(bg_sp, 0, 0, gameWidth, gameHeight);
        
        batcher.enableBlending();
        batcher.draw(cw1, cwx1, cwy, cwWidth, cwHeight);
        batcher.draw(cw2, cwx2, cwy, cwWidth, cwHeight);
        batcher.draw(cw3, cwx3, cwy, cwWidth, cwHeight);
        batcher.draw(cw4, cwx4, cwy, cwWidth, cwHeight);
        batcher.draw(cw5, cwx5, cwy, cwWidth, cwHeight);
        batcher.draw(cw6, cwx6, cwy, cwWidth, cwHeight);
        batcher.draw(cw7, cwx7, cwy, cwWidth, cwHeight);
        batcher.draw(cw8, cwx8, cwy, cwWidth, cwHeight);
        batcher.draw(cw9, cwx9, cwy, cwWidth, cwHeight);
        batcher.draw(cw10, cwx10, cwy, cwWidth, cwHeight);
        
        batcher.draw(scoreboard, cwWidth*10 + 25, cwy, gameWidth/8, cwHeight+5);
        text.getData().setScale(1f, -1f);
		text.draw(batcher, "Kills: " + kills, cwWidth*10 + 40, cwy+15);
		text.draw(batcher, cash + " $", cwWidth*10 + 40, cwy+35);
        
        batcher.draw(control, cx, cy, cWidth, cHeight);
        batcher.draw(reload, rx, ry, rWidth, rHeight);
        batcher.draw(fire, fx, fy, fWidth, fHeight);
        batcher.draw(snip, gx-gWidth, gy+(gHeight/3), 10, 10);
        batcher.draw(bullet, bx, by, bWidth, bHeight);
        
        batcher.draw(regSeal, sx, sy, sWidth, sHeight);
        batcher.draw(regSeal, sx - 100, sy - 80, seal[1].wWidth, seal[1].wHeight);
        
        if(change_weapon==0)
        {
        	damage = 18;
        	batcher.draw(guy, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==1)
        {
        	damage = 60;
        	batcher.draw(guy1, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==2)
        {
        	damage = 23;
        	batcher.draw(guy2, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==3)
        {
        	damage = 250;
        	batcher.draw(guy3, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==4)
        {
        	damage = 40;
        	batcher.draw(guy4, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==5)
        {
        	damage = 37;
        	batcher.draw(guy5, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==6)
        {
        	damage = 400;
        	batcher.draw(guy6, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==7)
        {
        	damage = 60;
        	batcher.draw(guy7, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==8)
        {
        	damage = 855;
        	batcher.draw(guy8, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==9)
        {
        	damage = 125;
        	batcher.draw(guy9, gx, gy, gWidth, gHeight);
        }
        if(change_weapon==10)
        {
        	damage = 65;
        	batcher.draw(guy10, gx, gy, gWidth, gHeight);
        }
        
        
        //if(seal[0].alive)
	        if(fireBtn.fire_bul)
	        	if(boundSeal.contains(boundBul))
	        	{
	        		hp_seal -= damage;
	        		if(hp_seal <= 0)
	        		{
	        			seal[0].alive = false;
	        			kills++;
	        			cash+=50;
	        		}
	        	}
	        	
        
        batcher.end();
	}
}
