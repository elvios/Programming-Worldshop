/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

import java.io.IOException;

/**
 *
 * @author Sarah de Voss
 */
public class Player {

    private int x;
    private int y;
    private int newX;
    private int newY;
    public static int movementValue;
    private String appearance;
    private boolean legalMove;

    BlockFunctions block = new BlockFunctions();
    MapFunctions map = new MapFunctions();
    
    public Player(int startX, int startY, String startAppearance, int startMovementValue) {
        this.x = startX;
        this.y = startY;
        this.appearance = startAppearance;
        this.movementValue = startMovementValue;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
 
    public void move(int moveX, int moveY) throws IOException {
        
        // If the movementValue is below 1, one moves backwards.
        if ( movementValue < 1 ) {
            moveX = -moveX;
            moveY = -moveY;
            movementValue++;
        }
        
        // If the movementValue is above 1, one does not move.
        // (the movementValue is decremented as the last thing in this 
        // method, because of some problems).
        if ( movementValue > 1 ) {
            moveX = 0;
            moveY = 0;
        }
        
        // Creates temporary coordinates to calculate on.
        newX = x + moveX;
        newY = y + moveY;
        
        // These if-clauses check that we do not get out of bounds of the map.
        if(newX < 0){
            newX = 0;
        }
         if(newX > MapFunctions.MAP_WIDTH -1){
            newX = MapFunctions.MAP_WIDTH -1;
        } 
         if(newY < 0){
            newY = 0;
        } 
         if(newY > MapFunctions.MAP_HEIGHT -1){
            newY = MapFunctions.MAP_HEIGHT -1;
        }
        
        // Checks if the move is legal in terms of which blocks touches what.
        
        // Loads the original map
        String[][] originalMap = map.getOriginalMap();

        legalMove = true;
        
        if ( movementValue <= 1 ) {
            legalMove = block.isMoveLegal(appearance, originalMap[newX][newY]);
        }
        
        if ( legalMove == true ) {
            x = newX;
            y = newY;
        }
        
        // The movementValue is set down here rather than in the top of the 
        // method, because of issues.
        if ( movementValue > 1 ) {
            movementValue--;
        }
    }
    
    public String getAppearance() {
        return appearance;
    }
}
