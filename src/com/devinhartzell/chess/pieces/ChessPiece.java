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
	 */
	public char type;
	
	/*
	 * true = white
	 * false = black
	 */
	public boolean color;
	public int x, y;
	public ChessPiece piece;
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
	
	public void move(int x, int y){
		Board.getBoardArray()[this.x][this.y].setPiece(new NullPiece());
		this.x = x;
		this.y = y;
		
		Board.getBoardArray()[x][y].setPiece(this);
		
		
	}
	
	public void setPiece(ChessPiece piece)
	{
		this.piece = piece;
	}
	
	public BufferedImage getImage()
	{
		return image;
	}
	

}
