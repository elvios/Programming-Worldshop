/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

import dk.itu.kf13.game.world.Controller.KListener;
import dk.itu.kf13.game.world.View.Panel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah de Voss
 */
public class Player {

    public static int x;
    public static int y;
    private int newX;
    private int newY;
    public static int movementValue;
    private String appearance;
    private boolean legalMove;
		private int appearanceTimer;

		String[][] originalMap;
		String[][] smallMap;

    BlockFunctions block = new BlockFunctions();
    MapFunctions mapFunc = new MapFunctions();
    
		// Constructor
    public Player(int startX, int startY, String startAppearance, int startMovementValue) {
        this.x = startX;
        this.y = startY;
        this.appearance = startAppearance;
        this.movementValue = startMovementValue;
				this.appearanceTimer = 0;
    }
    

		public void update(KListener kListener) {
			if ( kListener.left ) {
				move(-1,0);
			}

			if ( kListener.right ) {
				move(1,0);
			}

			if ( kListener.up ) {
				move(0,-1);
			}

			if ( kListener.down ) {
				move(0,1);
			}

			if ( kListener.changeAppearance ) {
				appearance = "O";
				appearanceTimer = 20;
			}

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

    public void move(int moveX, int moveY) {

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

            // These if-clauses check that we do not get out of bounds of the mapFunc.
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

						// Loads the original mapFunc
						originalMap = mapFunc.getOriginalMap();

            smallMap = Panel.smallMap;
            
            // Checks if the player is allowed to move here.
            legalMove = block.isMoveLegal(appearance, originalMap[newX][newY]);

						// Moves if the movement is allowed.
            if ( legalMove == true ) {
                this.x = newX;
                this.y = newY;
            }
        }

    }
}
