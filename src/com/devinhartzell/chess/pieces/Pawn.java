package com.devinhartzell.chess.pieces;

import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;

public class Pawn extends ChessPiece {
	
	public Pawn(int x, int y, boolean color, Board board)
	{
		this.board = board;
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'p';
		try
		{
			if (color)
				this.image = ImageIO.read(getClass().getResource("/resources/pieces/p_b.jpg"));
			else
				this.image = ImageIO.read(getClass().getResource("/resources/pieces/p_w.jpg"));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public HashMap<Integer, Integer> getPossibleMoves() {
		HashMap<Integer, Integer> moves = new HashMap<Integer, Integer>();
		if (color)
		{
			if (y == 1)
				// TODO: Promotions
			if (y == 7)
			{
				moves.put(x, 5);
			}
			moves.put(x, y-1);
		}
		else 
		{
			if (y == 8)
				// TODO: Promotions
			if (y == 2)
			{
				moves.put(x, 4);
			}
			moves.put(x, y+1);
		}
		
		return moves;
	}
	
	public void move(int x, int y)
	{
		
	}

}
