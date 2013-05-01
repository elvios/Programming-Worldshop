/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Sarah de Voss
 */
public class PanelAndKeyListenerAndMapConversion extends JPanel implements KeyListener {

    // Sets the player start-position and appearance.
    Player player = new Player(0, 0, "B");
    
    // Gets the map height and width from the MapFunctions class.
    // They are final variables.
    int height = MapFunctions.MAP_HEIGHT * 3;
    int width = MapFunctions.MAP_WIDTH * 5;
    public JTextArea ta = new JTextArea(height, width);
    
    MapFunctions map;
    String[][] originalMap;

    // This is the constructor
    public PanelAndKeyListenerAndMapConversion() throws IOException {
        
        super(); // calls the parent.
        addKeyListener(this);

        // Sets attributes for the textarea.
        ta.setEditable(false);
        ta.setFont(new Font("Courier new", Font.PLAIN, 16));
        ta.setLineWrap(true);
        add(ta);
        
        map = new MapFunctions();

        originalMap = map.mapFileToSmallArray("Bane1.txt");
        
        String[][] smallMap = map.replaceLetterInMapArray(originalMap, "B", player.getX(), player.getY());
        String[][] largeMap = map.smallMapToLargeMap(smallMap);
        String mapString = map.multiArrayToString(largeMap);

        ta.append(mapString);
        
    }
    
    
    @Override
    public boolean isFocusTraversable() {
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        int KeyCode = e.getKeyCode();
        
        switch (KeyCode) {
            
            case KeyEvent.VK_LEFT:
                player.move(-1, 0);
            break;
            case KeyEvent.VK_RIGHT:
                player.move(1, 0);
            break;
            case KeyEvent.VK_UP:
                player.move(0, -1);
            break;
            case KeyEvent.VK_DOWN:
                player.move(0, 1);
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    
   
   
     @Override
    public void paint(Graphics g) {
        
         try {
            super.paint(g); // Call it's parent for proper rendering.
     
            originalMap = map.mapFileToSmallArray("Bane1.txt");
            
            String[][] smallMap = map.replaceLetterInMapArray(originalMap, "B", player.getX(), player.getY());
            String[][] largeMap = map.smallMapToLargeMap(smallMap);
            String mapString = map.multiArrayToString(largeMap);

            int len = mapString.length();
            ta.replaceRange(mapString, 0, len);
            
        } catch (IOException ex) {
            Logger.getLogger(PanelAndKeyListenerAndMapConversion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}