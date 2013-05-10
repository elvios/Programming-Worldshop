/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author Elvis Flesborg
 * @author Sarah de Voss
 */
public class KListener implements KeyListener {

    public boolean left = false;
    public boolean right = false;
    public boolean up = false;
    public boolean down = false;
    public boolean changeAppearance = false;

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int KeyCode = e.getKeyCode();
        switch (KeyCode) {

            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_A:
                changeAppearance = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void doNotMove() {
        left = right = up = down = false;
    }
}
