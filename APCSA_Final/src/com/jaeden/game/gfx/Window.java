package com.jaeden.game.gfx;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.jaeden.game.util.Engine;

public class Window {
	private JFrame frame; // Game window
	private BufferStrategy bs;
	private Canvas canvas; // Image is render to
	private Graphics2D g; // Draw images
	
	public Window(Engine e) {
		frame = new JFrame(e.getTitle());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout()); // Maintains frame/canvas alignment
		frame.setSize(e.getWidth(), e.getHeight());
		
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		canvas = new Canvas();
		Dimension s = new Dimension(e.getWidth(), e.getHeight());
		canvas.setPreferredSize(s);
		canvas.setMaximumSize(s);
		canvas.setMinimumSize(s);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack(); // Set frame to canvas size
		
		canvas.createBufferStrategy(3);
		bs = canvas.getBufferStrategy();
	}

	public Graphics2D getGraphics2D()
	{
		return g;
	}
	
	public void setGraphics2D(Graphics g) 
	{
		this.g = (Graphics2D) g;
	}

	public BufferStrategy getBufferStrategy() 
	{
		return bs;
	}
	
	public JFrame getFrame()
	{
		return frame;
	}
}