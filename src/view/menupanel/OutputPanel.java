package view.menupanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;

public class OutputPanel extends JPanel{	
	
	private TitledBorder border;
	private Border blackline;
	private EmptyBorder margin;
	
	private JTextArea Output;
	private JScrollPane scrollPane;
	
	private final static String newline = "\n";
	
	public OutputPanel(){
		this.blackline = BorderFactory.createLineBorder(Color.BLACK);
		this.border = BorderFactory.createTitledBorder(blackline,"Output");
		this.border.setTitleFont(new Font("Arial", Font.BOLD, 12));
		this.margin = new EmptyBorder(5,5,5,5);
		this.setBorder(new CompoundBorder(border, margin));
		
		this.setLayout(new BorderLayout());
		
		this.Output = new JTextArea();
		this.Output.setEditable(false);
		this.Output.setLineWrap(true);
		this.Output.setWrapStyleWord(true);
		this.Output.setFont(new Font("Arial", Font.PLAIN, 12));
		
		this.scrollPane = new JScrollPane();
		this.scrollPane.setPreferredSize(new Dimension(100,150));;
		this.scrollPane.setViewportView(this.Output);
		
		DefaultCaret caret = (DefaultCaret) Output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		this.add(scrollPane);
	}
	
	public void toConsole(String string){
		this.Output.append(string + newline);
	}
	
	public void clearText(){
		this.Output.setText("");
	}

}
