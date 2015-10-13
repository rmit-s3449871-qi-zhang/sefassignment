package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import model.BoardConstants;
import view.imageitem.ClearImage;
import controller.GridPopupTriggerListener;
import controller.PathTrigger;


public class Grid extends JPanel{

	private ButtonCell[][] buttonCells = 
			new ButtonCell[BoardConstants.BOARD_SIZE_VERTICAL]
					[BoardConstants.BOARD_SIZE_HORIZONTAL];
	private GridButtonMenu menu;
	
	public Grid(){

		this.setLayout(new GridLayout(BoardConstants.BOARD_SIZE_VERTICAL,
				BoardConstants.BOARD_SIZE_HORIZONTAL));
		for(int i=0;i < buttonCells.length;i++){
			for(int j=0; j < buttonCells[i].length;j++){

				buttonCells[j][i] = new ButtonCell(j, i);
				// set the background color as light gray
				buttonCells[j][i].setBackground(Color.LIGHT_GRAY);
				buttonCells[j][i].setIcon(new ClearImage().getImage());
				// add left click mouse event
				buttonCells[j][i].addMouseListener(new PathTrigger(buttonCells[j][i]));
				// add right click mouse event
				menu = new GridButtonMenu(buttonCells[j][i]);
				buttonCells[j][i].addMouseListener(new GridPopupTriggerListener(menu));
				this.add(buttonCells[j][i]);
			}
		}
	
	}
	
	public ButtonCell getButtonCell(int posX, int posY){
		if((0 <= posX) && (posX < BoardConstants.BOARD_SIZE_VERTICAL) &&
		   (0 <= posY) && (posY < BoardConstants.BOARD_SIZE_HORIZONTAL)){
			return this.buttonCells[posX][posY];
		}
		return null;
	}

}
