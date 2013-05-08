/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.View;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

/**
 *
 * @author Sarah de Voss
 */
public class Frame {

    // Sets the dimensions and title of the JFrame
    public int width = 1025;
    public int height = 620;
    String title = "Find an iPhone, iCharger, and an iWindmill in that iOrder.";
    JFrame jframe;
    Panel panel;

    public void createFrame() throws IOException, InterruptedException {
        // Sets the size and title
        jframe = new JFrame(title);
        jframe.setPreferredSize(new Dimension(width, height));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Loads the JPanel
        panel = new Panel();
        jframe.add(panel);

        // Draws the entire window
        jframe.pack();
        jframe.setVisible(true);

    }
}