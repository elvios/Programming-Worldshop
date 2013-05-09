/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

import dk.itu.kf13.game.world.Controller.KListener;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elvis
 */
public class PlayerTest {
	
	public PlayerTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of update method, of class Player.
	 */
	@Test
	public void testUpdate() {
		System.out.println("update");
		KListener kListener = null;
		Player instance = null;
		//instance.update(kListener);
		boolean left = true;
		// TODO review the generated test code and remove the default call to fail.
		assertTrue(left);
	}

	/**
	 * Test of getX method, of class Player.
	 */
	@Test
	public void testGetX() {
		System.out.println("getX");
		Player instance = null;
		int expResult = 0;
		int result = instance.getX();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getY method, of class Player.
	 */
	@Test
	public void testGetY() {
		System.out.println("getY");
		Player instance = null;
		int expResult = 0;
		int result = instance.getY();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of getAppearance method, of class Player.
	 */
	@Test
	public void testGetAppearance() {
		System.out.println("getAppearance");
		Player instance = null;
		String expResult = "";
		String result = instance.getAppearance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of move method, of class Player.
	 */
	@Test
	public void testMove() {
		System.out.println("move");
		int moveX = 0;
		int moveY = 0;
		Player instance = null;
		instance.move(moveX, moveY);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}