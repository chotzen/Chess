package com.devinhartzell.chess.gui;

import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.UIManager;

import com.devinhartzell.chess.ChessGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AskForName extends JFrame {

	private static final long serialVersionUID = -4474187669273802545L;
	
	private JTextField player1Enter;
	private JTextField player2Enter;
	
	private JCheckBox randomizeColors;
	private JLabel errorMsg;
	
	public AskForName() {
		getContentPane().setLayout(null);
		
		JLabel lblPlayer_1 = new JLabel("Player 1");
		lblPlayer_1.setBounds(6, 17, 61, 16);
		getContentPane().add(lblPlayer_1);
		
		JLabel lblPlayer_2 = new JLabel("Player 2");
		lblPlayer_2.setBounds(6, 44, 61, 16);
		getContentPane().add(lblPlayer_2);
		
		player1Enter = new JTextField();
		player1Enter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				player1Enter.setText(player1Enter.getText().replaceAll("Enter Name", ""));
			}
		});

		player1Enter.setText("Enter Name");
		player1Enter.setBounds(68, 11, 134, 28);
		getContentPane().add(player1Enter);
		player1Enter.setColumns(10);
		
		
		
		player2Enter = new JTextField();
		player2Enter.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				player2Enter.setText(player2Enter.getText().replaceAll("Enter Name", ""));
			}
		});
		player2Enter.setText("Enter Name");
		player2Enter.setColumns(10);
		player2Enter.setBounds(68, 38, 134, 28);
		getContentPane().add(player2Enter);
		
		randomizeColors = new JCheckBox("Randomize Colors");
		randomizeColors.setBounds(6, 66, 178, 23);
		getContentPane().add(randomizeColors);
		
		errorMsg = new JLabel("");
		errorMsg.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		errorMsg.setBounds(6, 96, 312, 16);
		getContentPane().add(errorMsg);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!player1Enter.getText().equals("Enter Name") 
						&& !player1Enter.getText().equals("") 
						&& !player2Enter.getText().equals("Enter Name") 
						&& !player2Enter.getText().equals("")) {
					try {
						new ChessGame(randomizeColors.isSelected(), 
								player1Enter.getText(), player2Enter.getText());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					closeWindow();
				} else {
					errorMsg.setText("You must input both names");
				}
			}
		});
		btnStart.setBounds(198, 143, 117, 29);
		getContentPane().add(btnStart);
		
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(341, 221);
		this.setVisible(true);
		
	}
	

	
	public void closeWindow() {
		this.dispose();
	}
	
	@PostConstruct
	public void createControls(Composite parent) {
		
	}
}