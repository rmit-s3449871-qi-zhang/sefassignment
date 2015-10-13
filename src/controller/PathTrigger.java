package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

import model.BoardModel;
import view.ButtonCell;

public class PathTrigger extends MouseAdapter{
	
	private ButtonCell button;
	
	public PathTrigger(ButtonCell button) {
		this.button = button;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e)){
			if(this.button.getBackground() == Color.LIGHT_GRAY){
				// set the path color as white
				BoardModel.getInstance().setCellPath(
						this.button.getPositionX(), this.button.getPositionY());
				this.button.setBackground(Color.WHITE);
				BoardModel.getInstance().getOutputPanel().toConsole(
						"Path ("+button.getPositionX()+","+button.getPositionY()+") created!");
			}else if(this.button.getIcon() == null ){
				// erase the path
				BoardModel.getInstance().setCellPath(
						this.button.getPositionX(), this.button.getPositionY());
				this.button.setBackground(Color.LIGHT_GRAY);
				BoardModel.getInstance().getOutputPanel().toConsole(
						"Path ("+button.getPositionX()+","+button.getPositionY()+") erased!");
			}else
				BoardModel.getInstance().getOutputPanel().toConsole(
						"You should remove object before erase the path!");
		}
	}
}

