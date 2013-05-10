/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Controller;

import dk.itu.kf13.game.world.View.Frame;
import dk.itu.kf13.game.world.View.Panel;

/**
 * @author Elvis Flesborg
 * @author Sarah de Voss
 */
public class DkItuKf13GameWorld {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        Frame frame = new Frame();
        Panel panel = new Panel();

        frame.createFrame();


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
