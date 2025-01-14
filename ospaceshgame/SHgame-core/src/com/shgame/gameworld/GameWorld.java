package com.shgame.gameworld;

import com.badlogic.gdx.Gdx;
import com.shgame.ui.HelpAbout;
import com.shgame.ui.MultiPlayer;
import com.shgame.ui.Options;
import com.shgame.ui.SinglePlay;

public class GameWorld {

	// Каждый экран имеет свой world и renderer
	// В world-е инициализируются все объекты на данном экране и вызывается напостой метод update
	private SinglePlay spBtn;
	private MultiPlayer mpBtn;
	private Options opBtn;
	private HelpAbout haBtn;
	
	public GameWorld(float width, float height){
		spBtn = new SinglePlay(width,height);
		mpBtn = new MultiPlayer(width,height);
		opBtn = new Options(width,height);
		haBtn = new HelpAbout(width,height);
	}
	
	public void update(float delta) {
        //Gdx.app.log("GameWorld", "update");
        spBtn.update(delta);
        mpBtn.update(delta);
        opBtn.update(delta);
        haBtn.update(delta);
    }
	
	public SinglePlay getSPBtn(){
    	return spBtn;
    }
	
	public MultiPlayer getMPBtn(){
    	return mpBtn;
    }
	
	public Options getOPBtn(){
    	return opBtn;
    }
	
	public HelpAbout getHABtn(){
    	return haBtn;
    }
}
