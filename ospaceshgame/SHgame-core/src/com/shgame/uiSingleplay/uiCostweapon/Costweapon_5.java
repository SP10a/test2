package com.shgame.uiSingleplay.uiCostweapon;

import com.badlogic.gdx.math.Rectangle;
import com.shgame.singleplay.SinglePlayRenderer;

public class Costweapon_5 {


	public float btnWidth,btnHeight;
	public float wx,wy;
	public Rectangle bounds;
	public static boolean sell = false;
	
	public Costweapon_5(float width,float height){
		btnWidth = width/12;
		btnHeight = height/10;
		wx = btnWidth*4 + 13;
		wy = 5;
		
		bounds = new Rectangle(wx, wy, btnWidth, btnHeight);
	}
	
	public void update(float delta){
		
	}
	
	public void offClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
		{
			if(!sell)
				if(SinglePlayRenderer.cash >= 3500)
				{
					SinglePlayRenderer.change_weapon = 5;
					SinglePlayRenderer.cash -= 3500;
					sell = true;
				}
			if(sell)
				SinglePlayRenderer.change_weapon = 5;
		}
	}
	
	public void onClick(int touchX, int touchY){
		if(bounds.contains(touchX, touchY))
			{

			}
	}
}