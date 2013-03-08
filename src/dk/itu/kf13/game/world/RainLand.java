/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.util.List;

/**
 *
 * @author Sarah de Voss
 */
public class RainLand implements Location {

    @Override
    public List<Location> getExits(Direction direction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getDescription() {
        return "A land where it rains from the skies";
    }

    @Override
    public String getName() {
        return "Rainland";
    }
    
    
}
