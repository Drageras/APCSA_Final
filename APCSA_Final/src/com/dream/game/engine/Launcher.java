package com.dream.game.engine;

import com.dream.game.Game;

public class Launcher
{
	public static void main(String[] args)
	{
		Engine game = new Engine(new Game());
		game.start();
	}
}
