/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

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

    
    // Loads the original map into a variable.
    public String[][] originalMap;
    

    public String[][] getOriginalMap() throws IOException {
        originalMap = mapFileToSmallArray("Map1.txt");
        return originalMap;
    }
    
    /**
     *
     * @param filepath
     * @return
     * @throws IOException
     */
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
        String[] mapArray = fileToArray("src\\dk\\itu\\kf13\\game\\world\\Maps\\" + mapName);
        
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
    
    /**
     *
     * @param mapName
     * @return
     * @throws IOException
     */
    public String[][] smallMapToLargeMap(String[][] mapArray) throws IOException {
        
        // We find the dimensions of the large map
        int cols = mapArray.length; // 11
        int rows = mapArray[0].length * 3; // we need 3 times as many rows.

        // Begins to create the larger map array with the new dimension.
        String[][] LargeMapArray = new String[cols][rows];
        
        for (int i = 0; i < mapArray[0].length; i++) {
            for (int j = 0; j < cols; j++) {

                // Gets the block file and loads it into an array.
                String letter = mapArray[j][i];
                String[] blockArray = fileToArray("src\\dk\\itu\\kf13\\game\\world\\Blocks\\" + letter + ".txt");

                // Puts the blocks into the array.
                LargeMapArray[j][3 * i] = blockArray[0];
                LargeMapArray[j][3 * i + 1] = blockArray[1];
                LargeMapArray[j][3 * i + 2] = blockArray[2];

            }
        }

        return LargeMapArray;
    }
    
    public void printMultiArray(String[][] inputArray) {
        int rows = inputArray.length;
        int cols = inputArray[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(inputArray[j][i]);
            }
            System.out.println();
        }
    }
    
    public String[][] replaceLetterInMapArray(String[][] mapArray, String replacement, int x, int y) {
        // We replace the letter in coordinates x,y and return it.
        mapArray[x][y] = replacement;
        return mapArray;
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
