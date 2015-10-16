package view;

import javax.swing.JButton;

public class ButtonCell extends JButton {
	
	private int positionX;
	private int positionY;
	
	public ButtonCell(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
	

}
