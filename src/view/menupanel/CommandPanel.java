package view.menupanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.CommandListener;

public class CommandPanel extends JPanel{
	
	private TitledBorder border;
	private Border blackline;
	private EmptyBorder margin;
	
	private JTextField input;
	private CommandListener cl;
	private JButton button;

	public CommandPanel(){
		this.blackline = BorderFactory.createLineBorder(Color.BLACK);
        this.border = BorderFactory.createTitledBorder(blackline, "Enter Commands:");
        this.border.setTitleFont(new Font("Arial", Font.BOLD, 12));
        this.margin = new EmptyBorder(5, 5, 5, 5);
        this.setBorder(new CompoundBorder(border, margin));
        
        this.input = new JTextField();
        input.setPreferredSize(new Dimension(100,30));
        
        this.button = new JButton("Run"); // click button to program
        // add click button event
        cl = new CommandListener();
 		cl.setButton(button);
 		button.addActionListener(cl);
 		
        button.setFont(new Font("Arial", Font.BOLD, 11));
        
        this.add(input, BorderLayout.CENTER);
        this.add(button, BorderLayout.EAST);

	}
	
	public JButton getButton(){
		return this.button;
	}
	
	// clear the text field
	public void clearInputText(){
		input.setText("");
	}
	
	public void updateInput(String command){
		input.setText(command);
	}

	public JTextField getInputArea() {
		return input;
	}
}
