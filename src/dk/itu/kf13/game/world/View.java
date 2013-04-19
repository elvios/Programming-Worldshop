/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Sarah de Voss
 */
public class View {
    
    public int width = 300;
    public int height = 300;
    String title = "Game title";
    
    JFrame jframe;
    
    
    public void createFrame() {
        // Sets the size and title
        jframe = new JFrame(title);
        jframe.setPreferredSize(new Dimension(width,height));
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Loads the JPanel
        Panel panel = new Panel();
        jframe.add(panel);
        
        // Draws the entire window
        jframe.pack();
        jframe.setVisible(true);
        
    }
    
}
