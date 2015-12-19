package com.devinhartzell.chess.board;

import javax.swing.JPanel;

import com.devinhartzell.chess.pieces.ChessPiece;

import java.awt.Color;

public class Square extends JPanel {
	
	public ChessPiece piece;
	
	public Square(int x, int y, boolean black) {	
		if (black)
			setBackground(Color.DARK_GRAY);
		else
			setBackground(Color.WHITE);
		
		this.setLocation((50 * x) - 50 , (50 * y) - 50);
		
		setSize(50, 50);
	}
}