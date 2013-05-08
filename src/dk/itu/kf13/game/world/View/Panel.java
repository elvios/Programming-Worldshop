/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.View;

import dk.itu.kf13.game.world.Model.BlockFunctions;
import dk.itu.kf13.game.world.Model.Enemy;
import dk.itu.kf13.game.world.Model.MapFunctions;
import dk.itu.kf13.game.world.Model.Player;
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
public class Panel extends JPanel implements KeyListener {

    // Sets the player start-position and appearance.
    Player player = new Player(0, 0, "B", 1);
    
    // Loads in all the enemies.
    Enemy tornado = new Enemy(2, 2, "TUV ", 5, 5, 0, 0, 9, 9);
    Enemy tornado2 = new Enemy(2, 2, "TUV ", 11, 5, 10, 0, 19, 9);
    Enemy pig = new Enemy(1, 1, "P", 17, 4, 17, 4, 19, 6);
    
    BlockFunctions blockFunc = new BlockFunctions();
    MapFunctions mapFunc = new MapFunctions();
    MapConversion mapConv = new MapConversion();
    
    int counter = 0;
    public static String[][] smallMap;
    public static String[][] smallMapWithoutPlayer;
    private String mapString;
    private String[][] largeMap;
    
    // Gets the mapFunc height and width from the MapFunctions class.
    // They are final variables.
    int height = MapFunctions.MAP_HEIGHT * 3;
    int width = MapFunctions.MAP_WIDTH * 5;
    public JTextArea ta = new JTextArea(height, width);

    // This is the constructor
    public Panel() throws IOException {

        super(); // calls the parent.
        addKeyListener(this);
        
        // Sets attributes for the textarea.
        ta.setEditable(false);
        ta.setFont(new Font("Courier new", Font.PLAIN, 16));
        ta.setLineWrap(true); //lines are wrapped - even in mid-word.
        add(ta); // adds the textarea

        // Draws the initial map - once. Then appends it to the textarea
        smallMap = mapFunc.getOriginalMap(); // just a copy of the mapFunc file
        largeMap = mapConv.smallMapToLargeMap(smallMap); // blow it up to large array
        mapString = mapConv.multiArrayToString(largeMap); // shrink it to one string
        ta.append(mapString); // append it to textarea
    }

    @Override
    public void paint(Graphics g) {

        try {
            super.paint(g); // Call its parent for proper rendering.

            smallMap = mapFunc.getOriginalMap();

            // Places the ENEMIES
            tornado.placeInMapArray(smallMap, mapFunc);
            tornado2.placeInMapArray(smallMap, mapFunc);
            pig.placeInMapArray(smallMap, mapFunc);

            // checks if there is any special movement going on.
            smallMapWithoutPlayer = smallMap; //array of the mapFunc without player
            blockFunc.specialMovement(
                    player.getAppearance(),
                    smallMapWithoutPlayer[player.getX()][player.getY()]);

            // Places the PLAYER in mapFunc array.
            smallMap = mapFunc.replaceLetterInMapArray(smallMap, "B", player.getX(), player.getY());

            // makes large mapFunc array, and then shrink it to one string.
            String[][] large = mapConv.smallMapToLargeMap(smallMap);
            String mapAsString = mapConv.multiArrayToString(large);

            // replaces the text in textarea with new mapString
            int len = mapAsString.length();
            ta.replaceRange(mapAsString, 0, len);

            // This counter makes the enemies move a little slower than the 
            // Thread.sleep.
            counter++;
            if (counter == 10) {
                tornado.move();
                tornado2.move();
                pig.move();

                counter = 0;
            }

        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}