/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Controller;

import dk.itu.kf13.game.world.Model.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah de Voss
 */
public class KListener implements KeyListener {

    Player player;
    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            int KeyCode = e.getKeyCode();
                switch (KeyCode) {

                    case KeyEvent.VK_LEFT:
                        player.move(-1, 0);
                        System.out.println("hej");
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
            Logger.getLogger(KListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
