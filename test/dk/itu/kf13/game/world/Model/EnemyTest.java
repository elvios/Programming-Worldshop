/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elvis
 */
public class EnemyTest {
	
	public EnemyTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of moveInCircle method, of class Enemy.
	 */
	@Test
	public void testMoveInCircle() {
		System.out.println("moveInCircle");
		Enemy instance = new Enemy(1, 1, "P", 0,0,0,0,5,5); // Creates a pig.
		instance.moveInCircle();
		assertEquals(instance.getX(), 1);
	}

	/**
	 * Test of moveRandomly method, of class Enemy.
	 */
	@Test
	public void testMoveRandomly() {
		System.out.println("moveRandomly");
		Enemy instance = new Enemy(1,1,"P",0,0,0,0,5,5);
		instance.moveRandomly();
		//assertEquals(instance.getX(), 1); // Since this is randomly generated, it is not always true.
	}

	/**
	 * Test of placeInMapArray method, of class Enemy.
	 */
	@Test
	public void testPlaceInMapArray() {
		System.out.println("placeInMapArray");
		MapFunctions map = new MapFunctions();
		String[][] smallMap = map.getOriginalMap();

		// Tests a pig
		Enemy pig = new Enemy(1,1,"P",0,0,0,0,5,5);
		pig.placeInMapArray(smallMap, map);
		assertEquals(smallMap[0][0], "P");

		// Tests a tornado
		Enemy tornado = new Enemy(2,2, "TUV ",0,0,0,0,5,5);
		tornado.placeInMapArray(smallMap, map);
		assertEquals(smallMap[0][0], "T");
		assertEquals(smallMap[1][0], "U");
		assertEquals(smallMap[0][1], "V");
	}

	/**
	 * Test of getX method, of class Enemy.
	 */
	@Test
	public void testGetX() {
		System.out.println("getX");
		Enemy instance = new Enemy(1,1,"P",0,0,0,0,5,5);
		int expResult = 0;
		int result = instance.getX();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getY method, of class Enemy.
	 */
	@Test
	public void testGetY() {
		System.out.println("getY");
		Enemy instance = new Enemy(1,1,"P",0,0,0,0,5,5);
		int expResult = 0;
		int result = instance.getY();
		assertEquals(expResult, result);
	}

	/**
	 * Test of getAppearance method, of class Enemy.
	 */
	@Test
	public void testGetAppearance() {
		System.out.println("getAppearance");
		Enemy instance = new Enemy(1,1,"P",0,0,0,0,5,5);
		String[][] expResult = {{"P"}};
		String[][] result = instance.getAppearance();
		assertArrayEquals(expResult, result);
	}
}