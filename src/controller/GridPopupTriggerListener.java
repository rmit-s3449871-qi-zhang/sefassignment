package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import view.GridButtonMenu;


public class GridPopupTriggerListener extends MouseAdapter {
	
	private GridButtonMenu menu;
	
	public GridPopupTriggerListener(GridButtonMenu menu) {
		this.menu = menu;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		if(e.isPopupTrigger()){			
			this.menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.isPopupTrigger()){	
			this.menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.isPopupTrigger()){	
			this.menu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}
