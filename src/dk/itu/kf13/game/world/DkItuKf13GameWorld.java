/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import dk.itu.kf13.game.world.View.Frame;
import dk.itu.kf13.game.world.View.Panel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah de Voss
 */
public class DkItuKf13GameWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        Frame frame = new Frame();
        Panel panel = new Panel();

			try {
				frame.createFrame();

			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			} catch (InterruptedException ex) {
				System.out.println(ex.getMessage());
			}

        // Main loop.
        while (true) {
            panel.repaint();
					try {
						Thread.sleep(20);
					} catch (InterruptedException ex) {
						System.out.println(ex.getMessage());
					}
        }
    }
}
