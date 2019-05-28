package com.dream.game.state;

import java.awt.Graphics2D;

import com.dream.game.gfx.Sprite;
import com.dream.game.object.*;
import com.dream.game.object.Object;
import com.dream.game.object.player.Player;
import com.dream.game.util.Vector;

public class GameState implements State
{
	private Object woman = new Player(new Vector(), new Sprite("ship.png"), 32, 32);
	
	public void update()
	{
		
	}

	public void render(Graphics2D g2)
	{
		g2.drawImage(woman.getSprite().getImage(), (int)woman.getPosition().x, (int)woman.getPosition().y, woman.getWidth(), woman.getHeight(), null);
	}

}
