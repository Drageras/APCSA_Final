package com.jaeden.game.util;


public class Timer 
{
	private double timePerTick = 1e9 / 60; // Time a tick takes
	private double delta = 0; // Next time until update
	private long now; // Finding amount of time passed from now to lastTime
	private long lastTime = System.nanoTime();
	private long timer = 0; // Time until 1 sec
	private int ticks = 0; // Amount of ticks in 1 second (the FPS)
	
	public void time()
	{
		while(true)
		{
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick; // Change in time divided by time required of a tick
			timer += now - lastTime; // Change in time
			lastTime = now; 
		
			if(timer >= 1e9) // If a second has passed
			{
				// Reset counters
				System.out.println("FPS: " + ticks);
				ticks = 0;
				timer = 0;
			}
			
			if(delta > 1) // If time to update
			{ 
				ticks++;
				break;
			}
		}
	}
}