package com.dream.game.gameObject.player;

import com.dream.game.gameObject.GameObject;
import com.dream.game.gfx.Sprite;
import com.dream.game.util.Vector;

public class Player extends GameObject
{
	
	public Player(Vector position, Sprite sprite, int width, int height) 
	{
		super(position, sprite, height, height);
	}
	
	
}
