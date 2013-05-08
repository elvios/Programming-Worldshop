/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Sarah de Voss
 */
public class MapFunctions {
    
    public static final int MAP_WIDTH = 20;
    public static final int MAP_HEIGHT = 10;
    
    public String[][] getOriginalMap() throws IOException {
        String[][] originalMap = mapFileToSmallArray("Map1.txt");
        return originalMap;
    }
    
    public String[] fileToArray(String filepath) throws IOException {
        FileReader fr = new FileReader(filepath);
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
    }

    /**
     * This function returns the number of lines in a file.
     * @param filepath
     * @return number of lines in the file
     * @throws FileNotFoundException
     * @throws IOException
     */
    public int numberOfLinesInFile(String filepath) throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(filepath);
        BufferedReader textReader = new BufferedReader(fr);

        String line;
        int counter = 0;

        while ((line = textReader.readLine()) != null) {
            counter++;
        }
        textReader.close();

        return counter;
    }
    
    public String[][] mapFileToSmallArray(String mapName) throws IOException {
        // We load the map file into an array.
        String[] mapArray = fileToArray("src\\dk\\itu\\kf13\\game\\world\\View\\Maps\\" + mapName);
        
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
