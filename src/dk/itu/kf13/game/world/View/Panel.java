/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.View;

import dk.itu.kf13.game.world.Controller.KListener;
import dk.itu.kf13.game.world.Model.BlockFunctions;
import dk.itu.kf13.game.world.Model.Enemy;
import dk.itu.kf13.game.world.Model.MapFunctions;
import dk.itu.kf13.game.world.Model.Player;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Elvis Flesborg
 * @author Sarah de Voss
 */
public class Panel extends JPanel {

    // Sets the player start-position and appearance.
    Player player = new Player(0, 0, "B", 1);
    // Loads in all the enemies.
    Enemy tornado = new Enemy(2, 2, "TUV ", 5, 5, 0, 0, 9, 9);
    Enemy tornado2 = new Enemy(2, 2, "TUV ", 11, 5, 10, 0, 19, 9);
    Enemy pig = new Enemy(1, 1, "P", 17, 4, 17, 4, 19, 6);
    BlockFunctions blockFunc = new BlockFunctions();
    MapFunctions mapFunc = new MapFunctions();
    MapConversion mapConv = new MapConversion();
    KListener kListener = new KListener();
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
    public Panel() {

        super(); // calls the parent.
        this.addKeyListener(kListener);
        setFocusable(true);

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

        super.paint(g); // Call its parent for proper rendering.

        smallMap = mapFunc.getOriginalMap();

        // Places the ENEMIES
        tornado.placeInMapArray(smallMap, mapFunc);
        tornado2.placeInMapArray(smallMap, mapFunc);
        pig.placeInMapArray(smallMap, mapFunc);

        // checks if there is any special movement going on.
        smallMapWithoutPlayer = smallMap; //array of the mapFunc without player

        // Checks if the player should be respawned somewhere.
        blockFunc.spawnMove(player.getAppearance(), smallMapWithoutPlayer[player.getX()][player.getY()]);
        blockFunc.backwardsMove(player.getAppearance(), smallMapWithoutPlayer[player.getX()][player.getY()]);

        // Places the PLAYER in mapFunc array.
        smallMap = mapFunc.replaceLetterInMapArray(smallMap, player.getAppearance(), player.getX(), player.getY());

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
            tornado.moveRandomly();
            tornado2.moveRandomly();
            pig.moveInCircle();

            counter = 0;
        }

        // Reads what the keylistener has got.
        player.update(kListener);

        // Sets special movement.
        blockFunc.slowMove(player.getAppearance(), smallMapWithoutPlayer[player.getX()][player.getY()]);

        // Resets the Keylistener.
        kListener.doNotMove();

        // repainting
        repaint();
    }
}