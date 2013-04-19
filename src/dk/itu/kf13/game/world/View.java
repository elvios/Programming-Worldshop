/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.io.IOException;

/**
 *
 * @author Sarah de Voss
 */
public class View {
    
    public void drawMap(String mapName) throws IOException{
        
        Map fe = new Map();
        String[] mapArray = fe.fileToArray("src\\dk\\itu\\kf13\\game\\world\\Maps\\" + mapName);
        
    }
}
