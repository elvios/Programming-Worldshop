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
 * @author Elvis Flesborg
 * @author Sarah
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
		String expResult = "w";
		String[][] smallMap = instance.getOriginalMap();
		String result = smallMap[0][0];

		assertEquals(expResult, result);
	}

	/**
	 * Test of fileToArray method, of class MapFunctions.
	 */
	@Test
	public void testFileToArray() {
		System.out.println("fileToArray");

		String filepath = "src/dk/itu/kf13/game/world/View/Blocks/w.txt"; // for linux
		//String filepath = "src\\dk\\itu\\kf13\\game\\world\\View\\Blocks\\w.txt"; // for windows

		MapFunctions instance = new MapFunctions();
		String expResult = "  ~  ";
		String[] resultArray = instance.fileToArray(filepath);
		String result = resultArray[1];
		System.out.println(resultArray[1]);
		assertEquals(expResult, result);
	}

	/**
	 * Test of numberOfLinesInFile method, of class MapFunctions.
	 */
	@Test
	public void testNumberOfLinesInFile() {
		System.out.println("numberOfLinesInFile");
		String filepath = "src/dk/itu/kf13/game/world/View/Blocks/w.txt"; // for linux
		//String filepath = "src\\dk\\itu\\kf13\\game\\world\\View\\Blocks\\w.txt"; // for windows
		MapFunctions instance = new MapFunctions();
		int expResult = 3;
		int result = instance.numberOfLinesInFile(filepath);
		assertEquals(expResult, result);
	}

	/**
	 * Test of mapFileToSmallArray method, of class MapFunctions.
	 */
	@Test
	public void testMapFileToSmallArray() {
		System.out.println("mapFileToSmallArray");
		String mapName = "Map1.txt";
		MapFunctions instance = new MapFunctions();
		String expResult = "w";
		String[][] resultArray = instance.mapFileToSmallArray(mapName);
		String result = resultArray[0][0];
		assertEquals(expResult, result);
	}

	/**
	 * Test of replaceLetterInMapArray method, of class MapFunctions.
	 */
	@Test
	public void testReplaceLetterInMapArray() {
		System.out.println("replaceLetterInMapArray");
		MapFunctions instance = new MapFunctions();

		String[][] mapArray = instance.mapFileToSmallArray("Map1.txt");
		String replacement = "B";
		int x = 0;
		int y = 0;

		assertEquals(mapArray[0][0], "w");

		mapArray = instance.replaceLetterInMapArray(mapArray, replacement, x, y);
		assertEquals(mapArray[0][0], "B");
	}
}