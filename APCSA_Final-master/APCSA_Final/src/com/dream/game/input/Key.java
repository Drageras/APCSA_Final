package com.dream.game.input;

import java.util.List;

public class Key 
{
	private int presses, absorbs;
	private boolean down, clicked;
	
	public Key(List<Key> keys)
	{
		keys.add(this);
	}
	
	public void toggle(boolean pressed)
	{
		if(pressed != down) {down = pressed;}
		if (pressed) {presses++;}
	}
	
	public void update() 
	{
		if(absorbs < presses) {
			absorbs++;
			clicked = true;
		}else {clicked = false;}
	}

	public int getPresses() 
	{
		return presses;
	}

	public void setPresses(int presses) 
	{
		this.presses = presses;
	}

	public int getAbsorbs() 
	{
		return absorbs;
	}

	public void setAbsorbs(int absorbs) 
	{
		this.absorbs = absorbs;
	}

	public boolean isDown() 
	{
		return down;
	}

	public void setDown(boolean down) 
	{
		this.down = down;
	}

	public boolean isClicked() 
	{
		return clicked;
	}

	public void setClicked(boolean clicked) 
	{
		this.clicked = clicked;
	}
}
