/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

/**
 *
 * @author Sarah de Voss
 */

import java.util.List;

public interface Location {
    
    public enum Direction {EAST, NORTH, WEST, SOUTH, UP, DOWN};
    
    List<Location> getExits(Direction direction);
    
    String getDescription();
    
    String getName();
    
}
