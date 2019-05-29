package com.jaeden.game.state;

import java.util.ArrayList;
import java.util.List;

import com.jaeden.game.util.Engine;

public class StateManager
{
	private List<State> states;
	private State currentState;
	
	public StateManager(Engine engine) 
	{
		states = new ArrayList<State>();
		currentState = new GameState(engine);
	}

	public void update() 
	{
		if(!currentState.isRunning())
		{
			currentState.turnOn();
		}
	}
	
	public void switchState(State state)
	{
		if(state == currentState) return;
		
		currentState.turnOff();
		currentState = state;
	}
}