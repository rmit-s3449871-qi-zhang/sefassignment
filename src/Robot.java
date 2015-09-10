import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Robot extends JFrame implements MouseListener
{
	JPanel p = new JPanel();
	JButton[][] button;
//	private int count = 0;
//	private int sign = 0;
	
	public Robot()
	{
//		super("Robot");
		this.setSize(600,600);
		this.setResizable(false);
//		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		p.setLayout(new GridLayout(10,10));
		button = new JButton[10][10];
		for(int i = 0; i <10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				button[i][j] = new JButton();
				button[i][j].setBackground(Color.WHITE);
				p.add(button[i][j]);
				button[i][j].setEnabled(true);
				button[i][j].addMouseListener(this);
			}
		}
		this.add(p);
		this.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 10; j++)
			{
				if(button[i][j] == e.getSource())
				{
					if(SwingUtilities.isLeftMouseButton(e))
					{
						if(button[i][j].getBackground() == Color.WHITE)
						{
							button[i][j].setBackground(Color.BLACK);
						}
						else
						{
							button[i][j].setBackground(Color.WHITE);
						}
					}
					if(SwingUtilities.isRightMouseButton(e))
					{
						button[i][j].setBackground(Color.BLUE);
					}
				}
			}
		}
	}
	

	

	public static void main(String[] args)
	{
		new Robot();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
