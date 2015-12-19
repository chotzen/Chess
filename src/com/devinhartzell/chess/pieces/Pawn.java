package com.devinhartzell.chess.pieces;

import java.util.ArrayList;
import java.util.HashMap;

public class Pawn extends ChessPiece {
	
	public Pawn(int x, int y, boolean color)
	{
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'p';
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

}
