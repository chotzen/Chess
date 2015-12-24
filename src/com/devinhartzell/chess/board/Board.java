package com.devinhartzell.chess.board;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.devinhartzell.chess.ChessGameWindow;
import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.King;
import com.devinhartzell.chess.pieces.Pawn;
import com.devinhartzell.chess.pieces.Rook;

public class Board extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -396109385960336400L;
	
	// Not using boardArray[0]
	private static Square[][] boardArray = new Square[9][9];
	private static King whiteKing;
	private static King blackKing;
	
	private boolean check_w = false;
	private boolean check_b = false;
	
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
		
		new Rook(1, 1, true);
		new Rook(8, 1, true);
		new Rook(1, 8, false);
		new Rook(8, 8, false);
		
		whiteKing = new King(5, 8, false);
		blackKing = new King(5, 1, true);
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
	
	public static boolean getTurn() {
		return currentMove;
	}
	
	public static void setTurn(boolean b) {
		currentMove = b;
		ChessGameWindow.nextMove();
		
		//white
		if (b) 
			if (whiteKing.getCheck())
				JOptionPane.showMessageDialog(null, "White is now in Check!");
		else 
			if (blackKing.getCheck())
				JOptionPane.showMessageDialog(null, "Black is now in Check!");
		
	}
	
	public static King getWKing() {
		return Board.whiteKing;
	}
	
	public static King getBKing() {
		return Board.blackKing;
	}

}