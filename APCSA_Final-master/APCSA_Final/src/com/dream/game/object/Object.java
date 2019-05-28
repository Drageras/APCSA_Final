package com.dream.game.object;

import com.dream.game.gfx.Sprite;
import com.dream.game.util.Vector;

public abstract class Object 
{
	private Vector position;
	private Sprite sprite;
	private int width, height;
	
	public Object(Vector position, Sprite sprite, int width, int height)
	{
		this.position = position;
		this.sprite = sprite;
		this.width = width;
		this.height = height;
	}
	
	public Sprite getSprite()
	{
		return sprite;
	}
	
	public void setSprite(Sprite sprite) 
	{
		this.sprite = sprite;
	}
	
	public Vector getPosition()
	{
		return position;
	}

	public int getWidth() 
	{
		return width;
	}


	public int getHeight()
	{
		return height;
	}
}
