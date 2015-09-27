import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.SwingUtilities;


public class MouseClick {
	JButton[][] button;
	
	public void mouseClicked(MouseEvent e)
	{
		
		for(int i = 0; i < 10; i++){
			for(int j = 0; j < 10; j++){
				if(button[i][j] == e.getSource()){				
					if(SwingUtilities.isLeftMouseButton(e)){
						if(button[i][j].getBackground() == Color.WHITE){
							button[i][j].setBackground(Color.BLACK);
						}
						if(button[i][j].getBackground() == Color.BLACK){
							button[i][j].setBackground(Color.WHITE);
						}
					}
				}
				
			}
		}
	}
	

}
