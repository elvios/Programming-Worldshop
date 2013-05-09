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
		KListener kListener = new KListener();
		Player instance = new Player(0,0,"B",1);
		instance.move(1, 0);
		instance.update(kListener);
		assertTrue(kListener.right);
	}

	/**
	 * Test of getX method, of class Player.
	 */
	@Test
	public void testGetX() {
		System.out.println("getX");
		Player instance = new Player(2, 2, "B", 1);
		int expResult = 2;
		int result = instance.getX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getY method, of class Player.
	 */
	@Test
	public void testGetY() {
		System.out.println("getY");
		Player instance = new Player(2, 2, "B", 1);
		int expResult = 2;
		int result = instance.getY();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of getAppearance method, of class Player.
	 */
	@Test
	public void testGetAppearance() {
		System.out.println("getAppearance");
		Player instance = new Player(0,0,"B",1);
		String expResult = "B";
		String result = instance.getAppearance();
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
	}

	/**
	 * Test of move method, of class Player.
	 */
	@Test
	public void testMove() {
		System.out.println("move");
		int moveX = 1;
		int moveY = 0;
		Player instance = new Player(0,0,"B",1);
		instance.move(moveX, moveY);
		// TODO review the generated test code and remove the default call to fail.
		assertEquals(instance.getX(), 1);
	}
}