import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;

public class Robot extends JFrame implements MouseListener, KeyListener
{
	JPanel p = new JPanel();
	JButton[][] button;
	JMenuItem robot, source, destination;
	JPopupMenu popup;

	public Robot()
	{
		setSize(600,600);
		setResizable(false);
		setTitle("Robot Simulation");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		//Ensure that this application listens when the user click the mouse or press a key
		this.addMouseListener(this);
		this.addKeyListener(this);
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
				button[i][j].addMouseListener(this);
				button[i][j].addKeyListener(this);
			}
		}
		this.add(p);
		this.setVisible(true);
	}
	
	public void mouseClicked(MouseEvent e)
	{
		
		for(int i = 0; i < button.length; i++){
			for(int j = 0; j < button[i].length; j++){
				if(button[i][j] == e.getSource()){	
					if(SwingUtilities.isLeftMouseButton(e)){
						if(button[i][j].getBackground() == Color.WHITE){
							button[i][j].setBackground(Color.BLACK);
						}
						else{
							button[i][j].setBackground(Color.WHITE);
						}
					}
			
					if(SwingUtilities.isRightMouseButton(e)&&button[i][j].getBackground()!=Color.WHITE){
						
						button[i][j].setBackground(Color.RED);
					        
					}
				}
				
			}
		}
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		
	}
	public static void main(String[] args)
	{
		new Robot();
	}
	

	@Override
	public void mouseEntered(MouseEvent arg0) {

		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}

	

}
