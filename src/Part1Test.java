import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Part1Test {

	Robot robot;
	JPanel panel;
	static JButton[][] button;
	MouseEvent e;
	@BeforeClass
	
	public static void setUpBeforeClass() {
		button = new JButton[10][10];
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	//1.Clicking on a cell changes colour
	@Test
	public void testChangeColor()
	{
		button[2][2] = new JButton();
		button[2][2].setBackground(Color.white);
		button[2][2].mouseLeftClicked(e);
		assertTrue("The color changed", button[2][2].getBackground().equals(Color.RED));
	}
	/* 
	The cells along the path should be shown in a different colour, we will set the colour of the path to black.
	1. When user want create a path , click any cell on the board then the cell will change colour to black that means path is created successfully, if the colour doesn't , something wrong. 
	2. A cell can be erased by user, click the cell again, the colour should change back to grey, if the colour doesn't change, something wrong happen.
	*/

	//2.The system accepts a robot when placed along the path
	@Test
	public void setRobot()
	{
		assertEquals(true, setRobot(10,10));//position(10,10) is in the path.
		assertEquals(false, setRobot(4,5));//position(4,5) is not in the path.
	}
	/*
	User should be allowed to specify locations of robot by right clicking on any cell along the path.
	1.The robot should be only set in the path by right clicking, shouldn't  set the position of robot outside of the path. 
	2.The path should at least have three cells, because the robot and two objects should be setted on the path. User cannot just click one or two cells in the board.
*/
}
