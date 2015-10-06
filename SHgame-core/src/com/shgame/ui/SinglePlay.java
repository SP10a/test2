package com.shgame.ui;

import com.badlogic.gdx.math.Rectangle;
import com.shgame.gameworld.GameRenderer;

public class SinglePlay {

	// класс кнопки из главного меню
	
	public float btnWidth,btnHeight;
	public float wx,wy;
	public Rectangle bounds;
	
	public SinglePlay(float width,float height){
		btnWidth = width/5;
		btnHeight = height/10;
		wx = width-width/3;
		wy = height/2;
		
		bounds = new Rectangle(wx, wy, btnWidth, btnHeight);
	}
	
	public void update(float delta){
		
	}
	
	public void offClick(int touchX, int touchY){
		// если отпустить В регионе кнопки то сработает переход на другой экран
		if(bounds.contains(touchX, touchY))
		{
			GameRenderer.touchBtn=false;
			GameRenderer.upBtn=true;
		}
		// если отпустить ВНЕ региона кнопки,то ничего не произойдет
		GameRenderer.touchBtn=false;
	}
	
	public void onClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
			{
			GameRenderer.touchBtn=true;
			GameRenderer.upBtn=false;
			GameRenderer.nmbBtn=1;
			}
	}
}
