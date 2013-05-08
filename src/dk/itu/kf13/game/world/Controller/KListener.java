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

	public boolean left = false;
	public boolean right = false;
	public boolean up = false;
	public boolean down = false;

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
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	public void doNotMove() {
		left = right = up = down = false;
	}
}
