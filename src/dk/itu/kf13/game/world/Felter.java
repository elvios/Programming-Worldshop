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
        int numberOfLines = 6;
        String[] textData = new String[numberOfLines];
        
        for (int i = 0; i < numberOfLines; i++){
            textData[i] = textReader.readLine();
            
        }
        textReader.close();
        return textData;
      }
    
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
    
    
    
    
    
    
    
    
    
    public void runMe(){
    
        String[] vand = {"     ", "  ~  ", "     "};
        String line1 = "";
        String line2 = "";
        String line3 = "";
        for(int i = 1; i <= 5; i++){
            

            line1 = line1 + vand[0];
            line2 = line2 + vand[1];
            line3 = line3 + vand[2];
        }
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);

    }
}
