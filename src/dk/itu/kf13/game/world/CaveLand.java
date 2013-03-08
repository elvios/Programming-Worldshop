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

public class CaveLand implements Location{

    @Override
    public List<Location> getExits(Direction direction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getDescription() {
        return "The land of the caves where you fight the cave men.";
    }

    @Override
    public String getName() {
        return "Caveland";
    }
    
}
