package com.shgame.uiHelpAbout.uiWeapon;

import com.badlogic.gdx.math.Rectangle;
import com.shgame.helpaboutworld.HelpAboutRenderer;

public class People_3 {
	public float btnWidth,btnHeight;
	public float wx,wy;
	public Rectangle bounds;
	
	public People_3(float width, float height){
		btnWidth = (width-width/3.5f)/11;
		btnWidth = width/11;
		btnHeight = height/6.575f;
		wx = btnWidth*2;
		wy = height/5.517f;
		
		bounds = new Rectangle(wx, wy, btnWidth, btnHeight);
	}
	
	public void update(float delta){
		
	}
	
	public void offClick(){
		HelpAboutRenderer.people_touchBtn=false;
	}
	
	public void onClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
			{
				HelpAboutRenderer.people_touchBtn=true;
				HelpAboutRenderer.people_nmbBtn=3;
			}
	}
}
