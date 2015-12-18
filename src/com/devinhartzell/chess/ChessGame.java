package com.devinhartzell.chess;

public class ChessGame {
	
	private int gameStatus;
	
	public String player1;
	public String player2;
	
	private boolean invertedColors = false;
	
	
	public ChessGame(boolean inverted, String player1, String player2)
	{
		//new ChessGameWindow(this);
		System.out.println(player1);
		System.out.println(player2);
		System.out.println(inverted);
	}
	
	public static void main(String args[])
	{
		//new ChessGame();
		
		new AskForName();
	}
	

}