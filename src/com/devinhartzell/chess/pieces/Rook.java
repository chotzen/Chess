package com.devinhartzell.chess.pieces;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.ChessGame;
import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class Rook extends ChessPiece {
	
	private final String WHITE_PATH = "/resources/pieces/r_w.png";
	private final String BLACK_PATH = "/resources/pieces/r_b.png";
	
	public Rook(int x, int y, boolean color, Board board) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.type = 'p';
		this.board = board;
		try {
			if (color)
				this.image = ImageIO.read(getClass().getResource(BLACK_PATH));
			else
				this.image = ImageIO.read(getClass().getResource(WHITE_PATH));
			if (board.isMainBoard())
				ChessGame.getMainBoard().getBoardArray()[x][y].setPiece(this);
		}
		catch (Exception e) {
			System.out.println("Error: Could not load rook resource");
		}
	}
	
	@Override
	public ArrayList<Coordinate> getPossibleMoves() {
		ArrayList<Coordinate> movesList = new ArrayList<Coordinate>();
		
		// up
		for (int i = y+1; i <= 8; i++) {
			if (ChessGame.getMainBoard().getBoardArray()[x][i].hasPiece()) {
				if (this.color != ChessGame.getMainBoard().getBoardArray()[x][i].getPiece().getColor()) {
					movesList.add(new Coordinate(x, i));
				}
				break;
			} else {
				movesList.add(new Coordinate(x, i));
			}
		}
		
		//down
		for (int i = y-1; i >= 1; i--) {
			if (ChessGame.getMainBoard().getBoardArray()[x][i].hasPiece()) {
				if (this.color != ChessGame.getMainBoard().getBoardArray()[x][i].getPiece().getColor()) {
					movesList.add(new Coordinate(x, i));
				}
				break;
			} else {
				movesList.add(new Coordinate(x, i));
			}
		}
		
		
		//left
		for (int i = x+1; i <= 8; i++) {
			if (ChessGame.getMainBoard().getBoardArray()[i][y].hasPiece()) {
				if (this.color != ChessGame.getMainBoard().getBoardArray()[i][y].getPiece().getColor()) {
					movesList.add(new Coordinate(i, y));
				}
				break;
			} else {
				movesList.add(new Coordinate(i, y));
			}
		}
		
		//right
		for (int i = x-1; i >= 1; i--) {
			if (ChessGame.getMainBoard().getBoardArray()[i][y].hasPiece()) {
				if (this.color != ChessGame.getMainBoard().getBoardArray()[i][y].getPiece().getColor()) {
					movesList.add(new Coordinate(i, y));
				}
				break;
			} else {
				movesList.add(new Coordinate(i, y));
			}
		}
		return movesList;
	}
	
	public BufferedImage getImage() {
		return this.image;
	}

	@Override
	public boolean isNull() {
		return false;
	}
	
}