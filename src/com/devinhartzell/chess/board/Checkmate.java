package com.devinhartzell.chess.board;

import com.devinhartzell.chess.pieces.King;

public class Checkmate implements Runnable {
	
	private King king;
	
	public Checkmate(King k) {
		this.king = k;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
