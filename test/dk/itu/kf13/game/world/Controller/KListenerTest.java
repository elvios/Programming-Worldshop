/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Controller;

import java.awt.event.KeyEvent;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Sarah de Voss
 */
public class KListenerTest {
    
    public KListenerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of keyTyped method, of class KListener.
     */
    @Test
    public void testKeyTyped() {
        System.out.println("keyTyped");
        KeyEvent e = null;
        KListener instance = new KListener();
        instance.keyTyped(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyPressed method, of class KListener.
     */
    @Test
    public void testKeyPressed() {
        System.out.println("keyPressed");
        KeyEvent e = null;
        KListener instance = new KListener();
        instance.keyPressed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of keyReleased method, of class KListener.
     */
    @Test
    public void testKeyReleased() {
        System.out.println("keyReleased");
        KeyEvent e = null;
        KListener instance = new KListener();
        instance.keyReleased(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doNotMove method, of class KListener.
     */
    @Test
    public void testDoNotMove() {
        System.out.println("doNotMove");
        KListener instance = new KListener();
        instance.doNotMove();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
