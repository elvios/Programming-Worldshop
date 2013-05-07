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

    public String getAppearance() {
        return appearance;
    } 
    public void move(int moveX, int moveY) throws IOException {
        
        // If the movementValue is below 1, one moves backwards.
        if ( movementValue < 1 ) {
            moveX = -moveX;
            moveY = -moveY;
            movementValue++;
        }
        
        // If the movementValue is above 1, one does not move.
        if ( movementValue > 1 ) {
            moveX = 0;
            moveY = 0;
            movementValue--;
        }
        
        // Creates temporary coordinates to calculate on.
        newX = x + moveX;
        newY = y + moveY;

        // The next steps are only run if the movementvalue is below or
        // equal to 1.
        // Because if it is above 1, one does not move.
        if ( moveX != 0 || moveY != 0 ) {

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
             
            // Loads the original map
            // TODO: this should be changed to what the map looks like
            // right now. Because if the tornado moves around, the new
            // location of the tornado will not be a part of _the_original_map_
            String[][] originalMap = map.getOriginalMap();

            String[][] smallMap = PanelAndKeyListenerAndMapConversion.smallMap;
            
            // Checks if the player is allowed to move here.
            legalMove = block.isMoveLegal(appearance, originalMap[newX][newY]);

            // Checks if the player gets any special movement.
            // (but only if the movement is allowed)
            if ( legalMove == true ) {
                block.specialMovement(appearance, smallMap[newX][newY]);
                x = newX;
                y = newY;
            }
        }
    }
}
