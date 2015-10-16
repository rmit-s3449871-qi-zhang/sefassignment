package view;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

import view.menupanel.MenuArea;
import model.BoardModel;

public class RobotFrame extends JFrame{
	
	Grid grid = new Grid();
	MenuArea textarea = new MenuArea();
	//CommandExecution ce = new CommandExecution();
	
	JPanel gridpanel = new JPanel(new BorderLayout());
	JPanel textpanel = new JPanel(new BorderLayout());
	
	public RobotFrame(){
	
	this.setTitle("Robot Simulation");	
	
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
	this.setLocationRelativeTo(null);
	this.setLayout(new BorderLayout());
	grid.setPreferredSize(new Dimension(400,400));
	textarea.setPreferredSize(new Dimension(200,200));
	
	this.add(grid, BorderLayout.CENTER);
	this.add(textarea, BorderLayout.LINE_END);
	
	BoardModel.getInstance().setMenuArea(textarea);
	BoardModel.getInstance().setGridArea(grid);

	this.pack();
	this.setVisible(true);
	}
		
	public static void main(String[] args){
		new RobotFrame();
	}
}
