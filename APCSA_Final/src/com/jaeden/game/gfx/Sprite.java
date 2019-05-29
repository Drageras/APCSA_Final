package com.jaeden.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite 
{
	private BufferedImage image;
	private int width, height;
	
	public Sprite(String path)
	{
		// Initialize sprite from path
		try 
		{
			image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(path));
			width = image.getWidth();
			height = image.getHeight();
			System.out.println("Successfully loaded " + path + "!");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("ERROR: Failed to load: " + path + "!");
			System.exit(-1);
		}
	}
	
	public Sprite(BufferedImage image) 
	{
		this.image = image;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}