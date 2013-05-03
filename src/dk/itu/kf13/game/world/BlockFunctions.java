/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

/**
 *
 * @author Sarah de Voss
 */
public class BlockFunctions {

    
    public boolean isMoveLegal(String blockA, String blockB) {
        
        if ( blockA.equals("B") && blockB.equals("g") ) {
            return false;
        }
        
        if ( blockA.equals("B") && blockB.equals("T") ) {
            Player.movementValue = -6;
            return true;
        }
        
        if ( blockA.equals("B") && blockB.equals("s") ) {
            Player.movementValue = 10;
            return true;
        }
        
        return true;
    }
}
