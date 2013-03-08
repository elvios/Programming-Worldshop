/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.util.List;
import dk.itu.kf13.game.world.Location.Direction;

/**
 *
 * @author Sarah de Voss
 */
public class DkItuKf13GameWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EpicWorld theWorld = new EpicWorld();
        List<Location> ourLocations = theWorld.getLocations();
        
        for ( Location location : ourLocations) {
            System.out.println(location.getName() + ": " + location.getDescription());
        }
    }
}

