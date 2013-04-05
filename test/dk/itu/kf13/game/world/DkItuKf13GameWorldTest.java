/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sarah de Voss
 */
public class DkItuKf13GameWorldTest {
    
    public DkItuKf13GameWorldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class DkItuKf13GameWorld.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
       // DkItuKf13GameWorld.main(args);
        
        EpicWorld theWorld = new EpicWorld();
        List<Location> ourLocations = theWorld.getLocations();
        
        List<String> check_output = new ArrayList<String>();
        List<String> output = new ArrayList<String>();
        
        check_output.add("Caveland: The land of the caves where you fight the cave men.");
        check_output.add("Rainland: A land where it rains from the skies");
        check_output.add("Rainbowland: The land of the unicorns and the rainbows! Whee! <3");
        
        for ( Location location : ourLocations) {
            String result = location.getName() + ": " + location.getDescription();
            output.add(result);
        }
        
        for ( int i = 0 ; i < output.size() ; i++ ) {
            //assertEquals(output[i], check_output[i]);
        }
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
