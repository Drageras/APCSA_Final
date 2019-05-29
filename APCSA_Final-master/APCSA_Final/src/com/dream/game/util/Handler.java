package com.dream.game.util;

import java.util.ArrayList;
import java.util.List;

import com.dream.game.engine.Engine;
import com.dream.game.gameObject.GameObject;
import com.dream.game.state.State;

public class Handler implements Runnable
{
	private List<GameObject> objects;
	private Engine engine;
	private Thread thread;
	
	public Handler(Engine engine)
	{
		objects = new ArrayList<GameObject>();
		
	}
	
	public void update()
	{
		for(GameObject obj: objects)
		{
			obj.update();
		}
	}

	public void run()
	{
		while(true)
		{
			//update();
			//System.out.println("Running handler...");
		}
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
