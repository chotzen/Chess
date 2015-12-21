package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class Pawn extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/p_w.png";
	private final String BLACK_PATH = "/resources/pieces/p_b.png";
	
	public Pawn(int x, int y, boolean color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'p';
		try
		{
			if (color)
				this.image = ImageIO.read(getClass().getResource(BLACK_PATH));
			else
				this.image = ImageIO.read(getClass().getResource(WHITE_PATH));
			
			Board.getBoardArray()[x][y].setPiece(this);
		}
		catch (Exception e)
		{
			System.out.println("Error: Could not load pawn resource");
		}
	}
	
	@Override
	public List<Coordinate> getPossibleMoves() {
		List<Coordinate> movesList = new ArrayList<Coordinate>();
		if (color)
		{
		
			if (y == 2)
				if (!Board.getBoardArray()[x][4].hasPiece() && !Board.getBoardArray()[x][3].hasPiece())
					movesList.add(new Coordinate(x, 4));
			
			if (!Board.getBoardArray()[x][y+1].hasPiece())
				movesList.add(new Coordinate(x, y+1));
			
			if (x+1 <= 8)
				if (Board.getBoardArray()[x+1][y+1].hasPiece())
					movesList.add(new Coordinate(x+1, y+1));
			
			if (x-1 >= 1)
				if (Board.getBoardArray()[x-1][y+1].hasPiece())
					movesList.add(new Coordinate(x-1, y+1));
				
		}
		else 
		{
			if (y == 7)
				if (!Board.getBoardArray()[x][5].hasPiece() && !Board.getBoardArray()[x][6].hasPiece())
					movesList.add(new Coordinate(x, 5));

			if (!Board.getBoardArray()[x][y-1].hasPiece())
				movesList.add(new Coordinate(x, y-1));
			
			if (x+1 <= 8)
				if (Board.getBoardArray()[x+1][y-1].hasPiece())
					movesList.add(new Coordinate(x+1, y-1));
			
			if (x-1 >= 1)
				if (Board.getBoardArray()[x-1][y-1].hasPiece())
					movesList.add(new Coordinate(x-1, y-1));
		}
		return movesList;
	}
	

	
	
	public BufferedImage getImage()
	{
		return this.image;
	}

	@Override
	public boolean isNull() {
		return false;
	}

}
