package com.dream.game.state;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;


public class StateManager implements State
{
	private List<State> states;
	
	public StateManager() 
	{
		states = new ArrayList<State>();
		
	}

	public void update() 
	{
		for(State state: states) 
		{
			state.update();
			
		}
	}

	public void render(Graphics2D g)
	{
		for(State state: states)
		{
			state.render(g);
		}
	}
}
