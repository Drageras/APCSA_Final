package com.dream.game.state;

import java.awt.Graphics2D;

public interface State
{
	public void update();
	public void render(Graphics2D g);
}
