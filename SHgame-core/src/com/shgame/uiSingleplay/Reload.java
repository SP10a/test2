package com.shgame.uiSingleplay;

import com.badlogic.gdx.math.Rectangle;

public class Reload {

	// класс перезарядки
	public float btnWidth,btnHeight;
	public float wx,wy;
	public Rectangle bounds;
	
	public Reload(float width,float height){
		btnWidth = width/8;
		btnHeight = height/8;
		wx = width/5+5;
		wy = height - height/8;
		
		bounds = new Rectangle(wx, wy, btnWidth, btnHeight);
	}
	
	public void update(float delta){
		
	}
	
	public void offClick(){

	}
	
	public void onClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
			{

			}
	}
}
