package com.dream.game;

import java.awt.Color;
import java.awt.Graphics2D;

import com.dream.game.gfx.Sprite;
import com.dream.game.state.StateManager;

public class Game 
{
	private StateManager stateManager;
	private Sprite s = new Sprite("ship.png");
	
	public Game()
	{
		stateManager = new StateManager();
	}
	
	public void update() 
	{
		stateManager.update();
	}
	public void render(Graphics2D g)
	{
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 1000);
		g.drawImage(s.getImage(), 0, 0, s.getWidth(), s.getHeight(), null);
		stateManager.render(g);
	}
}
