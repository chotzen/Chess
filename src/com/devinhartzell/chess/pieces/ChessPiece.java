package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.List;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

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
	
	// K = x, V = y
	public abstract List<Coordinate> getPossibleMoves();
	
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
		
		Board.getBoardArray()[old_x][old_y].setPiece(new NullPiece(this.x, this.y));
		Board.getBoardArray()[old_x][old_y].setSelected(false);
		Board.getBoardArray()[new_x][new_y].setPiece(this);
		System.out.println(Board.getBoardArray()[new_x][new_y].getPiece().toString());
		
		
		this.x = new_x;
		this.y = new_y;
		//System.out.println(Board.getBoardArray()[x][y].toString());
		/*
		Board.getBoardArray()[this.x][this.y].setPiece(new NullPiece(this.x, this.y));
		Board.getBoardArray()[this.x][this.y].repaint();
		this.x = x;
		this.y = y;
		Board.getBoardArray()[x][y].setPiece(this);
		Board.getBoardArray()[x][y].repaint();
		*/
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
