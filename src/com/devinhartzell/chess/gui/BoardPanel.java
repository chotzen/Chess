package com.devinhartzell.chess.gui;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.board.Board;

public class BoardPanel extends JPanel {
	
	private static final long serialVersionUID = 3797457269503993519L;
	
	private static SquarePanel[][] panelArray = new SquarePanel[9][9];
	
	public BoardPanel() {
		setSize(400, 400);
		setLayout(null);
		for (int i = 1; i<=8; i++) {
			for (int j = 1; j<=8; j++) {
				panelArray[i][j] = new SquarePanel(i, j, !((i + j) % 2 == 0));
				add(panelArray[i][j]);
				panelArray[i][j].setLocation((i-1)*50, (j-1)*50);
			}
		}	
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				for (int i = 1; i<=8; i++) {
					for (int j = 1; j<=8; j++) {
						panelArray[i][j].repaint();
						panelArray[i][j].revalidate();
					}
				}
				
			}
		}, 1000, 200);
	}
	
	public static void updateBoard() {
		updateBoard(ChessGame.getMainBoard());
	}
	
	public static void updateBoard(Board b) {
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j<= 8; i++) {
				panelArray[i][j].updatePiece(panelArray[i][j].getSquare().getPiece());
			}
		}
	}
	
	public SquarePanel[][] getPanelArray() {
		return panelArray;
	}
}