package com.devinhartzell.chess.board;

import javax.swing.JPanel;

import com.devinhartzell.chess.pieces.ChessPiece;

public class Board extends JPanel {
	
	private Square[][] squareArray = new Square[8][8];
	
	public Board()
	{
		setSize(400, 400);
		setLayout(null);
		
		for (int i = 1; i <= 8; i++)
		{
			for (int j = 1; j <= 8; j++)
			{
				Square sq = new Square(i, j, !((i + j) % 2 == 0));
				squareArray[i][j] = sq;
				this.add(sq);
			}
		}
	}
}
