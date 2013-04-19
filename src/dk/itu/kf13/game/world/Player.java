/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

/**
 *
 * @author Sarah de Voss
 */
public class Player {

    private int x;
    private int y;
    private String appearance;
    
    public int[] getLocation() {
        int[] array = null;
        array[0] = x;
        array[1] = y;
        return array;
    }
    
    public void move(int moveX, int moveY) {
        x = x + moveX;
        y = y + moveY;
    }
    
    public String getAppearance() {
        return appearance;
    }
}