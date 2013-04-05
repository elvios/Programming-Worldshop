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
        List<Location> ourLocations = theWorld.getLocations();
        
        for ( Location location : ourLocations) {
            System.out.println(location.getName() + ": " + location.getDescription());
        }
        Felter a = new Felter();
        String[] b = a.fileToArray("src\\dk\\itu\\kf13\\game\\world\\Maps\\Bane1.txt");
        
        int c = a.readLines("src\\dk\\itu\\kf13\\game\\world\\Blocks\\w.txt");
        System.out.println(c);
        
        for (int i = 0; i < 6; i++){
            System.out.println(b[i]);
        }
        a.mapToMultiArray("Bane1.txt");
    }
}

