package com.dream.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import com.dream.game.gfx.Window;

public class KeyManager implements KeyListener 
{
	private static List<Key> keys = new ArrayList<Key>();
	
	public Key up = new Key(keys);
	public Key down = new Key(keys);
	public Key left = new Key(keys);
	public Key right = new Key(keys);
	public Key attack = new Key(keys);
	
	public KeyManager(Window window) 
	{
		window.getFrame().addKeyListener(this);
	}
	
	public void releaseAll() 
	{
		for(Key key: keys) {key.setDown(false);}
	}
	
	public void update() 
	{
		for(Key key: keys) {key.update();}
	}
	
	public void toggle(KeyEvent e, boolean pressed) 
	{
		if(e.getKeyCode() == KeyEvent.VK_W) {up.toggle(pressed);}
		if(e.getKeyCode() == KeyEvent.VK_S) {down.toggle(pressed);}
		if(e.getKeyCode() == KeyEvent.VK_A) {left.toggle(pressed);}
		if(e.getKeyCode() == KeyEvent.VK_D) {right.toggle(pressed);}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {attack.toggle(pressed);}
		
	}
	
	public void keyPressed(KeyEvent e) 
	{
		toggle(e, true);
	}

	public void keyReleased(KeyEvent e)
	{
		toggle(e, false);
	}

	public void keyTyped(KeyEvent e) 
	{
		// Do nothing
	}
}
