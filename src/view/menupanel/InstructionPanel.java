package view.menupanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class InstructionPanel extends JPanel{	
//	private JPanel commandPanel;
	
	private TitledBorder border;
	private Border blackline;
	private EmptyBorder margin;
	
	public InstructionPanel(){
		this.blackline = BorderFactory.createLineBorder(Color.black);
		this.border = BorderFactory.createTitledBorder(blackline,"Command Instruction: ");
		this.border.setTitleFont(new Font("Arial", Font.BOLD,12));
		this.margin = new EmptyBorder(5,5,5,5);
		this.setBorder(new CompoundBorder(border, margin));
		this.add(new JLabel("(s)outh, "));
		this.add(new JLabel("(n)orth, "));
		this.add(new JLabel("(e)ast, "));
		this.add(new JLabel("(w)est, "));
		this.add(new JLabel("(p)ick. "));
		this.add(new JLabel("(d)rop"));
		this.add(new JLabel("Input example: "));
		this.add(new JLabel("2s,p,3n,1w,d"));
		this.add(new JLabel("Robot moves 2 steps to South,"));
		this.add(new JLabel("pick up source, "));
		this.add(new JLabel("..."));

		this.setPreferredSize(new Dimension(100,150));
		
	}

}
