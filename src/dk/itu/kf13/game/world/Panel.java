/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Sarah de Voss
 */
public class Panel extends JPanel implements KeyListener {

    Player player = new Player(0, 0, "B");
    
    
    // This is the constructor
    public Panel() {
        super();
        addKeyListener(this);
        
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