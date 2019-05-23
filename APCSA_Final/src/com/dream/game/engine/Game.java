package com.dream.game.engine;

/*
 * This class creates the main game loop and creates another thread/ manages FPS
 * @author Jaeden Quintana, Aalishan Kazmi, ick or something, air
 * @version 0.0.1
 */

public class Game implements Runnable
{
	// Fields
	private Thread thread;
	private boolean running;
	
	// Methods
	public synchronized void start()
	{
		if(!running)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	
	public synchronized void stop()
	{
		if(running)
		{
			running = false;
			try 
			{
				thread.join();
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}
	
	
	@Override
	public void run() {
		init();
		
		while(running) {
			System.out.println("T_SERIERS");
		}
		
		stop();
		
	}

	private void init() {
		
	}

}
