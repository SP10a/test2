package com.shgame.uiSingleplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.shgame.singleplay.SinglePlayRenderer;


public class Control {

	// кнопка управление человеком
	// поделена на 9 регионов, в зависимости где было касание. срабатывает определенный фрагмент
	
	public float btnWidth,btnHeight;
	public float wx,wy;
	public float gameWidth, gameHeight;
	public Rectangle top,bot,left,right,topleft,topright,botleft,botright;
	public float x1,x2,x3,x4,x5,x6,x7,x8,x9;
	public float y1,y2,y3,y4,y5,y6,y7,y8,y9;
	public static boolean step = false;
	public static int stage;
	public float botOrder,topOrder;
	public Vector2 position;
	public Vector2 velocity;
	public Vector2 acceleration;
	
	public Control(float width,float height){
		btnWidth = width/5;
		btnHeight = height/4;
		wx = width - width/5;
		wy = height - height/4;
        
		gameWidth = width-Guy.btnWidth;
		gameHeight = height;
		botOrder = height - height/10 - Guy.btnHeight;
		topOrder = height/5;
		
		x1 = width - width/5;
		y1 = height - height/4;
		
		x2 = x1 + width/5/3;
		y2 = y1;
		
		x3 = x2 + width/5/3;
		y3 = y2;
		
		x4 = x1;
		y4 = y1 + height/4/3;
		
		x5 = x2;
		y5 = y4;
		
		x6 = x3;
		y6 = y4;
		
		x7 = x1;
		y7 = y4 + height/4/3;
		
		x8 = x2;
		y8 = y7;
		
		x9 = x3;
		y9 = y7;
		
		top = new Rectangle(x2, y2, width/5/3, height/4/3);
		topleft = new Rectangle(x1, y1, width/5/3, height/4/3);
		topright = new Rectangle(x3, y3, width/5/3, height/4/3);
		left = new Rectangle(x4, y4, width/5/3, height/4/3);
		right = new Rectangle(x6, y6, width/5/3, height/4/3);
		bot = new Rectangle(x8, y8, width/5/3, height/4/3);
		botleft = new Rectangle(x7, y7, width/5/3, height/4/3);
		botright = new Rectangle(x9, y9, width/5/3, height/4/3);
	}
	
	public void update(float delta){

		//Gdx.app.log("XY", "gx: " + SinglePlayRenderer.gx + " gy: " + SinglePlayRenderer.gy);
		if(step)
			{
				if(stage == 1)
					if(SinglePlayRenderer.gy > topOrder)
					{
						SinglePlayRenderer.gy -= 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
							SinglePlayRenderer.by -= 70 * Gdx.graphics.getDeltaTime();
					}
				if(stage == 2)
				{
					if(SinglePlayRenderer.gx > 0 && SinglePlayRenderer.gy > topOrder)
					{
						SinglePlayRenderer.gy -= 70 * Gdx.graphics.getDeltaTime();
						SinglePlayRenderer.gx -= 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
						{
							SinglePlayRenderer.by -= 70 * Gdx.graphics.getDeltaTime();
							SinglePlayRenderer.bx -= 70 * Gdx.graphics.getDeltaTime();
						}
					}
				}
				if(stage == 3){
					if(SinglePlayRenderer.gx < gameWidth && SinglePlayRenderer.gy > topOrder)
					{
						SinglePlayRenderer.gy -= 70 * Gdx.graphics.getDeltaTime();
						SinglePlayRenderer.gx += 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
						{
							SinglePlayRenderer.by -= 70 * Gdx.graphics.getDeltaTime();
							SinglePlayRenderer.bx += 70 * Gdx.graphics.getDeltaTime();
						}
					}
				}
				if(stage == 4)
					if(SinglePlayRenderer.gy < botOrder)
					{
						SinglePlayRenderer.gy += 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
							SinglePlayRenderer.by += 70 * Gdx.graphics.getDeltaTime();
					}
				if(stage == 5)
				{
					if(SinglePlayRenderer.gx > 0 && SinglePlayRenderer.gy < botOrder)
					{
						SinglePlayRenderer.gy += 70 * Gdx.graphics.getDeltaTime();
						SinglePlayRenderer.gx -= 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
						{
							SinglePlayRenderer.by += 70 * Gdx.graphics.getDeltaTime();
							SinglePlayRenderer.bx -= 70 * Gdx.graphics.getDeltaTime();
						}
					}
				}
				if(stage == 6)
				{
					if(SinglePlayRenderer.gx < gameWidth && SinglePlayRenderer.gy < botOrder)
					{
						SinglePlayRenderer.gy += 70 * Gdx.graphics.getDeltaTime();
						SinglePlayRenderer.gx += 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
						{
							SinglePlayRenderer.by += 70 * Gdx.graphics.getDeltaTime();
							SinglePlayRenderer.bx += 70 * Gdx.graphics.getDeltaTime();
						}
					}
				}
				if(stage == 7)
					if(SinglePlayRenderer.gx > 0)
					{
						SinglePlayRenderer.gx -= 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
						{
							SinglePlayRenderer.bx -= 70 * Gdx.graphics.getDeltaTime();
						}
					}
				if(stage == 8)
					if(SinglePlayRenderer.gx < gameWidth)
					{
						SinglePlayRenderer.gx += 70 * Gdx.graphics.getDeltaTime();
						
						if(!Fire.fire_bul)
						{
							SinglePlayRenderer.bx += 70 * Gdx.graphics.getDeltaTime();
						}
					}
			}
	}
	
	public void offClick(int touchX, int touchY){
		if(top.contains(touchX, touchY))
			step = false;
		if(topleft.contains(touchX, touchY))
			step = false;
		if(topright.contains(touchX, touchY))
			step = false;
		if(bot.contains(touchX, touchY))
			step = false;
		if(botleft.contains(touchX, touchY))
			step = false;
		if(botright.contains(touchX, touchY))
			step = false;
		if(left.contains(touchX, touchY))
			step = false;
		if(right.contains(touchX, touchY))
			step = false;
	}
	
	public void onClick(int touchX, int touchY){
			
			if(top.contains(touchX, touchY))
			{
				stage = 1;
				step = true;
			}
			if(topleft.contains(touchX, touchY))
			{
				stage = 2;
				step = true;
			}
			if(topright.contains(touchX, touchY))
			{
				stage = 3;
				step = true;
			}
			if(bot.contains(touchX, touchY))
			{
				stage = 4;
				step = true;
			}
			if(botleft.contains(touchX, touchY))
			{
				stage = 5;
				step = true;
			}
			if(botright.contains(touchX, touchY))
			{
				stage = 6;
				step = true;
			}
			if(left.contains(touchX, touchY))
			{
				stage = 7;
				step = true;
			}
			if(right.contains(touchX, touchY))
			{
				stage = 8;
				step = true;
			}
			
	}
}
