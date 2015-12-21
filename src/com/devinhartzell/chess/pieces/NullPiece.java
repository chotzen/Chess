package com.devinhartzell.chess.pieces;

import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import com.devinhartzell.chess.board.Coordinate;

public class NullPiece extends ChessPiece {
	
	public NullPiece(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.type = '0';
		try {
			this.image = ImageIO.read(getClass().getResource("/resources/pieces/noPiece.png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Could not load placeholder image");
		}
	}

	@Override
	public List<Coordinate> getPossibleMoves() {
		return null;
	}

	@Override
	public boolean isNull() {
		return true;
	}
	

}
