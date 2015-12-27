package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;
import com.devinhartzell.chess.board.Square;

public abstract class ChessPiece {
	
	/*
	 * For type:
	 * p - pawn
	 * r - rook
	 * n - knight
	 * b - bishop
	 * q - queen
	 * k - king
	 * 0 - null
	 */
	public char type;
	
	/*
	 * true = white
	 * false = black
	 */
	public boolean color;
	public boolean isNull = false;
	public int x, y;
	public BufferedImage image;
	
	// gets the moves from the piece's current position
	public abstract ArrayList<Coordinate> getPossibleMoves();
	// gets the theoretical moves for a piece if it were at (x, y);
	
	public ArrayList<Coordinate> getTheoreticalMoves(ChessPiece movedPiece, int new_x, int new_y) {
		Square.setDisabledGraphics(true);
		int old_x = this.x,
			old_y = this.y;
		movedPiece.move(new_x, new_y);
		ArrayList<Coordinate> moves = getPossibleMoves();
		movedPiece.move(old_x, old_y);
		Square.setDisabledGraphics(false);
		return moves;
	}
	
	public abstract boolean isNull();
	
	public boolean getColor()
	{
		return color;
		
	}
	
	public char getType()
	{
		return type;
	}

	public void move(int new_x, int new_y)
	{
		
		int old_x = this.x;
		int old_y = this.y;
		
		for (Coordinate s : Board.getBoardArray()[old_x][old_y].getPiece().getPossibleMoves())
			Board.getBoardArray()[s.getX()][s.getY()].setHighlighted(false);
		
		Board.getBoardArray()[old_x][old_y].setPiece(new NullPiece(this.x, this.y));
		Board.getBoardArray()[old_x][old_y].setSelected(false);
		Board.getBoardArray()[new_x][new_y].setPiece(this);
		System.out.println(Board.getBoardArray()[new_x][new_y].getPiece().toString());
		
		this.x = new_x;
		this.y = new_y;
		
		Board.setTurn(!Board.getTurn());
		
		
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	
	public void kill()
	{
		
		this.x = 0;
		this.y = 0;
	}
	
	public boolean checkIfNull()
	{
		return isNull;
	}
	

}
