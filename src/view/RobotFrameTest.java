package view;

import static org.junit.Assert.assertTrue;

import java.awt.Color;
import java.awt.Robot;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.BoardModel;
import model.CellPathInfo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.imageitem.BinImage;
import view.imageitem.RobotImage;
import view.imageitem.SourceImage;

public class RobotFrameTest{
	ButtonCell[][] buttonCells;
	CellPathInfo[][] board;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		new RobotFrame();
		buttonCells = new ButtonCell[10][10];
		board = new CellPathInfo[10][10];
	}

	@After
	public void tearDown() throws Exception {
	}

//	@Test
//	public void testCreatePath() throws NoSuchMethodException, SecurityException, 
//		IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		button1 = BoardModel.getInstance().getGrid().getButtonCell(2, 2);
//		button2 = BoardModel.getInstance().getGrid().getButtonCell(2, 3);
//		button3 = BoardModel.getInstance().getGrid().getButtonCell(2, 4);
//		MouseEvent event1 = new MouseEvent(button1, MouseEvent.BUTTON1, 0, 
//				MouseEvent.BUTTON1_DOWN_MASK, 2, 2, 1, false);
//		MouseEvent event2 = new MouseEvent(button2, MouseEvent.BUTTON1, 0, 
//				MouseEvent.BUTTON1_DOWN_MASK, 2, 3, 1, false);
//		MouseEvent event3 = new MouseEvent(button1, MouseEvent.BUTTON1, 0, 
//				MouseEvent.BUTTON1_DOWN_MASK, 2, 2, 1, false);
//		Method process = Component.class.getDeclaredMethod("processEvent", AWTEvent.class);
//		process.setAccessible(true);
//		process.invoke(button1, event1);
//		process.invoke(button2, event2);
//		process.invoke(button3, event3);
//		assertTrue("path1", BoardModel.getInstance().isPath(2, 2));
//		assertTrue("path2", !BoardModel.getInstance().isPath(2, 3));
//		assertTrue("path3", !BoardModel.getInstance().isPath(2, 4));
//	}
	
	// test create path
	// click on a cell changes color
	@Test
	public void testCreatePath(){
		JButton button = BoardModel.getInstance().getGrid().getButtonCell(2, 2);
		button.setBackground(Color.LIGHT_GRAY);
		BoardModel.getInstance().setCellPath(2, 2);
		if(button.getBackground() == Color.LIGHT_GRAY){
			// set the path color as white
			board[2][2] = new CellPathInfo();
			board[2][2].setPath(true);
			BoardModel.getInstance().setCellPath(2,2);
			
			button.setBackground(Color.WHITE);
		}
		assertTrue("path created", BoardModel.getInstance().isPath(2, 2));
	}
	
	// test add robot
	// the system accepts a robot when placed along the path
	@Test
	public void testLocateRobot(){
		JButton button = BoardModel.getInstance().getGrid().getButtonCell(2, 2);
		BoardModel.getInstance().setCellPath(2, 2);
		button.setBackground(Color.WHITE);
		board[2][2] = new CellPathInfo();
		board[2][2].setPath(true);
		boolean isPath = BoardModel.getInstance().isPath(2, 2);
		ImageIcon image = new RobotImage().getImage();
		if(isPath){
			button.setIcon(image);
		}
		assertTrue("robot placed", button.getIcon().equals(image));
	}
	
	// test add source
	// the system accepts a source when placed along the path
	@Test
	public void testLocateSource(){
		JButton button = BoardModel.getInstance().getGrid().getButtonCell(2, 3);
		BoardModel.getInstance().setCellPath(2, 3);
		button.setBackground(Color.WHITE);
		board[2][3] = new CellPathInfo();
		board[2][3].setPath(true);
		boolean isPath = BoardModel.getInstance().isPath(2, 3);
		ImageIcon image = new SourceImage().getImage();
		if(isPath){
			button.setIcon(image);
		}
		assertTrue("robot placed", button.getIcon().equals(image));
	}
	
	// test add destination
	// the system accepts a destination when placed along the path
	@Test
	public void testLocatedestination(){
		JButton button = BoardModel.getInstance().getGrid().getButtonCell(2, 4);
		BoardModel.getInstance().setCellPath(2, 4);
		button.setBackground(Color.WHITE);
		board[2][4] = new CellPathInfo();
		board[2][4].setPath(true);
		boolean isPath = BoardModel.getInstance().isPath(2, 4);
		ImageIcon image = new BinImage().getImage();
		if(isPath){
			button.setIcon(image);
		}
		assertTrue("robot placed", button.getIcon().equals(image));
	}
	
	// test move robot along the path
	// robot moves along the path based on the command specifying direction and distance
	@Test
	public void testValidMoveRobot(){
		JButton button1 = BoardModel.getInstance().getGrid().getButtonCell(2, 5);
		BoardModel.getInstance().setCellPath(2, 5);
		button1.setBackground(Color.WHITE);
		board[2][5] = new CellPathInfo();
		board[2][5].setPath(true);
		boolean isPath1 = BoardModel.getInstance().isPath(2, 5);
		
		JButton button2 = BoardModel.getInstance().getGrid().getButtonCell(2, 6);
		BoardModel.getInstance().setCellPath(2, 6);
		button2.setBackground(Color.WHITE);
		board[2][6] = new CellPathInfo();
		board[2][6].setPath(true);
		boolean isPath2 = BoardModel.getInstance().isPath(2, 6);
		ImageIcon image = new RobotImage().getImage();
		if(isPath1&&isPath2){		
			button1.setIcon(image);
		}
		
	}
	
	@Test
	public void testPickSource(){
		
	}
	
	@Test
	public void testDropSource(){
		
	}
	
}
