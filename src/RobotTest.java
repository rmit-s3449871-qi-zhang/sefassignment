import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.Color;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class RobotTest {
	
	Robot robot;
	JPanel panel;
	static JButton[][] button;
	MouseEvent e;
	
	@BeforeClass
	public static void setUpClass(){
		
		button = new JButton[10][10];
	}
	@AfterClass
	public static void tearDownClass(){
		
	}

	@Before
	public void setUp() throws Exception {
		robot = new Robot();
		panel = new JPanel();
		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMain(){
		System.out.println("main");
		String[] args = null;
		Robot.main(args);
		fail("The test case is a prototype");	
	}
	
	// normal at the beginning of the program, all background color set as white
	@Test
	public void testvalidBackgroundColor() {
		// Define appropriate variables
		for(int i=0;i<button.length;i++){
			for(int j=0;j<button[i].length;j++){
				button[i][j] = new JButton();
				button[i][j].setBackground(Color.white);
				panel.add(button[i][j]);
				assertTrue("Background color should be white",button[i][j].getBackground().equals(Color.WHITE));
			}
		}
		robot.add(panel);
		robot.setVisible(true);	
		assertNotNull("It is a grid",robot);
	}
	
	@Test
	public void testInvalidBackgroundColor(){
		for(int i=0;i<button.length;i++){
			for(int j=0;j<button[i].length;j++){
				button[i][j] = new JButton();
				button[i][j].setBackground(Color.BLACK);
				panel.add(button[i][j]);
				assertFalse("Some button are not white",button[i][j].getBackground().equals(Color.WHITE));
			}
		}
		robot.add(panel);
		robot.setVisible(true);	
	}
	
	
	@Test
	public void testCreatePath(){
		
	}
	
	@Test
	public void testErasePath(){
		
	}
	
	
	@Test
	public void testLocateRobot(){
		
	}
	
	@Test
	public void testLocateSource(){
		
	}
	
	@Test
	public void testLocatedestination(){
		
	}
	
	@Test
	public void testValidMoveRobot(){
		
	}
	
	@Test
	public void testInvalidMoveRobot(){
		
	}
	
	@Test
	public void testPickSource(){
		
	}
	
	@Test
	public void testInvalidPickSource(){
		
	}
	
	@Test
	public void testDropSource(){
		
	}
	
	@Test
	public void testInvalidDropSource(){
		
	}

}
