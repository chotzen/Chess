package com.devinhartzell.chess.board;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.gui.BoardPanel;
import com.devinhartzell.chess.gui.ChessGameWindow;
import com.devinhartzell.chess.gui.SquarePanel;
import com.devinhartzell.chess.pieces.Bishop;
import com.devinhartzell.chess.pieces.ChessPiece;
import com.devinhartzell.chess.pieces.King;
import com.devinhartzell.chess.pieces.Knight;
import com.devinhartzell.chess.pieces.Pawn;
import com.devinhartzell.chess.pieces.Queen;
import com.devinhartzell.chess.pieces.Rook;

public class Board /*extends JPanel*/ {
	
	
	
	/**
	 * 
	 */
	
	// Not using boardArray[0]
	private  Square[][] boardArray = new Square[9][9];
	private  King whiteKing;
	private  King blackKing;
	
	private BoardPanel boardPanel;
	
	private boolean check_w = false;
	private boolean check_b = false;
	
	private boolean mainBoard = false;
	
	/*
	 * False = white
	 * True = black
	 */
	public  boolean currentMove = false;
	
	public Board(boolean mainBoard) {
		
		this.mainBoard = mainBoard;
		

		
		for (int i = 1; i <= 8; i++) {
			for (int j = 1; j <= 8; j++) {
				Square sq = new Square(i, j, !((i + j) % 2 == 0), this);
				getBoardArray()[i][j] = sq;
			}
		}
		
		if (mainBoard) {
			ChessGame.setMainBoard(this);
			boardPanel = new BoardPanel();
			boardPanel.setLocation(6, 6);
			for (int i = 1; i <= 8; i++) {
				for (int j = 1; j<= 8; j++) {
					getBoardArray()[i][j].setPanel(boardPanel.getPanelArray()[i][j]);
				}
			}
		}
		
		
		if (mainBoard) {
		
			for (int i = 1; i<=8; i++) {
				new Pawn(i, 2, true);
				new Pawn(i, 7, false);
			}
			
			new Rook(1, 1, true);
			new Rook(8, 1, true);
			new Rook(1, 8, false);
			new Rook(8, 8, false);
			
			
			new Queen(4, 8, false);
			new Queen(4, 1, true);
			
			new Knight(2, 1, true);
			new Knight(7, 1, true);
			new Knight(2, 8, false);
			new Knight(7, 8, false);
			
			new Bishop(3, 1, true);
			new Bishop(6, 1, true);
			new Bishop(3, 8, false);
			new Bishop(6, 8, false);
			
			
			whiteKing = new King(5, 8, false);
			blackKing = new King(5, 1, true);
		}
	}
	
	public void duplicate(Board board) {
		for (int i = 1; i<=8; i++) {
			for (int j = 1; j<=8; j++) {
				getBoardArray()[i][j].setPiece(board.getBoardArray()[i][j].getPiece());
			}
		}
	}
	
	public  ChessPiece getPieceAt(int x, int y) {
		if (getBoardArray()[x][y].hasPiece())
			return getBoardArray()[x][y].getPiece();
		else
			return null;
	}

	public  Square[][] getBoardArray() {
		return boardArray;
	}
	
	public  boolean getTurn() {
		return currentMove;
	}
	
	public void setTurn(boolean b) {
		currentMove = b;
		ChessGameWindow.nextMove();
		
		if (!b) {
			if (whiteKing.getCheckMate()) {
				JOptionPane.showMessageDialog(null, "White is in CheckMate. Black wins!");
				ChessGame.endGame();
			}
				
			if (whiteKing.getCheck()) {
				JOptionPane.showMessageDialog(null, "White is now in Check!");
				check_w = true;
			} else
				check_w = false;
		} else {
			if (blackKing.getCheckMate()) {
				JOptionPane.showMessageDialog(null, "Black is in CheckMate. White wins!");
				ChessGame.endGame();
			}
			
			if (blackKing.getCheck()) {
				JOptionPane.showMessageDialog(null, "Black is now in Check!");
				check_b = true;
			} else
				check_b = false;
		}
	}
	
	public King getWKing() {
		return whiteKing;
	}
	
	public King getBKing() {
		return blackKing;
	}
	
	public boolean getCheck(boolean b) {
		if (b) 
			return check_b;
		else
			return check_w;
	}
	
	public void updatePanel() {
		if (mainBoard)
			BoardPanel.updateBoard();
	}
	
	public BoardPanel getBoardPanel() {
		return boardPanel;
	}

}