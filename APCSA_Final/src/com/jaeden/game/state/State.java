package com.jaeden.game.state;

import com.jaeden.game.util.Engine;
import com.jaeden.game.util.Handler;
import com.jaeden.game.util.Renderer;

public abstract class State
{
	protected Handler handler;
	protected Renderer renderer;
	public boolean running;
	
	public State(Engine engine)
	{
		handler = new Handler(engine);
		renderer = new Renderer(engine);
	}
	
	public boolean isRunning()
	{
		return running;
	}

	public void turnOn() 
	{
		running = true;
		handler.start();
		renderer.start();
	}
	
	public void turnOff()
	{
		handler.stop();
		renderer.stop();
	}
}