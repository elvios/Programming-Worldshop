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
public class MapFunctionsTest {
	
	public MapFunctionsTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of getOriginalMap method, of class MapFunctions.
	 */
	@Test
	public void testGetOriginalMap() {
		System.out.println("getOriginalMap");
		MapFunctions instance = new MapFunctions();
		String[][] expResult = null;
		String[][] result = instance.getOriginalMap();
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of fileToArray method, of class MapFunctions.
	 */
	@Test
	public void testFileToArray() {
		System.out.println("fileToArray");
		String filepath = "";
		MapFunctions instance = new MapFunctions();
		String[] expResult = null;
		String[] result = instance.fileToArray(filepath);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of numberOfLinesInFile method, of class MapFunctions.
	 */
	@Test
	public void testNumberOfLinesInFile() {
		System.out.println("numberOfLinesInFile");
		String filepath = "";
		MapFunctions instance = new MapFunctions();
		int expResult = 0;
		int result = instance.numberOfLinesInFile(filepath);
		assertEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of mapFileToSmallArray method, of class MapFunctions.
	 */
	@Test
	public void testMapFileToSmallArray() {
		System.out.println("mapFileToSmallArray");
		String mapName = "";
		MapFunctions instance = new MapFunctions();
		String[][] expResult = null;
		String[][] result = instance.mapFileToSmallArray(mapName);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}

	/**
	 * Test of replaceLetterInMapArray method, of class MapFunctions.
	 */
	@Test
	public void testReplaceLetterInMapArray() {
		System.out.println("replaceLetterInMapArray");
		String[][] mapArray = null;
		String replacement = "";
		int x = 0;
		int y = 0;
		MapFunctions instance = new MapFunctions();
		String[][] expResult = null;
		String[][] result = instance.replaceLetterInMapArray(mapArray, replacement, x, y);
		assertArrayEquals(expResult, result);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}