package com.devinhartzell.chess;

import java.io.IOException;
import java.util.Random;

public class ChessGame {
	
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
		new ChessGameWindow(this, white, black);
		System.out.println(white);
	}
	
	public static void main(String args[]) {
		new AskForName();
	}
}