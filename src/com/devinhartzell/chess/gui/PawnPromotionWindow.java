package com.devinhartzell.chess.gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class PawnPromotionWindow extends JFrame {
	
	private static final long serialVersionUID = -1686304609750241736L;

	public PawnPromotionWindow() {
		super("Pawn Promotion");
		getContentPane().setLayout(null);
		
		JButton btnKnight = new JButton("Knight");
		btnKnight.setBounds(6, 6, 117, 29);
		getContentPane().add(btnKnight);
		
		JButton btnBishop = new JButton("Bishop");
		btnBishop.setBounds(6, 35, 117, 29);
		getContentPane().add(btnBishop);
		
		JButton btnRook = new JButton("Rook");
		btnRook.setBounds(6, 63, 117, 29);
		getContentPane().add(btnRook);
		
		JButton btnQueen = new JButton("Queen");
		btnQueen.setBounds(6, 92, 117, 29);
		getContentPane().add(btnQueen);
		
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
