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
    Player player = new Player(0, 0, "B", 1);

    // Loads in all the enemies.
    Enemy tornado = new Enemy(2, 2, "TUV ", 5, 5, 0, 0, 9, 9);
    Enemy tornado2 = new Enemy(2, 2, "TUV ", 11, 5, 10, 0, 19, 9);
    Enemy pig = new Enemy(1, 1, "P", 19, 9, 0, 0, 19, 9);
    
    int counter = 0;

    public static String[][] smallMap;

    // Gets the map height and width from the MapFunctions class.
    // They are final variables.
    int height = MapFunctions.MAP_HEIGHT * 3;
    int width = MapFunctions.MAP_WIDTH * 5;
    public JTextArea ta = new JTextArea(height, width);
    MapFunctions map = new MapFunctions();

    // This is the constructor
    public PanelAndKeyListenerAndMapConversion() throws IOException {
        
        super(); // calls the parent.
        addKeyListener(this);

        // Sets attributes for the textarea.
        ta.setEditable(false);
        ta.setFont(new Font("Courier new", Font.PLAIN, 16));
        ta.setLineWrap(true);
        add(ta);
        
        String[][] smallMap = map.replaceLetterInMapArray(map.getOriginalMap(), "B", player.getX(), player.getY());
        
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
        
        try {
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
        } catch (IOException ex) {
            Logger.getLogger(PanelAndKeyListenerAndMapConversion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
   
     @Override
    public void paint(Graphics g) {
        
         try {
            super.paint(g); // Call it's parent for proper rendering.
     
            smallMap = map.getOriginalMap();
 
            tornado.render(smallMap, map);
            tornado2.render(smallMap, map);
            pig.render(smallMap, map);
            // places the player (as a boat)
            smallMap = map.replaceLetterInMapArray(smallMap, "B", player.getX(), player.getY());
 
            String[][] largeMap = map.smallMapToLargeMap(smallMap);
            String mapString = map.multiArrayToString(largeMap);

            int len = mapString.length();
            ta.replaceRange(mapString, 0, len);
 
 
            // This counter makes the enemies move a little slower than the 
            // Thread.sleep.
            counter++;
            if ( counter == 10 ) {
                tornado.move();
                tornado2.move();
                pig.move();
                
                counter = 0;
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(PanelAndKeyListenerAndMapConversion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}