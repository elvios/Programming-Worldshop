/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

/**
 *
 * @author Sarah de Voss
 */
public class BlockFunctions {

	// Array with the blocks that result in backwards movement.
    String[][] backwardsMovement = new String[][]{
        {"B", "T", "-5"},
        {"B", "U", "-5"},
        {"B", "V", "-5"}
    };

	// Array with the blocks that result in slow movement.
    String[][] slowMovement = new String[][]{
			{"B", "s", "5"}
    };

	// Array with legal movements.
    String[][] illegalMovement = new String[][]{
        {"B", "g"}
    };

	// Array with the blocks that result in a repawning.
    String[][] spawnMovement = new String[][]{
        {"B", "P"},
        {"O", "P"}
    };

    public boolean isMoveLegal(String blockA, String blockB) {

        for (int i = 0; i < illegalMovement.length; i++) {
            String first = illegalMovement[i][0];
            String second = illegalMovement[i][1];

            if (first.equals(blockA) && second.equals(blockB)) {
                return false;
            }
        }

        return true;
    }

    public void backwardsMove(String blockA, String blockB) {

			// Checks for BACKWARDS movement
        for (int i = 0; i < backwardsMovement.length; i++) {
            String first = backwardsMovement[i][0];
            String second = backwardsMovement[i][1];
            String third = backwardsMovement[i][2];

            if (first.equals(blockA) && second.equals(blockB)) {
                Player.movementValue = Integer.parseInt(third);
            }
        }
		}

		public void slowMove(String blockA, String blockB ) {

			// Checks for SLOW movement
        for ( int i = 0; i < slowMovement.length; i++ ) {
            String first = slowMovement[i][0];
            String second = slowMovement[i][1];
            String third = slowMovement[i][2];

            if (first.equals(blockA) && second.equals(blockB) && Player.movementValue <= 1) {
                Player.movementValue = Integer.parseInt(third);
            }
        }

		}

		public void spawnMove(String blockA, String blockB) {
			// Checks for SPAWN movement
        for (int i = 0; i < spawnMovement.length; i++) {
            String first = spawnMovement[i][0];
            String second = spawnMovement[i][1];

            if (first.equals(blockA) && second.equals(blockB)) {
                Player.x = 0;
                Player.y = 0;
            }
        }

    }
}
