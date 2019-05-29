package com.jaeden.game.gameObj;

import java.awt.Graphics2D;

import com.jaeden.game.gfx.Sprite;
import com.jaeden.game.util.Vector;

public abstract class GameObject 
{
	private Vector position;
	private Sprite sprite;
	private int width, height;
	
	public GameObject(Vector position, Sprite sprite, int width, int height)
	{
		this.position = position;
		this.sprite = sprite;
		this.width = width;
		this.height = height;
	}
	
	public void update()
	{
		
	}
	
	public void render(Graphics2D g2)
	{
		
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