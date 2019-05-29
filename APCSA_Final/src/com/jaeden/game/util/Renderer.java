package com.jaeden.game.util;

import java.util.ArrayList;
import java.util.List;

import com.jaeden.game.gameObj.GameObject;

public class Renderer implements Runnable
{
	private List<GameObject> objects;
	private Engine engine;
	private Thread thread;
	public Renderer(Engine engine)
	{
		this.engine = engine;
		objects = new ArrayList<GameObject>();
	}
	
	
	public void run() 
	{
		while(true)
		{
			//render();
			//System.out.println("Running renderer...");
		}
		
	}

	public void render()
	{
		// RENDERER BEGIN ---------------
		// Create graphics object
		engine.getWindow().setGraphics2D(engine.getWindow().getBufferStrategy().getDrawGraphics());
		// Clear screen
		engine.getWindow().getGraphics2D().clearRect(0, 0, engine.getWidth(), engine.getHeight());
		// DRAW
		for(GameObject obj: objects)
		{
			obj.render(engine.getWindow().getGraphics2D());
		}
		// End drawing
		engine.getWindow().getBufferStrategy().show();
		engine.getWindow().getGraphics2D().dispose();
		// RENDERER END ------------------
		
		
	}
	
	public synchronized void start()
	{
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop()
	{
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}