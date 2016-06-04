package com.devinhartzell.chess.board;

import com.devinhartzell.chess.pieces.ChessPiece;

public class MoveChecker implements Runnable {
	
	public ChessPiece piece;
	
	public boolean running = false;
	public boolean endsCheckmate = false;
	
	public MoveChecker(ChessPiece piece) {
		this.piece = piece;
	}

	@Override
	public void run() {
		running = true;
		for (Coordinate c : piece.getPossibleMoves()) {
			Board testboard = new Board(piece.getBoard());
			testboard.getBoardArray()[piece.getX()][piece.getY()].getPiece().move(c.getX(), c.getY());
			if (!piece.getColor()) {
				if (!testboard.getWKing().getCheck())
					endsCheckmate = true;
			} else {
				if (!testboard.getBKing().getCheck())
					endsCheckmate = true;
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		running = false;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public boolean endsCheckmate() {
		return endsCheckmate;
	}

}
