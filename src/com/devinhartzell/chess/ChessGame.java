package com.devinhartzell.chess;

import java.io.IOException;

import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.Pawn;

public class ChessGame {
	
	private int gameStatus;
	
	public String player1;
	public String player2;
	
	private boolean invertedColors = false;
	
	public ChessPiece board[][] = new ChessPiece[8][8];
	
	
	public ChessGame(boolean inverted, String player1, String player2) throws IOException
	{
		new ChessGameWindow(this);
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(inverted);
	}
	
	public static void main(String args[])
	{
		new AskForName();
	}
	

}