
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

public class Board extends JFrame
{
	JPanel p = new JPanel();
	JButton[][] button;
	JMenuItem robot, source, destination;
	JPopupMenu popup;

	public Board()
	{
		setSize(600,600);
		setResizable(false);
		setTitle("Robot Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//Ensure that this application listens when the user click the mouse or press a key
		p.setLayout(new GridLayout(10,10));
		button = new JButton[10][10];
		for(int i = 0; i <button.length; i++)
		{
			for(int j = 0; j < button[i].length; j++)
			{
				button[i][j] = new JButton();
				button[i][j].setBackground(Color.WHITE);
				p.add(button[i][j]);
				button[i][j].setEnabled(true);
			}
		}
		this.add(p);
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new Board();
	}

}
