package com.devinhartzell.chess.pieces;

import java.util.List;

import com.devinhartzell.chess.board.Coordinate;

public class NullPiece extends ChessPiece {

	@Override
	public List<Coordinate> getPossibleMoves() {
		return null;
	}

	@Override
	public boolean isNull() {
		return true;
	}
	

}
