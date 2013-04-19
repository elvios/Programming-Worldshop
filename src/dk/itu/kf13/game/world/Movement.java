/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Sarah de Voss
 */
public class Movement implements KeyListener {

    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
        
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
             System.out.println("left");
         }
         
         if (keyCode == KeyEvent.VK_RIGHT) {
             System.out.println("right");
         }
         
         if (keyCode == KeyEvent.VK_DOWN) {
             System.out.println("down");
         }
         
         if (keyCode == KeyEvent.VK_UP) {
             System.out.println("up");
         }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    public void test() {
        while (true) {
            keyPressed();
        }
    }

    
}
