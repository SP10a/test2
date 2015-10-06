package com.shgame.helpaboutworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.shgame.game.MySHgame;
import com.shgame.shhelpers.AssetLoader;
import com.shgame.uiHelpAbout.About;
import com.shgame.uiHelpAbout.Back;
import com.shgame.uiHelpAbout.Enemy;
import com.shgame.uiHelpAbout.General;
import com.shgame.uiHelpAbout.Weapon;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_1;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_2;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_3;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_4;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_5;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_6;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_7;
import com.shgame.uiHelpAbout.uiEnemy.Enemy_8;
import com.shgame.uiHelpAbout.uiWeapon.People_1;
import com.shgame.uiHelpAbout.uiWeapon.People_2;
import com.shgame.uiHelpAbout.uiWeapon.People_3;
import com.shgame.uiHelpAbout.uiWeapon.People_4;
import com.shgame.uiHelpAbout.uiWeapon.People_5;
import com.shgame.uiHelpAbout.uiWeapon.People_6;
import com.shgame.uiHelpAbout.uiWeapon.People_7;
import com.shgame.uiHelpAbout.uiWeapon.People_8;
import com.shgame.uiHelpAbout.uiWeapon.People_9;
import com.shgame.uiHelpAbout.uiWeapon.People_10;
import com.shgame.uiHelpAbout.uiWeapon.People_11;


public class HelpAboutRenderer {

	private MySHgame game;
	private HelpAboutWorld myWorld;
	private OrthographicCamera cam;
	private ShapeRenderer shapeRenderer;
	private SpriteBatch batcher,spriteBatcher;
	private TextureRegion bg_ha;
    
	// флаги нажатия кнопок на экране HelpAbout
	public static boolean touchBtn = false;
	public static boolean upBtn = false;
	public static boolean enemy_touchBtn = false;
	public static boolean people_touchBtn = false;
	
	public General myGeneralBtn;
	public Weapon myWeaponBtn;
	public Enemy myEnemyBtn;
	public About myAboutBtn;
	public Back myBackBtn;
	
	// текстуры оружий
	public static TextureRegion p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11;
	// текстуры врагов
	public static TextureRegion e1,e2,e3,e4,e5,e6,e7,e8;
	
	public static TextureRegion generalBtn, generalBtnDown;
    public static TextureRegion weaponBtn, weaponBtnDown;
    public static TextureRegion enemyBtn, enemyBtnDown;
    public static TextureRegion aboutBtn, aboutBtnDown;
    public static TextureRegion backBtn, backBtnDown;    
    
    // поле текста
    public static BitmapFont text;
    
    // номера нажатых кнопок на экране
	public static int nmbBtn = 0;
	public static int enemy_nmbBtn = 0;
	public static int people_nmbBtn = 0;
	public static int flagBtn = 0;
	
	// координаты кнопок меню экрана HelpAbout
	public float gameWidth,gameHeight, wx,wy,wy1,wy2,wy3,wy4, wWidth, wHeight;
	
	// координаты кнопок врагов и оружия
	public float px,px1,px2,px3,px4,px5,px6,px7,px8,px9,px10;
	public float ex,ex1,ex2,ex3,ex4,ex5,ex6,ex7;
	public float ey, py;
	
	public Enemy_1 enemy1;
	public Enemy_2 enemy2;
	public Enemy_3 enemy3;
	public Enemy_4 enemy4;
	public Enemy_5 enemy5;
	public Enemy_6 enemy6;
	public Enemy_7 enemy7;
	public Enemy_8 enemy8;
	
	public People_1 people1;
	public People_2 people2;
	public People_3 people3;
	public People_4 people4;
	public People_5 people5;
	public People_6 people6;
	public People_7 people7;
	public People_8 people8;
	public People_9 people9;
	public People_10 people10;
	public People_11 people11;
	
	// размер кнопок врагов и оружия
	public float pWidth,pHeight,eWidth,eHeight;
	
	public String gen = "The objective oh the game is to prevent the seals";
	public String gen1 = "and other arctic creatures from reaching the ocean";
	public String gen2 = "where they eat our fish and mate and reproduce.";
	
	public String abt = "The original game and multiplayer on PC";
	public String abt1 = "you can find there:";
	public String abt2 = "http://sealhunter.se/";
	public String abt3 = "http://sealhunter.com/";
	public String abt4 = "http://sealhunter.ru/";
	public String abt5 = "The author of this app on android:";
	public String abt6 = "people@gmail.com";
	public String abt7 = "Thanks for helps: bla bla bla";
	
	public String [] name_enemy = {"Seal", "Seal Cub", "Fat Seal", "British Activist", "Penguin", "Polar Bear", "Turtle", "Walrus"};
	public String [] discription = {"The common Scandinavian Brown Seal", "Cute and fluffy", "He is so big", "Parents divorced during puberty", "Yes, you CAN find these in Norway", "Only slighty endangered", "This is a big turtle", "The fiercest predator in the world"};
	public String [] cash = {"Bounty: $50", "Bounty: $25", "Bounty: $200+$200 if boss", "Bounty: $100", "Bounty: $100", "Bounty: $500", "Bounty: $500", "Bounty: $1000"};
	public String [] bonus = {"Headshot Bonus: $10", "", "Headshot Bonus: $0", "Headshot Bonus: $15", "Headshot Bonus: $10", "Headshot Bonus: $0", "Headshot Bonus: $0", "Headshot Bonus: $0"};
	public String [] hp = {"Hit Points: 26+Level*21", "Hit Points: 10+Level*5", "Hit Points: Level*250 (1250 if boss)", "Hit Points: 30+Level*35", "Hit Points: Level*25", "Hit Points: 1700 (2000 if boss)", "Hit Points: 2500", "Hit Points: 15000"};
	public String [] speed = {"Speed: 25-55 pixels/Second", "Speed: 22-37 pixels/Second", "Speed: 35 pixels/Second", "Speed: 55-100 pixels/Second", "Speed: 32-55 pixels/Second", "Speed: 40-370 pixels/Second", "Speed: 30 pixels/Second", "Speed: 400-900 pixels/Second"};
	public String [] special = {"Special: May crawl while critically wounded", "", "Special: Regenerates hit points when standing still", "Special: Carries a seal cub", "Special: Dives and gains 87-157 speed", "Special: Gets enraged when hit", "Special: Hides in his shell after taking damage", "Special: Out for a kill!"};
	
	public String [] name_weapon = { "Magnum - $500", "MP5 - $1000", "Grenades - $1500", "Shotgun - $2000", "Dual Mac10s - $3000", "Grenade Launcher - $5000", "Assult Rifle - $6000", "Sniper Rifle - $7500", "1876 Vintage Shotgun - $10000", "Minigun - $12500", "Pistol" };
	public String [] damage = { "Damage: 60(+5 per level, 80 at level 5)", "Damage: 23(+2 per level, 30 at level 5)", "Splash radius: 95 pixels", "Damage: 40 per bullet at point bland", "Damage: 37", "Splash radius: 100 pixels", "Damage: 60", "Damage: 855", "Damage: 125 per bullet", "Damage: 65", "Damage: 18" };
	public String [] accuracy = { "Accuracy: Perfect", "Accuracy: Good(+/- 1.5 degrees", "Damage: 250(at epicentre)", "Bullets per shot: 8", "Accuracy: Poor(+/- 4 degrees)", "Damage: 400(at epicentre)", "Accuracy: Good(+/- 1.5 degrees)", "Accuracy: Perfect", "Bullets per shot: 15", "Accuracy: Very good(+/- 1 degrees)", "Accuracy: Perfect" };
	public String [] clip = { "Clip Size: 6", "Clip Size: 30", "Clip Size: 1", "Accuracy: Abysmal(+/- 7.5 degrees)", "Clip Size: 60", "Clip Size: 5", "Clip Size: 30", "Clip Size: 5", "Accuracy: Poor(+/- 5.25 degrees)", "Clip Size: 150", "Clip Size: 12" };
	public String [] reload = { "Reload time: 2.2 Second", "Reload time: 1.6 Seconds", "Reload time: 1 Second", "Clip Size: 8", "Reload time: 2.6 Seconds", "Reload time: 3 Seconds", "Reload time: 1.6 Seconds", "Reload time: 2.2 Seconds", "Clip Size: 1", "Reload time: ~16 Second", "Reload time: 2 Second" };
	public String [] rate = { "Rate of fire: 2.5/Seconds", "Rate of fire: 10/Second", "Rate of fire: 1/Second", "Rate of fire: 1.2/Second", "Rate of fire: 16/Second", "Rate of fire: 2.5/Second", "Rate of fire: 10/Second", "Rate of fire: 0.75/Second", "Reload time: 1.5 Seconds", "Rate of fire: 2.4/Seconds", "Rate of fire: 4/Seconds" };
	public String [] dps = { "Damage per second: 90(->120)", "Damage per second: 153(->206)", "Damage per second: 250", "Rate of fire: 1.2/Second", "Damage per second: 361", "Damage per second: 434", "Damage per second: 400", "Damage per second: 593", "Rate of fire: 0.5/Second", "Damage per second: 844", "Damage per second: 41" };
	
	
	public HelpAboutRenderer(HelpAboutWorld world, float width, float height, MySHgame game){
		myWorld = world;
		gameWidth = width;
		gameHeight = height;
        this.game = game;
        
        initAssets();
        
        myGeneralBtn = world.getGeneralBtn();
        myWeaponBtn = world.getWeaponBtn();
        myEnemyBtn = world.getEnemyBtn();
        myAboutBtn = world.getAboutBtn();
        myBackBtn = world.getBackBtn();
        
        enemy1 = world.getEnemy_1Btn();
        enemy2 = world.getEnemy_2Btn();
        enemy3 = world.getEnemy_3Btn();
        enemy4 = world.getEnemy_4Btn();
        enemy5 = world.getEnemy_5Btn();
        enemy6 = world.getEnemy_6Btn();
        enemy7 = world.getEnemy_7Btn();
        enemy8 = world.getEnemy_8Btn();
        
        people1 = world.getPeople_1Btn();
        people2 = world.getPeople_2Btn();
        people3 = world.getPeople_3Btn();
        people4 = world.getPeople_4Btn();
        people5 = world.getPeople_5Btn();
        people6 = world.getPeople_6Btn();
        people7 = world.getPeople_7Btn();
        people8 = world.getPeople_8Btn();
        people9 = world.getPeople_9Btn();
        people10 = world.getPeople_10Btn();
        people11 = world.getPeople_11Btn();
        
        wx=myGeneralBtn.wx;
	    wy=myGeneralBtn.wy;
	    
	    wWidth=myGeneralBtn.btnWidth;
	    wHeight=myGeneralBtn.btnHeight;
	    
	    wy1=myWeaponBtn.wy;
	    wy2=myEnemyBtn.wy;
	    wy3=myAboutBtn.wy;
	    wy4=myBackBtn.wy;
	    
	    ey = enemy1.wy;
		
	    ex = enemy1.wx;
		ex1 = enemy2.wx;
		ex2 = enemy3.wx;
		ex3 = enemy4.wx;
		ex4 = enemy5.wx;
		ex5 = enemy6.wx;
		ex6 = enemy7.wx;
		ex7 = enemy8.wx;

		eWidth = enemy1.btnWidth;
		eHeight = enemy1.btnHeight;
		
		py = people1.wy;
		
		px = people1.wx;
		px1 = people2.wx;
		px2 = people3.wx;
		px3 = people4.wx;
		px4 = people5.wx;
		px5 = people6.wx;
		px6 = people7.wx;
		px7 = people8.wx;
		px8 = people9.wx;
		px9 = people10.wx;
		px10 = people11.wx;
		
		pWidth = people1.btnWidth;
		pHeight = people1.btnHeight;
		
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
        bg_ha = AssetLoader.bg_ha;
        generalBtn = AssetLoader.generalBtn;
        generalBtnDown = AssetLoader.generalBtnDown;
        weaponBtn = AssetLoader.weaponBtn;
        weaponBtnDown = AssetLoader.weaponBtnDown;
        enemyBtn = AssetLoader.enemyBtn;
        enemyBtnDown = AssetLoader.enemyBtnDown;
        aboutBtn = AssetLoader.aboutBtn;
        aboutBtnDown = AssetLoader.aboutBtnDown;
        backBtn = AssetLoader.backBtn;
        backBtnDown = AssetLoader.backBtnDown;
        text = AssetLoader.text;
        e1 = AssetLoader.e1;
        e2 = AssetLoader.e2;
        e3 = AssetLoader.e3;
        e4 = AssetLoader.e4;
        e5 = AssetLoader.e5;
        e6 = AssetLoader.e6;
        e7 = AssetLoader.e7;
        e8 = AssetLoader.e8;
        p1 = AssetLoader.p1;
        p2 = AssetLoader.p2;
        p3 = AssetLoader.p3;
        p4 = AssetLoader.p4;
        p5 = AssetLoader.p5;
        p6 = AssetLoader.p6;
        p7 = AssetLoader.p7;
        p8 = AssetLoader.p8;
        p9 = AssetLoader.p9;
        p10 = AssetLoader.p10;
        p11 = AssetLoader.p11;
	}
	
	public void render(){
        
		batcher.begin();
        
		startHA();
        
        clickBtn();
        
        batcher.end();
        
	}
	
	public void startHA(){
		batcher.disableBlending();
        batcher.draw(bg_ha, 0, 0, gameWidth, gameHeight);
        
        batcher.draw(generalBtn, wx, wy, wWidth, wHeight);
        batcher.draw(weaponBtn, wx, wy1, wWidth, wHeight);
        batcher.draw(enemyBtn, wx, wy2, wWidth, wHeight);
        batcher.draw(aboutBtn, wx, wy3, wWidth, wHeight);
        batcher.draw(backBtn, wx, wy4, wWidth, wHeight);
	}
	
	public void clickBtn(){
		 if(touchBtn)
	        	switch(nmbBtn){
	        	case 1:
	        		batcher.draw(generalBtnDown, wx, wy, wWidth, wHeight);
	        		render_general();
	        		break;
	        	case 2:	
	        		batcher.draw(weaponBtnDown, wx, wy1, wWidth, wHeight);
	        		render_weapon();
	        		break;
	        	case 3:	
	        		batcher.draw(enemyBtnDown, wx, wy2, wWidth, wHeight);
	        		render_enemy();
	        		break;
	        	case 4:	
	        		batcher.draw(aboutBtnDown, wx, wy3, wWidth, wHeight);
	        		render_about();
	        		break;
	        	case 5:
	        		batcher.draw(backBtnDown, wx, wy4, wWidth, wHeight);
	        		//touchBtn = false;
	        		people_touchBtn=false;
	        		people_nmbBtn=0;
	        		enemy_touchBtn=false;
	        		enemy_nmbBtn=0;
	        		//game.setScreen(game.menu);
	        		break;
	        	default:
	        		break;
	        	}
		 if(upBtn)
			 switch(nmbBtn){
			 	case 5:
			 		game.setScreen(game.menu);
			 		touchBtn=false;
			 		break;
			 	default:
			 		break;
			 }			 
		 		 
		 upBtn=false;
	}
	
	public void render_general(){
		
		people_touchBtn=false;
		people_nmbBtn=0;
		enemy_touchBtn=false;
		enemy_nmbBtn=0;
		text.getData().setScale(1.2f, -1f);
		batcher.enableBlending();
		text.draw(batcher, gen, 5, gameHeight/2);
		text.draw(batcher, gen1, 5, gameHeight/2+15);
		text.draw(batcher, gen2, 5, gameHeight/2+30);
	}
	
	public void render_about(){
		
		people_touchBtn=false;
		people_nmbBtn=0;
		enemy_touchBtn=false;
		enemy_nmbBtn=0;
		batcher.enableBlending();
		text.getData().setScale(1.2f, -1f);
		text.draw(batcher, abt, 5, gameHeight/2);
		text.draw(batcher, abt1, 5, gameHeight/2+15);
		text.draw(batcher, abt2, 5, gameHeight/2+30);
		text.draw(batcher, abt3, 5, gameHeight/2+45);
		text.draw(batcher, abt4, 5, gameHeight/2+60);
		text.draw(batcher, abt5, 5, gameHeight/2+75);
		text.draw(batcher, abt6, 5, gameHeight/2+90);
		text.draw(batcher, abt7, 5, gameHeight/2+105);
	}
	
	public void render_enemy(){
		
		people_touchBtn=false;
		people_nmbBtn=0;
		batcher.enableBlending();
		batcher.draw(e1, ex, ey, eWidth, eHeight);
        batcher.draw(e2, ex1, ey, eWidth, eHeight);
		batcher.draw(e3, ex2, ey, eWidth, eHeight);
		batcher.draw(e4, ex3, ey, eWidth, eHeight);
		batcher.draw(e5, ex4, ey, eWidth, eHeight);
		batcher.draw(e6, ex5, ey, eWidth, eHeight);
		batcher.draw(e7, ex6, ey, eWidth, eHeight);
		batcher.draw(e8, ex7, ey, eWidth, eHeight);
		render_enemyClick();
	}
	
	public void render_enemyClick(){
		text.getData().setScale(1.2f, -1f);
		if(enemy_touchBtn)
        	switch(enemy_nmbBtn){
        	case 1:
        		text.draw(batcher, name_enemy[0], 25, gameHeight/2);
        		text.draw(batcher, discription[0], 25, gameHeight/2+15);
        		text.draw(batcher, cash[0], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[0], 25, gameHeight/2+45);
        		text.draw(batcher, hp[0], 25, gameHeight/2+60);
        		text.draw(batcher, speed[0], 25, gameHeight/2+75);
        		text.draw(batcher, special[0], 25, gameHeight/2+90);
        		break;
        	case 2:
        		text.draw(batcher, name_enemy[1], 25, gameHeight/2);
        		text.draw(batcher, discription[1], 25, gameHeight/2+15);
        		text.draw(batcher, cash[1], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[1], 25, gameHeight/2+45);
        		text.draw(batcher, hp[1], 25, gameHeight/2+60);
        		text.draw(batcher, speed[1], 25, gameHeight/2+75);
        		text.draw(batcher, special[1], 25, gameHeight/2+90);
        		break;
        	case 3:
        		text.draw(batcher, name_enemy[2], 25, gameHeight/2);
        		text.draw(batcher, discription[2], 25, gameHeight/2+15);
        		text.draw(batcher, cash[2], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[2], 25, gameHeight/2+45);
        		text.draw(batcher, hp[2], 25, gameHeight/2+60);
        		text.draw(batcher, speed[2], 25, gameHeight/2+75);
        		text.draw(batcher, special[2], 25, gameHeight/2+90);
        		break;
        	case 4:
        		text.draw(batcher, name_enemy[3], 25, gameHeight/2);
        		text.draw(batcher, discription[3], 25, gameHeight/2+15);
        		text.draw(batcher, cash[3], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[3], 25, gameHeight/2+45);
        		text.draw(batcher, hp[3], 25, gameHeight/2+60);
        		text.draw(batcher, speed[3], 25, gameHeight/2+75);
        		text.draw(batcher, special[3], 25, gameHeight/2+90);
        		break;
        	case 5:
        		text.draw(batcher, name_enemy[4], 25, gameHeight/2);
        		text.draw(batcher, discription[4], 25, gameHeight/2+15);
        		text.draw(batcher, cash[4], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[4], 25, gameHeight/2+45);
        		text.draw(batcher, hp[4], 25, gameHeight/2+60);
        		text.draw(batcher, speed[4], 25, gameHeight/2+75);
        		text.draw(batcher, special[4], 25, gameHeight/2+90);
        		break;
        	case 6:
        		text.draw(batcher, name_enemy[5], 25, gameHeight/2);
        		text.draw(batcher, discription[5], 25, gameHeight/2+15);
        		text.draw(batcher, cash[5], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[5], 25, gameHeight/2+45);
        		text.draw(batcher, hp[5], 25, gameHeight/2+60);
        		text.draw(batcher, speed[5], 25, gameHeight/2+75);
        		text.draw(batcher, special[5], 25, gameHeight/2+90);
        		break;
        	case 7:
        		text.draw(batcher, name_enemy[6], 25, gameHeight/2);
        		text.draw(batcher, discription[6], 25, gameHeight/2+15);
        		text.draw(batcher, cash[6], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[6], 25, gameHeight/2+45);
        		text.draw(batcher, hp[6], 25, gameHeight/2+60);
        		text.draw(batcher, speed[6], 25, gameHeight/2+75);
        		text.draw(batcher, special[6], 25, gameHeight/2+90);
        		break;
        	case 8:
        		text.draw(batcher, name_enemy[7], 25, gameHeight/2);
        		text.draw(batcher, discription[7], 25, gameHeight/2+15);
        		text.draw(batcher, cash[7], 25, gameHeight/2+30);
        		text.draw(batcher, bonus[7], 25, gameHeight/2+45);
        		text.draw(batcher, hp[7], 25, gameHeight/2+60);
        		text.draw(batcher, speed[7], 25, gameHeight/2+75);
        		text.draw(batcher, special[7], 25, gameHeight/2+90);
        		break;
        	default:
        		break;
        	}
	}
	
	public void render_weapon(){
		
		enemy_touchBtn=false;
		enemy_nmbBtn=0;
		batcher.enableBlending();
		batcher.draw(p1, px, py, pWidth, pHeight);
		batcher.draw(p2, px1, py, pWidth, pHeight);
		batcher.draw(p3, px2, py, pWidth, pHeight);
		batcher.draw(p4, px3, py, pWidth, pHeight);
		batcher.draw(p5, px4, py, pWidth, pHeight);
		batcher.draw(p6, px5, py, pWidth, pHeight);
		batcher.draw(p7, px6, py, pWidth, pHeight);
		batcher.draw(p8, px7, py, pWidth, pHeight);
		batcher.draw(p9, px8, py, pWidth, pHeight);
		batcher.draw(p10, px9, py, pWidth, pHeight);
		batcher.draw(p11, px10, py, pWidth, pHeight);
		render_weaponClick();
	}
	
	public void render_weaponClick(){
		text.getData().setScale(1.2f, -1f);
		if(people_touchBtn)
        	switch(people_nmbBtn){
        	case 1:
        		text.draw(batcher, name_weapon[0], 25, gameHeight/2);
        		text.draw(batcher, damage[0], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[0], 25, gameHeight/2+30);
        		text.draw(batcher, clip[0], 25, gameHeight/2+45);
        		text.draw(batcher, reload[0], 25, gameHeight/2+60);
        		text.draw(batcher, rate[0], 25, gameHeight/2+75);
        		text.draw(batcher, dps[0], 25, gameHeight/2+90);
        		break;
        	case 2:
        		text.draw(batcher, name_weapon[1], 25, gameHeight/2);
        		text.draw(batcher, damage[1], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[1], 25, gameHeight/2+30);
        		text.draw(batcher, clip[1], 25, gameHeight/2+45);
        		text.draw(batcher, reload[1], 25, gameHeight/2+60);
        		text.draw(batcher, rate[1], 25, gameHeight/2+75);
        		text.draw(batcher, dps[1], 25, gameHeight/2+90);
        		break;
        	case 3:
        		text.draw(batcher, name_weapon[2], 25, gameHeight/2);
        		text.draw(batcher, damage[2], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[2], 25, gameHeight/2+30);
        		text.draw(batcher, clip[2], 25, gameHeight/2+45);
        		text.draw(batcher, reload[2], 25, gameHeight/2+60);
        		text.draw(batcher, rate[2], 25, gameHeight/2+75);
        		text.draw(batcher, dps[2], 25, gameHeight/2+90);
        		break;
        	case 4:
        		text.draw(batcher, name_weapon[3], 25, gameHeight/2);
        		text.draw(batcher, damage[3], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[3], 25, gameHeight/2+30);
        		text.draw(batcher, clip[3], 25, gameHeight/2+45);
        		text.draw(batcher, reload[3], 25, gameHeight/2+60);
        		text.draw(batcher, rate[3], 25, gameHeight/2+75);
        		text.draw(batcher, dps[3], 25, gameHeight/2+90);
        		break;
        	case 5:
        		text.draw(batcher, name_weapon[4], 25, gameHeight/2);
        		text.draw(batcher, damage[4], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[4], 25, gameHeight/2+30);
        		text.draw(batcher, clip[4], 25, gameHeight/2+45);
        		text.draw(batcher, reload[4], 25, gameHeight/2+60);
        		text.draw(batcher, rate[4], 25, gameHeight/2+75);
        		text.draw(batcher, dps[4], 25, gameHeight/2+90);
        		break;
        	case 6:
        		text.draw(batcher, name_weapon[5], 25, gameHeight/2);
        		text.draw(batcher, damage[5], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[5], 25, gameHeight/2+30);
        		text.draw(batcher, clip[5], 25, gameHeight/2+45);
        		text.draw(batcher, reload[5], 25, gameHeight/2+60);
        		text.draw(batcher, rate[5], 25, gameHeight/2+75);
        		text.draw(batcher, dps[5], 25, gameHeight/2+90);
        		break;
        	case 7:
        		text.draw(batcher, name_weapon[6], 25, gameHeight/2);
        		text.draw(batcher, damage[6], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[6], 25, gameHeight/2+30);
        		text.draw(batcher, clip[6], 25, gameHeight/2+45);
        		text.draw(batcher, reload[6], 25, gameHeight/2+60);
        		text.draw(batcher, rate[6], 25, gameHeight/2+75);
        		text.draw(batcher, dps[6], 25, gameHeight/2+90);
        		break;
        	case 8:
        		text.draw(batcher, name_weapon[7], 25, gameHeight/2);
        		text.draw(batcher, damage[7], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[7], 25, gameHeight/2+30);
        		text.draw(batcher, clip[7], 25, gameHeight/2+45);
        		text.draw(batcher, reload[7], 25, gameHeight/2+60);
        		text.draw(batcher, rate[7], 25, gameHeight/2+75);
        		text.draw(batcher, dps[7], 25, gameHeight/2+90);
        		break;
        	case 9:
        		text.draw(batcher, name_weapon[8], 25, gameHeight/2);
        		text.draw(batcher, damage[8], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[8], 25, gameHeight/2+30);
        		text.draw(batcher, clip[8], 25, gameHeight/2+45);
        		text.draw(batcher, reload[8], 25, gameHeight/2+60);
        		text.draw(batcher, rate[8], 25, gameHeight/2+75);
        		text.draw(batcher, dps[8], 25, gameHeight/2+90);
        		break;
        	case 10:
        		text.draw(batcher, name_weapon[9], 25, gameHeight/2);
        		text.draw(batcher, damage[9], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[9], 25, gameHeight/2+30);
        		text.draw(batcher, clip[9], 25, gameHeight/2+45);
        		text.draw(batcher, reload[9], 25, gameHeight/2+60);
        		text.draw(batcher, rate[9], 25, gameHeight/2+75);
        		text.draw(batcher, dps[9], 25, gameHeight/2+90);
        		break;
        	case 11:
        		text.draw(batcher, name_weapon[10], 25, gameHeight/2);
        		text.draw(batcher, damage[10], 25, gameHeight/2+15);
        		text.draw(batcher, accuracy[10], 25, gameHeight/2+30);
        		text.draw(batcher, clip[10], 25, gameHeight/2+45);
        		text.draw(batcher, reload[10], 25, gameHeight/2+60);
        		text.draw(batcher, rate[10], 25, gameHeight/2+75);
        		text.draw(batcher, dps[10], 25, gameHeight/2+90);
        		break;
        	default:
        		break;
        	}
	}
}
