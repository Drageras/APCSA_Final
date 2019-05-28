package com.dream.game.gfx;

public class SpriteSheet 
{
	private Sprite spriteSheet;
	private Sprite[][] spriteArray;
	private int cellSize;
	private int  horizontalCells, verticalCells;
	
	public SpriteSheet(Sprite sprite, int cellSize, int horizontalCells, int verticalCells)
	{
		spriteSheet = sprite;
		this.horizontalCells = horizontalCells;
		this.verticalCells = verticalCells;
		this.cellSize = cellSize;
		loadSpriteArray();
	}
	
	public void loadSpriteArray()
	{
		spriteArray = new Sprite[horizontalCells][verticalCells];
		
		for(int row = 0; row < horizontalCells; ++row)
		{
			for(int col = 0; col < verticalCells; ++col)
			{
				spriteArray[row][col] = new Sprite(spriteSheet.getImage().getSubimage(row * cellSize, col * cellSize, cellSize, cellSize));
			}
		}
	}
}
