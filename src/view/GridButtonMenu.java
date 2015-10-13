package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import model.BoardModel;
import view.imageitem.BinImage;
import view.imageitem.ClearImage;
import view.imageitem.RobotImage;
import view.imageitem.SourceImage;

public class GridButtonMenu extends JPopupMenu {
	
	private JMenuItem item;
	private ImageIcon image;
	private int x,y;
	
	public GridButtonMenu(JButton button){
		
		ButtonCell currentButton = (ButtonCell) button;
		
		x = currentButton.getPositionX();
		y = currentButton.getPositionY();
		
		// add robot
		item = new JMenuItem("Add Robot");
		item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){	
				boolean isPath = BoardModel.getInstance().isPath(x, y);
				if(isPath){
					boolean Result = BoardModel.getInstance().setRobot(x, y);
					if(Result){
						BoardModel.getInstance().getOutputPanel().toConsole("Robot placed: ("+x+","+y+")");
						button.setIcon(new RobotImage().getImage());
					}else{
						BoardModel.getInstance().getOutputPanel().toConsole("Robot has been placed!");
					}
				}else{
					BoardModel.getInstance().getOutputPanel().toConsole("It is not a path!");
				}
			}		
		});
		this.add(item);
		
		// add source
		item = new JMenuItem("Add Source");
		item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				
				boolean isPath = BoardModel.getInstance().isPath(x, y);
				if(isPath){
					boolean Result = BoardModel.getInstance().setSource(x, y);
					if(Result){
						BoardModel.getInstance().getOutputPanel().toConsole("Source placed: ("+x+","+y+")");
						button.setIcon(new SourceImage().getImage());
					}else{
						BoardModel.getInstance().getOutputPanel().toConsole("Source has been placed!");
					}
				}else{
					BoardModel.getInstance().getOutputPanel().toConsole("It is not a path!");
				}
			}
		});
		this.add(item);

		// add destination
		item = new JMenuItem("Add Destination");
		item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean isPath = BoardModel.getInstance().isPath(x, y);
				if(isPath){
					boolean Result = BoardModel.getInstance().setDestination(x, y);
					if(Result){
						BoardModel.getInstance().getOutputPanel().toConsole("Destination placed: ("+x+","+y+")");
						button.setIcon(new BinImage().getImage());
					}else{
						BoardModel.getInstance().getOutputPanel().toConsole("Destination has been placed!");
					}
				}else{
					BoardModel.getInstance().getOutputPanel().toConsole("It is not a path!");
				}
			}
		});
		this.add(item);
		
//		remove object from path
		item = new JMenuItem("remove");
		item.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(!(button.getIcon() instanceof ClearImage)){
					// remove object, set the button as null
					BoardModel.getInstance().removeItem(x, y);
					image = new ClearImage().getImage();
					button.setIcon(image);
					BoardModel.getInstance().getOutputPanel().toConsole("Object removed!");
				}else			
					BoardModel.getInstance().getOutputPanel().toConsole("Error!");			
			}
		});
		this.add(item);
	}
	
}
