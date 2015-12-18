package com.devinhartzell.chess;

import java.awt.Composite;

import javax.annotation.PostConstruct;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;

public class AskForName extends JFrame {
	private JTextField player1Enter;
	private JTextField player2Enter;
	
	private JCheckBox randomizeColors;
	private JLabel errorMsg;
	
	public AskForName()
	{
		getContentPane().setLayout(null);
		
		JLabel lblPlayer_1 = new JLabel("Player 1");
		lblPlayer_1.setBounds(6, 6, 61, 16);
		getContentPane().add(lblPlayer_1);
		
		JLabel lblPlayer_2 = new JLabel("Player 2");
		lblPlayer_2.setBounds(6, 33, 61, 16);
		getContentPane().add(lblPlayer_2);
		
		player1Enter = new JTextField();
		player1Enter.setText("Enter Name");
		player1Enter.setBounds(68, 0, 134, 28);
		getContentPane().add(player1Enter);
		player1Enter.setColumns(10);
		
		player2Enter = new JTextField();
		player2Enter.setText("Enter Name");
		player2Enter.setColumns(10);
		player2Enter.setBounds(68, 27, 134, 28);
		getContentPane().add(player2Enter);
		
		randomizeColors = new JCheckBox("Randomize Colors");
		randomizeColors.setBounds(6, 55, 178, 23);
		getContentPane().add(randomizeColors);
		
		errorMsg = new JLabel("");
		errorMsg.setForeground(UIManager.getColor("InternalFrame.borderShadow"));
		errorMsg.setBounds(6, 90, 312, 16);
		getContentPane().add(errorMsg);
		
		JButton btnStart = new JButton("Start");
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!player1Enter.getText().equals("Enter Name") && !player2Enter.getText().equals("Enter Name"))
				{
					new ChessGame(randomizeColors.isSelected(), player1Enter.getText(), player2Enter.getText());
					getContentPane().setVisible(false);
				} else
				{
					errorMsg.setText("You must input both names");
				}
			}
		});
		btnStart.setBounds(201, 141, 117, 29);
		getContentPane().add(btnStart);
		
		
		
		this.setVisible(true);
		
	}
	
	@PostConstruct
	public void createControls(Composite parent)
	{
		
	}
}