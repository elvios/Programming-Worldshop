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
 * @author Sarah de Voss
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
     * Test of backwardsMove method, of class BlockFunctions.
     */
    @Test
    public void testBackwardsMove() {
        System.out.println("backwardsMove");
        String blockA = "B";
        String blockB = "U";
        BlockFunctions instance = new BlockFunctions();
        instance.backwardsMove(blockA, blockB);
        int result = Player.movementValue;
        int expResult = -5;
        assertEquals(result, expResult);
    }

    /**
     * Test of slowMove method, of class BlockFunctions.
     */
    @Test
    public void testSlowMove() {
        System.out.println("slowMove");
        String blockA = "B";
        String blockB = "s";
        BlockFunctions instance = new BlockFunctions();
        instance.slowMove(blockA, blockB);
        int result = Player.movementValue;
        int expResult = 5;
        assertEquals(result, expResult);
    }

    /**
     * Test of spawnMove method, of class BlockFunctions.
     */
    @Test
    public void testSpawnMove() {
        System.out.println("spawnMove");
        Player player = new Player(1, 1, "O", 1);
        String blockA = "O";
        String blockB = "P";
        BlockFunctions instance = new BlockFunctions();
        instance.spawnMove(blockA, blockB);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }
}