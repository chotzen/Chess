package com.devinhartzell.chess;

import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ChessGameWindow extends JFrame {
	
	public ChessGameWindow(ChessGame game)
	{
		getContentPane().setLayout(null);
		
		JPanel board = new JPanel();
		board.setBounds(6, 6, 400, 400);
		getContentPane().add(board);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(418, 39, 162, 367);
		getContentPane().add(textArea);
		
		JLabel lblRecentMoves = new JLabel("Recent Moves");
		lblRecentMoves.setBounds(418, 11, 86, 16);
		getContentPane().add(lblRecentMoves);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(579, 39, 15, 367);
		getContentPane().add(scrollBar);
		
		this.setVisible(true);
		
	}
	
	@PostConstruct
	public void createControls(Composite parent)
	{
		
	}
}
