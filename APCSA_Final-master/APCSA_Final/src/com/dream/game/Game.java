package com.dream.game;

import java.awt.Graphics2D;
import com.dream.game.engine.Engine;
import com.dream.game.state.StateManager;

public class Game 
{
	private StateManager stateManager;
	
	public Game()
	{
	}
	
	public void init(Engine engine)
	{
		stateManager = new StateManager(engine);
	}
	
	public void update() 
	{
		stateManager.update();
	}
	
	public void render(Graphics2D g)
	{
		
	}
}
