package com.shgame.uiSingleplay;

import com.badlogic.gdx.math.Rectangle;

public class Guy {

	// класс человечка на игровом поле
	public static float btnWidth,btnHeight;
	public static float wx,wy;
	public Rectangle bounds;
	
	public Guy(float width,float height){
		btnWidth = width/12;
		btnHeight = height/12;
		wx = width/2;
		wy = height/2;
		
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
