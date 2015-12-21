package com.devinhartzell.chess.board;

import javax.swing.JPanel;

import com.devinhartzell.chess.ChessGameWindow;
import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.Pawn;

public class Board extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -396109385960336400L;
	
	private static Square[][] boardArray = new Square[9][9];
	
	/*
	 * False = white
	 * True = black
	 */
	public static boolean currentMove = false;
	
	public Board()
	{
		setSize(400, 400);
		setLayout(null);
		
		for (int i = 1; i <= 8; i++)
		{
			for (int j = 1; j <= 8; j++)
			{
				Square sq = new Square(i, j, !((i + j) % 2 == 0));
				getBoardArray()[i][j] = sq;
				this.add(sq);
			}
		}
		
		for (int i = 1; i<=8; i++)
		{
			new Pawn(i, 2, true);
			new Pawn(i, 7, false);
		}
	}
	
	public static ChessPiece getPieceAt(int x, int y)
	{
		if (getBoardArray()[x][y].hasPiece())
			return getBoardArray()[x][y].getPiece();
		else
			return null;
	}

	public static Square[][] getBoardArray() {
		return boardArray;
	}
	
	public static boolean getTurn()
	{
		return currentMove;
	}
	
	public static void setTurn(boolean b)
	{
		currentMove = b;
		ChessGameWindow.nextMove();
	}
}
