package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

import model.BoardModel;
import view.Grid;
import view.imageitem.ClearImage;
import view.imageitem.PickedImage;
import view.imageitem.RobotImage;

public class CommandListener implements ActionListener{

	private JButton button;
	private Grid grid;
	
	private int robotPosition[];
	private int sourcePosition[];
	private int destinationPostion[];
	
	private int pos;
	
    public void setButton(JButton button){
    	this.button = button;
    }
    
   
    
    private void printPositions(){
    	this.robotPosition = BoardModel.getInstance().getRobotPosition();
    	this.sourcePosition = BoardModel.getInstance().getSourcePosition();
    	this.destinationPostion = BoardModel.getInstance().getDestinationPosition();
    	System.out.println("====================");
    	System.out.println("ROBOT: " + robotPosition[0] + ", " + robotPosition[1]);
    	System.out.println("SOURCE: " + sourcePosition[0] + ", " + sourcePosition[1]);
    	System.out.println("DESTINATION: " + destinationPostion[0] + ", " + destinationPostion[1]);
    	System.out.println("====================");
    }
    
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == button){
			System.out.println("BEGIN");
			// get current position of all elements
			printPositions();
			
			// extract commands from text field
			JTextField commandInput = BoardModel.getInstance().getInputArea();
			// split commands
			String commands[] = commandInput.getText().split(",");
			
			for(int i = 0; i < commands.length; i++){
				System.out.println(i + " " + commands[i]);
				if(commands[i].equalsIgnoreCase("p")){
					pos = i;
					boolean pickItem = BoardModel.getInstance().pickSource();
					
					if(pickItem){
						// Change image on icon
						BoardModel.getInstance().getGrid().getButtonCell(
								robotPosition[0],robotPosition[1]).setIcon(new PickedImage().getImage());
						System.out.println("Robot has picked the source");
					}else{
						System.out.println("Robot did not pick up anything");
					}
				}else if(commands[i].equalsIgnoreCase("d")){
					boolean dropItem = BoardModel.getInstance().dropSource();
					
					if(dropItem){
						// TODO: Change image on icon
						System.out.println("Robot has dropped source into destination");
						
					}else{
						System.out.println("Robot could not drop source");
					}
					
				}else if(commands[i].length() == 2){
					try {
						// validate each command direction
						int steps = Integer.parseInt(new StringBuilder().append(commands[i].charAt(0)).toString());
						char directionCommand = commands[i].toLowerCase().charAt(1);
						
						for(int step=0;step<steps;step++){
							switch(directionCommand){
								case 'n':
									if(BoardModel.getInstance().isPath(robotPosition[0], robotPosition[1]-1)){
										// remove robot image
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new ClearImage().getImage());
										BoardModel.getInstance().removeItem(robotPosition[0], robotPosition[1]);
										robotPosition[1]--;// move robot to south			
										BoardModel.getInstance().setRobot(robotPosition[0], robotPosition[1]);// set robot
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new RobotImage().getImage());
									}else{
										BoardModel.getInstance().getOutputPanel().toConsole("Robot could not move out of path");
									}
									break;
								case 's':
									if(BoardModel.getInstance().isPath(robotPosition[0], robotPosition[1]+1)){
										// remove robot image
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new ClearImage().getImage());
										BoardModel.getInstance().removeItem(robotPosition[0], robotPosition[1]);
										robotPosition[1]++;// move robot to south			
										BoardModel.getInstance().setRobot(robotPosition[0], robotPosition[1]);// set robot
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new RobotImage().getImage());
									}else{
										BoardModel.getInstance().getOutputPanel().toConsole("Robot could not move out of path");
									}
									break;
								case 'e':
									if(BoardModel.getInstance().isPath(robotPosition[0]+1, robotPosition[1])){
										// remove robot image
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new ClearImage().getImage());
										BoardModel.getInstance().removeItem(robotPosition[0], robotPosition[1]);
										robotPosition[0]++;// move robot to south			
										BoardModel.getInstance().setRobot(robotPosition[0], robotPosition[1]);// set robot
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new RobotImage().getImage());
									}else{
										BoardModel.getInstance().getOutputPanel().toConsole("Robot could not move out of path");
									}
									break;
								case 'w':
									if(BoardModel.getInstance().isPath(robotPosition[0]-1, robotPosition[1])){
										// remove robot image
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new ClearImage().getImage());
										BoardModel.getInstance().removeItem(robotPosition[0], robotPosition[1]);
										robotPosition[0]--;// move robot to south			
										BoardModel.getInstance().setRobot(robotPosition[0], robotPosition[1]);// set robot
										BoardModel.getInstance().getGrid().getButtonCell(robotPosition[0], robotPosition[1]).setIcon(new RobotImage().getImage());
									}else{
										BoardModel.getInstance().getOutputPanel().toConsole("Robot could not move out of path");
									}
									break;
								default:
									throw new Exception();
							}
							
							System.out.println("current robot: "+robotPosition[0]+","+robotPosition[1]);
							
						}
						
					} catch (NumberFormatException e1) {
						System.out.println("Invalid command " + commands[i]);
					} catch (Exception e2){
						System.out.println("Invalid command " + commands[i]);
					}
				}else{
					System.out.println("Invalid command");
				}
				printPositions();
				
				//reset robot, source, destination		
		}	
			// clear input text
			BoardModel.getInstance().clearInputArea();
			System.out.println("END");
			
			
		}
			
	}

}
 