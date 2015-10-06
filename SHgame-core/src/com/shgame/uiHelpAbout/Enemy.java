package com.shgame.uiHelpAbout;

import com.badlogic.gdx.math.Rectangle;
import com.shgame.helpaboutworld.HelpAboutRenderer;

public class Enemy {

	public float btnWidth,btnHeight;
	public float wx,wy;
	public Rectangle bounds;
	
	public Enemy(float width,float height){
		btnWidth = width/5;
		btnHeight = height/10;
		wx = width-width/3.5f;
		wy = height/3+btnHeight*2+10;
		
		bounds = new Rectangle(wx, wy, btnWidth, btnHeight);
	}
	
	public void update(float delta){
		
	}
	
	public void offClick(){
		HelpAboutRenderer.touchBtn = false;
		HelpAboutRenderer.upBtn = false;
	}
	
	public void onClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
			{
			HelpAboutRenderer.touchBtn=true;
			HelpAboutRenderer.upBtn = false;
			HelpAboutRenderer.nmbBtn=3;
			HelpAboutRenderer.flagBtn=3;
			}
	}
}
