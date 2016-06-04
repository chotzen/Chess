package com.devinhartzell.chess.pieces;

import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Board;
import com.devinhartzell.chess.board.Coordinate;

public class NullPiece extends ChessPiece {
	public NullPiece(int x, int y, Board board) {
		this.x = x;
		this.y = y;
		this.type = '0';
		this.board = board;
		try {
			this.image = ImageIO.read(getClass().getResource("/resources/pieces/noPiece.png"));
		} catch (IOException e) {
			System.out.println("Could not load placeholder image");
		}
	}

	@Override
	public ArrayList<Coordinate> getPossibleMoves() {
		return null;
	}

	@Override
	public boolean isNull() {
		return true;
	}
	
	@Override
	public char getType() {
		return '0';
	}
	
	public void move(int new_x, int new_y) {}

}
