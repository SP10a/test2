package com.shgame.uiSingleplay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.shgame.shhelpers.AssetLoader;
import com.shgame.singleplay.SinglePlayRenderer;

public class Seal {

	// класс тюленя
	public float wWidth, wHeight;
	public float wx, wy;
	public static Rectangle bounds;
	public float gameWidth, gameHeight;
	public static boolean alive = true;
	public float i_height = 0 ;
	public static boolean flag_height = true;
	public static int hit_points = 26;
	
	public Seal(float width, float height){
		
		gameWidth = width;
		gameHeight = height;
		
	    wWidth = width/10;
	    wHeight = height/15;
	    //wHeight = AssetLoader.seal.getRegionHeight();
	    wx = 0 - wWidth;
	    wy = height/2;
	    
	    bounds = new Rectangle(wx, wy, 30, wHeight);
	}
	
	public void update(float delta){
		
		bounds.x = SinglePlayRenderer.sx;
		bounds.y = SinglePlayRenderer.sy;
		
		if(alive)
		{
			SinglePlayRenderer.sx += 40 * Gdx.graphics.getDeltaTime();;
			if(SinglePlayRenderer.sx > gameWidth)
				SinglePlayRenderer.sx = wx;
			
			// фрагмент волнистого движения тюленей
			
			/*
			if(flag_height)
			{
				i_height += 0.07;
				SinglePlayRenderer.sy += i_height;
				if(i_height > wHeight/40)
				{
					flag_height = false;
					i_height = 0;
				}
			}
			else
			{	
				i_height += 0.07;
				SinglePlayRenderer.sy -= i_height;
				if(i_height > wHeight/40)
				{
					flag_height = true;
					i_height = 0;
				}
			}		*/
		}
		
	}
}
