/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Sarah de Voss
 */
public class Panel extends JPanel implements KeyListener {

    Player player = new Player(0, 0, "B");
    public JTextArea ta = new JTextArea(18,55);
    
    // This is the constructor
    public Panel() throws IOException {
        super();
        addKeyListener(this);
        //JTextArea ta = new JTextArea(18,55);
        ta.setEditable(false);
        ta.setFont(new Font("Courier new", Font.PLAIN, 16));
        ta.setLineWrap(true);
        add(ta);

        Map map = new Map();
        String mapString = map.multiArrayToString(map.smallMapToLargeMap(map.mapFileToSmallArray("Bane1.txt")));
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
            case KeyEvent.VK_L:
                player.printLocation();
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}