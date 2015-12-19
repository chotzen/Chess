package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;

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
	public Board board;
	


	
	// K = x, V = y
	public abstract HashMap<Integer, Integer> getPossibleMoves();
	
	public boolean getColor()
	{
		return color;
	}
	
	public char getType()
	{
		return type;
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setPiece(ChessPiece piece)
	{
		this.piece = piece;
	}

}
