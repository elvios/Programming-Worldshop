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
public class BlockFunctionsTest {
	
	public BlockFunctionsTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of isMoveLegal method, of class BlockFunctions.
	 */
	@Test
	public void testIsMoveLegal() {
		System.out.println("isMoveLegal");
		String blockA = "B";
		String blockB = "g";
		BlockFunctions instance = new BlockFunctions();
		boolean expResult = false;
		boolean result = instance.isMoveLegal(blockA, blockB);
		assertEquals(expResult, result);
	}

	/**
	 * Test of specialMovement method, of class BlockFunctions.
	 */
	@Test
	public void testSpecialMovement() {
		System.out.println("specialMovement");
		String blockA = "B";
		String blockB = "U";
		BlockFunctions instance = new BlockFunctions();
		instance.backwardsMove(blockA, blockB);
		assertEquals(Player.movementValue, -5);
	}
}