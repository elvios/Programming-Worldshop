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
public class Felter {
    
     public String[] fileToArray(String filepath) throws IOException{
        FileReader fr = new FileReader(filepath);
        BufferedReader textReader = new BufferedReader(fr);
        
        // We get the numberOfLines from the method readLines that we wrote 
        // further down in this file.
        int numberOfLines = readLines(filepath);
        
        String[] textData = new String[numberOfLines];
        
        for (int i = 0; i < numberOfLines; i++){
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
    public int readLines(String filepath) throws FileNotFoundException, IOException{
        
        FileReader fr = new FileReader(filepath);
        BufferedReader textReader = new BufferedReader(fr);
        
        String line;
        int counter = 0;
        
        while ( ( line = textReader.readLine() ) != null ) {
            counter++;
        }
        textReader.close();
        
        return counter;
    }
    
    /**
     * 
     * @param map as the letter for the specific block
     * @return the ascii art for the block.
     */
    public String[] fromLettersToBlocks(String[] map) {

        int arr_length = map.length;

        // We read the map a line at a time.
        for ( int i = 0 ; i < arr_length ; i++ ) {
            int str_length = map[i].length();

            // We read the line a letter at a time.
            for ( int j = 0 ; j < str_length ; j++ ) {
                String letter = map[i].substring(j, 1);
                
            }
        }
        return null;
    }
    public String[][] mapToMultiArray(String mapName) throws IOException{
        // We load the map file into an array
        String[] mapArray = fileToArray("src\\dk\\itu\\kf13\\game\\world\\Maps\\" + mapName);
        
        // We find the dimensions of the large map
        int rows = mapArray.length * 3;
        int cols = mapArray[0].length();
        
        String[][] LargeMapArray = new String[rows][cols];
        for(int i = 0; i < mapArray.length; i++){
            for(int j = 0; j < cols; j++){
                
                // Gets the block file and loads it into an array.
                String letter = mapArray[i].substring(j,j+1);
                String[] blockArray = fileToArray("src\\dk\\itu\\kf13\\game\\world\\Blocks\\" + letter + ".txt");
                
                // Puts the blocks into the array.
                LargeMapArray[3*i][j] =  blockArray[0];
                LargeMapArray[3*i+1][j] = blockArray[1];
                LargeMapArray[3*i+2][j] = blockArray[2];
                
            }
        }
        
        for ( int i = 0 ; i < rows ; i++ ) {
            for ( int j = 0 ; j < cols ; j++ ) {
                System.out.print(LargeMapArray[i][j]);
            }
            System.out.println("");
        }
        
        return null;
    }
}
 