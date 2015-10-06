package com.shgame.uiHelpAbout.uiEnemy;

import com.badlogic.gdx.math.Rectangle;
import com.shgame.helpaboutworld.HelpAboutRenderer;

public class Enemy_3 {
	public float btnWidth,btnHeight;
	public float wx,wy;
	public Rectangle bounds;
	
	public Enemy_3(float width,float height){
		btnWidth = (width-width/3.5f)/8;
		btnHeight = height/6.575f;
		wx = btnWidth*2;
		wy = height/5.517f;
		
		bounds = new Rectangle(wx, wy, btnWidth, btnHeight);
	}
	
	public void update(float delta){
		
	}
	
	public void offClick(){
		HelpAboutRenderer.enemy_touchBtn=false;
	}
	
	public void onClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
			{
				HelpAboutRenderer.enemy_touchBtn=true;
				HelpAboutRenderer.enemy_nmbBtn=3;
			}
	}
}
