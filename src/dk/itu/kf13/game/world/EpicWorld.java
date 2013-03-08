/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.util.List;
import java.util.ArrayList;

public class EpicWorld implements World {

    List<Location> ourLocations = new ArrayList<Location>();

    public EpicWorld() {
        ourLocations.add(new CaveLand());
        ourLocations.add(new RainLand());
        ourLocations.add(new RainbowLand());
    }
    
    @Override
    public List<Location> getLocations() {
        return ourLocations;
    }
    
}
