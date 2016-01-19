package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.board.Coordinate;
import com.devinhartzell.chess.gui.ChessGameWindow;

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
	public int oldx, oldy;
	public BufferedImage image;
	
	// gets the moves from the piece's current position
	public abstract ArrayList<Coordinate> getPossibleMoves();
	// gets the theoretical moves for a piece if it were at (x, y);
	
	/*
	public ArrayList<Coordinate> getTheoreticalMoves(ChessPiece movedPiece, int new_x, int new_y) {
		Square.setDisabledGraphics(true);
		int old_x = this.x,
			old_y = this.y;
		ChessPiece capturedPiece = null;
		if (!ChessGame.getMainBoard().getBoardArray()[new_x][new_y].getPiece().isNull())
			capturedPiece = ChessGame.getMainBoard().getBoardArray()[new_x][new_y].getPiece();
		movedPiece.move(new_x, new_y);
		ArrayList<Coordinate> moves = getPossibleMoves();
		movedPiece.move(old_x, old_y);
		ChessGame.getMainBoard().getBoardArray()[new_x][new_y].setPiece(capturedPiece);
		Square.setDisabledGraphics(false);
		return moves;
	}
	*/
	
	public ArrayList<ChessPiece> getProtectors() {
		ArrayList<ChessPiece> protectors = new ArrayList<ChessPiece>();
		for (int m = 1; m <= 8; m++) {
			for (int n = 1; n <= 8; n++) {
				ChessPiece pe = ChessGame.getMainBoard().getBoardArray()[m][n].getPiece();
				if (pe.getType() != '0' && pe.getType() != 'k') {
					if (pe.getColor() == this.color) {
						if (pe != this) {
							for (Coordinate c : pe.getPossibleMoves()) {
								if (c.equals(new Coordinate(x,y))) {
									protectors.add(pe);
									break;
								}
							}
						}	
					}
				}
			}
		} return protectors;
	}
	
	public abstract boolean isNull();
	
	public boolean getColor() {
		return color;
	}
	
	public char getType() {
		return type;
	}

	public void move(int new_x, int new_y) {
		
		oldx = this.x;
		oldy = this.y;
		
		for (Coordinate s : ChessGame.getMainBoard().getBoardArray()[oldx][oldy].getPiece().getPossibleMoves())
			ChessGame.getMainBoard().getBoardArray()[s.getX()][s.getY()].setHighlighted(false);
		boolean cap;
		if (ChessGame.getMainBoard().getBoardArray()[new_x][new_y].getPiece().getType() == '0')
			cap = false;
		else
			cap = true;
			
		
		ChessGame.getMainBoard().getBoardArray()[oldx][oldy].setPiece(new NullPiece(this.x, this.y));
		ChessGame.getMainBoard().getBoardArray()[oldx][oldy].getPanel().setSelected(false);
		ChessGame.getMainBoard().getBoardArray()[new_x][new_y].setPiece(this);
		System.out.println(ChessGame.getMainBoard().getBoardArray()[new_x][new_y].getPiece().toString());
		
		this.x = new_x;
		this.y = new_y;
		
		ChessGame.getMainBoard().setTurn(!ChessGame.getMainBoard().getTurn());
		ChessGameWindow.addMove(this, cap);
		
		
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public void kill() {
		
		this.x = 0;
		this.y = 0;
	}
	
	public boolean checkIfNull()
	{
		return isNull;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getOldX() {
		return oldx;
	}
	
	public int getOldY() {
		return oldy;
	}
}
