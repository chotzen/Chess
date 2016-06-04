package com.devinhartzell.chess.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

import com.devinhartzell.chess.pieces.Bishop;
import com.devinhartzell.chess.pieces.Knight;
import com.devinhartzell.chess.pieces.Pawn;
import com.devinhartzell.chess.pieces.Queen;
import com.devinhartzell.chess.pieces.Rook;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PawnPromotionWindow extends JFrame {
	
	private static final long serialVersionUID = -1686304609750241736L;
	
	public Pawn piece;

	public PawnPromotionWindow(final Pawn piece) {
		super("Pawn Promotion");
		this.piece = piece;
		getContentPane().setLayout(null);
		
		JButton btnKnight = new JButton("Knight");
		btnKnight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				piece.getBoard().getBoardArray()[piece.getX()][piece.getY()].setPiece(
						new Knight(piece.getX(), piece.getY(), piece.getColor(), piece.getBoard()));
				ChessGameWindow.append("N");
				dispose();
				piece.getBoard().checkEndGame();
			}
		});
		btnKnight.setBounds(6, 6, 117, 29);
		
		getContentPane().add(btnKnight);
		
		JButton btnBishop = new JButton("Bishop");
		btnBishop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				piece.getBoard().getBoardArray()[piece.getX()][piece.getY()].setPiece(
						new Bishop(piece.getX(), piece.getY(), piece.getColor(), piece.getBoard()));
				ChessGameWindow.append("B");
				dispose();
				piece.getBoard().checkEndGame();
			}
		});
		btnBishop.setBounds(6, 35, 117, 29);
		getContentPane().add(btnBishop);
		
		JButton btnRook = new JButton("Rook");
		btnRook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				piece.getBoard().getBoardArray()[piece.getX()][piece.getY()].setPiece(
						new Rook(piece.getX(), piece.getY(), piece.getColor(), piece.getBoard()));
				ChessGameWindow.append("R");
				dispose();
				piece.getBoard().checkEndGame();
			}
		});
		btnRook.setBounds(6, 63, 117, 29);
		getContentPane().add(btnRook);
		
		JButton btnQueen = new JButton("Queen");
		btnQueen.setBounds(6, 92, 117, 29);
		getContentPane().add(btnQueen);
		btnQueen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				piece.getBoard().getBoardArray()[piece.getX()][piece.getY()].setPiece(
						new Queen(piece.getX(), piece.getY(), piece.getColor(), piece.getBoard()));
				ChessGameWindow.append("Q");
				dispose();
				piece.getBoard().checkEndGame();
			}
		});
		
		JTextArea info = new JTextArea();
		info.setOpaque(false);
		info.setLineWrap(true);
		info.setText("Since your pawn reached the far end of the board, you may upgrade it to a better piece.");
		info.setBounds(135, 11, 159, 67);
		getContentPane().add(info);
		setSize(315, 155);
		setVisible(true);
	}
}
