package com.devinhartzell.chess;

import java.io.IOException;
import java.util.Random;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.gui.AskForName;
import com.devinhartzell.chess.gui.ChessGameWindow;

public class ChessGame {
	
	private static ChessGameWindow cgw;
	private static Board mainBoard;
	
	public ChessGame(boolean randomized, String p1, String p2) 
			throws IOException {
		String white, black;
		if (randomized) {
			Random r = new Random();
			if (r.nextBoolean()) {
				white = p1;
				black = p2;
			} else {
				black = p1;
				white = p2;
		}} else {
			white = p1;
			black = p2;
		}
		cgw = new ChessGameWindow(this, white, black);
	}
	
	public static void main(String args[]) {
		new AskForName();
	}
	
	public static void endGame() {
		cgw.dispose();
		new AskForName();
	}
	
	public static void setMainBoard(Board board) {
		mainBoard = board;
	}
	
	public static Board getMainBoard() {
		return mainBoard;
		
	}
}