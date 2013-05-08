/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.View;

import dk.itu.kf13.game.world.Model.MapFunctions;
import java.io.IOException;

/**
 *
 * @author Sarah de Voss
 */
public class MapConversion {
    
    MapFunctions mapFunc = new MapFunctions();
    
  public String[][] smallMapToLargeMap(String[][] mapArray) throws IOException {
        
        // We find the dimensions of the large mapFunc
        int cols = mapArray.length; // 11
        int rows = mapArray[0].length * 3; // we need 3 times as many rows.

        // Begins to create the larger mapFunc array with the new dimension.
        String[][] LargeMapArray = new String[cols][rows];
        
        for (int i = 0; i < mapArray[0].length; i++) {
            for (int j = 0; j < cols; j++) {

                // Gets the block file and loads it into an array.
                String letter = mapArray[j][i];
                String[] blockArray = mapFunc.fileToArray("src\\dk\\itu\\kf13\\game\\world\\Blocks\\" + letter + ".txt");

                // Puts the blocks into the array.
                LargeMapArray[j][3 * i] = blockArray[0];
                LargeMapArray[j][3 * i + 1] = blockArray[1];
                LargeMapArray[j][3 * i + 2] = blockArray[2];

            }
        }

        return LargeMapArray;
    }  
  
  
    public String multiArrayToString(String[][] inputArray) {
        String output = "";
        for (int i = 0; i < inputArray[0].length; i++) {
            for (int j = 0; j < inputArray.length; j++){
                output = output + inputArray[j][i];
            }
        }
        return output;
    }
}
