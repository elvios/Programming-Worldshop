/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah de Voss
 */
public class MapFunctions {
    
    public static final int MAP_WIDTH = 20;
    public static final int MAP_HEIGHT = 10;
    
		String mapName = "Map1";

    public String[][] getOriginalMap() {
        String[][] originalMap = null;
				originalMap = mapFileToSmallArray(mapName + ".txt");
        return originalMap;
    }
    
    public String[] fileToArray(String filepath) {
			FileReader fr = null;
			try {
				fr = new FileReader(filepath);
				BufferedReader textReader = new BufferedReader(fr);
				// We get the numberOfLines from the method numberOfLinesInFile that we wrote
				// further down in this file.
				int numberOfLines = numberOfLinesInFile(filepath);
				String[] textData = new String[numberOfLines];
				for (int i = 0; i < numberOfLines; i++) {
						textData[i] = textReader.readLine();

				}
				textReader.close();
				return textData;
			} catch (FileNotFoundException ex) {
				Logger.getLogger(MapFunctions.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(MapFunctions.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fr.close();
				} catch (IOException ex) {
					Logger.getLogger(MapFunctions.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			return null;
    }

    public int numberOfLinesInFile(String filepath) {
			FileReader fr = null;
			try {
				fr = new FileReader(filepath);
				BufferedReader textReader = new BufferedReader(fr);
				String line;
				int counter = 0;
				while ((line = textReader.readLine()) != null) {
						counter++;
				}
				textReader.close();
				return counter;
			} catch (FileNotFoundException ex) {
				Logger.getLogger(MapFunctions.class.getName()).log(Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(MapFunctions.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				try {
					fr.close();
				} catch (IOException ex) {
					Logger.getLogger(MapFunctions.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
			return 0;
    }
    
    public String[][] mapFileToSmallArray(String mapName) {
        // We load the map file into an array.
        //String[] mapArray = fileToArray("src\\dk\\itu\\kf13\\game\\world\\View\\Maps\\" + mapName);
        String[] mapArray = fileToArray("src/dk/itu/kf13/game/world/View/Maps/" + mapName);
        
        int rows = mapArray.length;
        int cols = mapArray[0].length();
        
        String[][] smallMapArray = new String[cols][rows];
        
        for ( int i = 0 ; i < rows ; i++ ) {
            for ( int j = 0 ; j < cols ; j++ ) {
                smallMapArray[j][i] = mapArray[i].substring(j, j+1);
            }
        }
        
        return smallMapArray;
    }
    
    public String[][] replaceLetterInMapArray(String[][] mapArray, String replacement, int x, int y) {
        // We replace the letter in coordinates x,y and return it.
        mapArray[x][y] = replacement;
        return mapArray;
    }
}
