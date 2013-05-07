/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world;

/**
 *
 * @author Sarah de Voss
 */
public class BlockFunctions {
    
    String[][] backwardsMovement = new String[][] {
        {"B", "T", "-5"},
        {"B", "U", "-5"},
        {"B", "V", "-5"}
    };
    
    String[][] slowMovement = new String[][] {
        {"B", "s", "10"}
            
    };
    
    String[][] legalMovement = new String[][] {
        {"B", "g"}
    };
    
    

    public boolean isMoveLegal(String blockA, String blockB) {

        for (int i = 0; i < legalMovement.length; i++) {
            String first = legalMovement[i][0];
            String second = legalMovement[i][1];
            
            if (first.equals(blockA) && second.equals(blockB)) {
                return false;
            }
        }

        return true;
    }

    public void specialMovement(String blockA, String blockB) {

        for (int i = 0; i < backwardsMovement.length; i++) {
            String first = backwardsMovement[i][0];
            String second = backwardsMovement[i][1];
            String third = backwardsMovement [i][2];
            
            if (first.equals(blockA) && second.equals(blockB)) {
                Player.movementValue = Integer.parseInt(third);
            }
        }
        
         for (int i = 0; i < slowMovement.length; i++) {
            String first = slowMovement[i][0];
            String second = slowMovement[i][1];
            String third = slowMovement [i][2];
            
            if (first.equals(blockA) && second.equals(blockB)) {
                Player.movementValue = Integer.parseInt(third);
            }
        }
    }
}
