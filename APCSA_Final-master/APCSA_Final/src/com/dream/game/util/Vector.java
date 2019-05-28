package com.dream.game.util;

public class Vector 
{
	public float x, y;
	public static float levelX, levelY;
	
	public Vector()
	{
		x = 0f;
		y = 0f;
	}
	
	public Vector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector(Vector vector)
	{
		this.x = vector.x;
		this.y = vector.y;
	}
	
	public void setVector(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	public static void setLevelVector(float x, float y)
	{
		levelX = x;
		levelY = y;
	}
}
