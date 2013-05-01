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
    
    public Player(int start_x, int start_y, String start_appearance) {
        this.x = start_x;
        this.y = start_y;
        this.appearance = start_appearance;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
 
    public void move(int moveX, int moveY) {
        x = x + moveX;
        y = y + moveY;
        
        //MapFunctions.legalMove(x,y, appearance) // true / false
        
                
                
        if(x < 0){
            x = 0;
        }
         if(x > MapFunctions.MAP_WIDTH -1){
            x = MapFunctions.MAP_WIDTH -1;
        } 
         if(y < 0){
            y = 0;
        } 
         if(y > MapFunctions.MAP_HEIGHT -1){
            y = MapFunctions.MAP_HEIGHT -1;
        }
    }
    
    public String getAppearance() {
        return appearance;
    }
    
    
}
