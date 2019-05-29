package com.jaeden.game;

import java.awt.Graphics2D;

import com.jaeden.game.state.StateManager;
import com.jaeden.game.util.Engine;

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
	
	public static void main(String[] args)
	{
		Engine engine = new Engine(new Game());
		engine.start();
	}
}