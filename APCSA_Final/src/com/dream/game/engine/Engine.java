package com.dream.game.engine;

import com.dream.game.gfx.Window;
import com.dream.game.input.KeyManager;
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
	}
	
	public void run()
	{
		init();
		
		double timePerTick = 1e9 / FPS; // Time a tick takes
		double delta = 0; // Next time until update
		long now; // Finding amount of time passed from now to lastTime
		long lastTime = System.nanoTime();
		long timer = 0; // Time until 1 sec
		int ticks = 0; // Amount of ticks in 1 second (the FPS)
		
		while(running) 
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick; // Change in time divided by time required of a tick
			timer += now - lastTime; // Change in time
			lastTime = now; 
			
			if(delta > 1) // If time to update
			{ 
				ticks++; // Add to # of ticks in second
				delta--; // Resets delta
				
				// Get input
				keyManager.update();
				if(keyManager.up.isClicked())
					System.out.print("nig");
				if(keyManager.down.isClicked())
					System.out.print("ger.");
				
				// Update game
				game.update();
				
				// RENDERER ----------------------
				// Create graphics object
				window.setGraphics2D(window.getBufferStrategy().getDrawGraphics());
				// Clear screen
				window.getGraphics2D().clearRect(0, 0, width, height);
				// Draw game
				game.render();
				// End drawing
				window.getBufferStrategy().show();
				window.getGraphics2D().dispose();
				// RENDERER END ------------------
				
				
			}
			
			if(timer >= 1e9) // If a second has passed
			{
				// Reset counters
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		// Merge threads
		stop();
	}

	public String getTitle() {
		return title;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
