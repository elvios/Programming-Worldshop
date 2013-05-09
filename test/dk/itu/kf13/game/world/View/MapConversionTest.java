/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.View;

import dk.itu.kf13.game.world.Model.MapFunctions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elvis
 */
public class MapConversionTest {
	
	public MapConversionTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of smallMapToLargeMap method, of class MapConversion.
	 */
	@Test
	public void testSmallMapToLargeMap() {
		System.out.println("smallMapToLargeMap");
		MapConversion instance = new MapConversion();
		MapFunctions mapFunc = new MapFunctions();

		String[][] smallMap  = mapFunc.getOriginalMap();
		String expResult = "  ~  ";
		String[][] resultArray = instance.smallMapToLargeMap(smallMap);
		String result = resultArray[0][1];
		assertEquals(expResult, result);
	}

	/**
	 * Test of multiArrayToString method, of class MapConversion.
	 */
	@Test
	public void testMultiArrayToString() {
		System.out.println("multiArrayToString");
		MapConversion instance = new MapConversion();
		MapFunctions mapFunc = new MapFunctions();

		String[][] inputArray = mapFunc.getOriginalMap();
		inputArray = instance.smallMapToLargeMap(inputArray);

		String expResult = "  ~  ";
		String result = instance.multiArrayToString(inputArray).substring(100, 105);
		assertEquals(expResult, result);
	}
}