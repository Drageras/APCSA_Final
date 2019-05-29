package com.dream.game.engine;

import com.dream.game.gfx.Window;
import com.dream.game.input.KeyManager;
import com.dream.game.util.Timer;
import com.dream.game.Game;

/*
 * This class creates the main game loop and creates another thread/ manages FPS
 * @author Jaeden Quintana, Aalishan Kazmi, ick or something, air
 * @version 0.0.1
 */

public class Engine implements Runnable
{
	// Fields
	private Thread thread;
	private Window window;
	private Game game;
	private KeyManager keyManager;
	private Timer timer = new Timer();
	private String title = "Mario Odyssey";
	private int width = 640, height = 480;
	private final int FPS = 60;
	private boolean running = false;
	
	// Methods
	public Engine(Game g)
	{
		game = g;
	}
	
	public synchronized void start()
	{
		if(!running)
		{
			running = true;
			thread = new Thread(this);
			thread.start();
		}
	}
	//@param ass
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
	
	private void init()
	{
		window = new Window(this);
		keyManager = new KeyManager(window);
		game.init(this);
		
		
	}
	
	public void run()
	{
		init();
		
		
		
		while(running) 
		{
			timer.time();
			// Get input
			keyManager.update();
				
			// Update game
			game.update();
				
			// RENDERER ----------------------
			// Create graphics object
			window.setGraphics2D(window.getBufferStrategy().getDrawGraphics());
			// Clear screen
			window.getGraphics2D().clearRect(0, 0, width, height);
			// Draw game
			game.render(window.getGraphics2D());
			// End drawing
			window.getBufferStrategy().show();
			window.getGraphics2D().dispose();
			// RENDERER END -----------------
		}
		
		// Merge threads
		stop();
	}

	public String getTitle() {
		return title;
	}

	public Window getWindow()
	{
		return window;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
