/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.util.List;
import dk.itu.kf13.game.world.Location.Direction;
import java.io.IOException;

/**
 *
 * @author Sarah de Voss
 */
public class DkItuKf13GameWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        EpicWorld theWorld = new EpicWorld();
        
        Map a = new Map();
        String[][] smallMapArray = a.mapFileToSmallArray("Bane1.txt");
        a.replaceLetterInMapArray(smallMapArray, "B", 7, 4);
        String[][] largeMapArray = a.smallMapToLargeMap(smallMapArray);
        
        a.printMultiArray(largeMapArray);
        
        Movement m = new Movement();
        
        
    }
}

