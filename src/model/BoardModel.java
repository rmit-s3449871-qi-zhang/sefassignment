package model;

import javax.swing.JTextField;

import view.Grid;
import view.menupanel.MenuArea;
import view.menupanel.OutputPanel;

public class BoardModel {
	private static BoardModel instance = null;
	private CellPathInfo board[][];
	private MenuArea menuArea;
	private boolean sourcePicked;
	
	private int robotPositionX;
	private int robotPositionY;
	
	private int sourcePositionX;
	private int sourcePositionY;
	
	private int destinationPositionX;
	private int destinationPositionY;
	
	private Grid grid;
	
	private BoardModel() {
		this.sourcePicked = false;
		
		this.board = 
				new CellPathInfo[BoardConstants.BOARD_SIZE_VERTICAL]
						[BoardConstants.BOARD_SIZE_HORIZONTAL];
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				this.board[i][j] = new CellPathInfo();
			}
		}
		
		this.robotPositionX = BoardConstants.INVALID_POSITION;
		this.robotPositionY = BoardConstants.INVALID_POSITION;
		
		this.sourcePositionX = BoardConstants.INVALID_POSITION;
		this.sourcePositionY = BoardConstants.INVALID_POSITION;
		
		this.destinationPositionX = BoardConstants.INVALID_POSITION;
		this.destinationPositionY = BoardConstants.INVALID_POSITION;
		
	}
	
	public static BoardModel getInstance(){
		if(instance == null){
			instance = new BoardModel();
		}	
		return instance;
	}
	
	// set path
	public void setCellPath(int xPos, int yPos){
		if((0 <= xPos && xPos < BoardConstants.BOARD_SIZE_VERTICAL) 
		   && (0 <= yPos && yPos < BoardConstants.BOARD_SIZE_HORIZONTAL)){
			if(this.board[xPos][yPos].isPath()){
				this.board[xPos][yPos].setPath(false);
			}else{
				this.board[xPos][yPos].setPath(true);
			}	
		}
	}
	
	// get input
	public JTextField getInputArea() {
		return this.menuArea.getCommandPanel().getInputArea();
	}
	// get output
	public OutputPanel getOutputPanel(){
		return this.menuArea.getOutputPanel();
	}
	// clear input
	public void clearInputArea(){
		this.menuArea.getCommandPanel().clearInputText();
	}

	public void setMenuArea(MenuArea menuArea) {
		this.menuArea = menuArea;
	}
	
	
	public boolean setRobot(int x, int y){
		if(this.robotPositionX == x && this.robotPositionY == y){	
			return true;
		}else if(this.robotPositionX == BoardConstants.INVALID_POSITION &&
		   this.robotPositionY == BoardConstants.INVALID_POSITION){
			// set the robot on grid
			this.robotPositionX = x;
			this.robotPositionY = y;
			
			return true;
		}else if(x == BoardConstants.INVALID_POSITION && y == BoardConstants.INVALID_POSITION){
			this.robotPositionX = x;
			this.robotPositionY = y;
			
			return true;
		}
		// only allow one robot on the grid
		return false;
	}
	
	public void clearRobot(){
		this.robotPositionX = BoardConstants.INVALID_POSITION;
		this.robotPositionY = BoardConstants.INVALID_POSITION;
	}
	
	public boolean setSource(int x, int y){
		// set the source on grid
		if(this.sourcePositionX == x && this.sourcePositionY == y){
			return true;
		}else if(this.sourcePositionX == BoardConstants.INVALID_POSITION &&
				this.sourcePositionY == BoardConstants.INVALID_POSITION){
			this.sourcePositionX = x;
			this.sourcePositionY = y;
			
			return true;
		}else if(x == BoardConstants.INVALID_POSITION && y == BoardConstants.INVALID_POSITION){
			this.sourcePositionX = x;
			this.sourcePositionY = y;
			
			return true;
		}
		// only allow one source on the grid
		return false;
	}
	
	public boolean setDestination(int x, int y){
		if(this.destinationPositionX == x && this.destinationPositionY == y){
			return true;
		}else if(this.destinationPositionX == BoardConstants.INVALID_POSITION &&
				this.destinationPositionY == BoardConstants.INVALID_POSITION){
			this.destinationPositionX = x;
			this.destinationPositionY = y;
			
			return true;
		}else if(x == BoardConstants.INVALID_POSITION && y == BoardConstants.INVALID_POSITION){
			this.destinationPositionX = x;
			this.destinationPositionY = y;
			
			return true;
		}
		// only allow one destination on the grid
		return false;
	}
	
	// get location of the robot
	public int[] getRobotPosition(){
		int robotPosition[] = new int[2];
		
		robotPosition[0] = this.robotPositionX;
		robotPosition[1] = this.robotPositionY;
		
		return robotPosition;
	}
	
	// get location of the source
	public int[] getSourcePosition(){
		int sourcePosition[] = new int[2];
		
		sourcePosition[0] = this.sourcePositionX;
		sourcePosition[1] = this.sourcePositionY;
		
		return sourcePosition;
	}
	
	//get location of the destination
	public int[] getDestinationPosition(){
		int destinationPosition[] = new int[2];
		
		destinationPosition[0] = this.destinationPositionX;
		destinationPosition[1] = this.destinationPositionY;
		
		return destinationPosition;
	}
	
	public boolean isPath(int xPos, int yPos){		
		if((0 <= xPos && xPos < BoardConstants.BOARD_SIZE_VERTICAL) 
		   && (0 <= yPos && yPos < BoardConstants.BOARD_SIZE_HORIZONTAL)){				
			return this.board[xPos][yPos].isPath();
		}		
		return false;
	}
	
	public boolean setPosition(int posX, int posY){
		boolean isAtDestination = false;
		if((0 <= posX && posX < BoardConstants.BOARD_SIZE_VERTICAL) &&
		   (0 <= posY && posY < BoardConstants.BOARD_SIZE_HORIZONTAL) &&
		   this.board[posX][posY].isPath()){
			
		}
		
		return isAtDestination;
	}

	public void setGridArea(Grid grid) {
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}
	
	public boolean pickSource(){
		boolean result = false;
		if(this.robotPositionX == this.sourcePositionX &&
			this.robotPositionY == this.sourcePositionY){
			
			this.sourcePicked = true;
			this.sourcePositionX = BoardConstants.INVALID_POSITION;
			this.sourcePositionY = BoardConstants.INVALID_POSITION;
			result = true;
			
		}
		return result;
	}

	public boolean dropSource() {
		boolean result = false;
		if((this.robotPositionX == this.destinationPositionX &&
			this.robotPositionY == this.destinationPositionY) &&
			this.sourcePicked){
			this.sourcePicked = false;
			result = true;
		}
		return result;
	}

	public boolean moveRobot(char direction) {
		boolean result = false;
		switch(direction){
			case 'w':
				if((0 <= (this.robotPositionX - 1)) && 
					this.board[this.robotPositionX -1]
							[this.robotPositionY].isPath()){
					this.robotPositionX--;
					result = true;
				}
				break;
			case 'e':
				if((this.robotPositionX + 1) < BoardConstants.BOARD_SIZE_VERTICAL
						&& this.board[this.robotPositionX+1]
								[this.robotPositionY].isPath()){
					this.robotPositionX++;
					result = true;
				}
				break;
			case 's':
				if((0 <= (this.robotPositionY + 1)) &&
						this.board[this.robotPositionX]
								[this.robotPositionY + 1].isPath()){
					this.robotPositionY++;
					result = true;
				}else{
					System.out.println("path:" + this.board[this.robotPositionX][this.robotPositionY+1].isPath());
				}
				break;
			case 'n':
				if((this.robotPositionY - 1) < BoardConstants.BOARD_SIZE_HORIZONTAL
						&& this.board[this.robotPositionX]
								[this.robotPositionY - 1].isPath()){
					this.robotPositionY--;
					result = true;
				}
				break;
		}
	
		return result;
	}
	
	
	public void removeItem(int posX, int posY){
		
		if(this.robotPositionX == posX && this.robotPositionY == posY){
			this.robotPositionX = BoardConstants.INVALID_POSITION;
			this.robotPositionY = BoardConstants.INVALID_POSITION;
		}
		
		if(this.sourcePositionX == posX && this.sourcePositionY == posY){
			this.sourcePositionX = BoardConstants.INVALID_POSITION;
			this.sourcePositionY = BoardConstants.INVALID_POSITION;
			this.sourcePicked = false;
		}
		
		if(this.destinationPositionX == posX && this.destinationPositionY == posY){
			this.destinationPositionX = BoardConstants.INVALID_POSITION;
			this.destinationPositionY = BoardConstants.INVALID_POSITION;
		}
	}
	
	
	
	
	
	
}
