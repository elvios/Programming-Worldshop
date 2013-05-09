/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.View;

import java.awt.Graphics;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author elvis
 */
public class PanelTest {
	
	public PanelTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}

	/**
	 * Test of paint method, of class Panel.
	 */
	@Test
	public void testPaint() {
		System.out.println("paint");
		Graphics g = null;
		Panel instance = new Panel();
		instance.paint(g);
		// TODO review the generated test code and remove the default call to fail.
		fail("The test case is a prototype.");
	}
}