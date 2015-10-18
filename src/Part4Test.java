import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class Part4Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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

	
	@Test
	/**
	 * 1, user can move the Robot which carry the source object, 
	 * when the Robot is  moved to the destination it can be dropped at the destination by the user. 
	 *
	 */	
	public void testdropsourceobject() 
	{
		assertTrue("The source is dropped in correct place",setdestination(4,4),sourceposition(4,4));
		//true("the source object is dropped at destination ");
	}
	@Test
	/**
	 * 2, user can not drop the source object from Robot on the path which is not the destination.
	 */
	public void testdropsourceobjectonwrongway() 
	{
		assertFalse("The source is dropped in wrong place",setdestination(4,4),sourceposition(4,5));
		//false("the source object is dropped at another position ");
	}

}
