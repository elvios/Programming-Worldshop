/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.itu.kf13.game.world.Model;

import java.util.Random;

/**
 *
 * @author Sarah de Voss
 */
public class Enemy {

    private int x;
    private int y;
    private String[][] appearance;
    private int areaAX;
    private int areaAY;
    private int areaBX;
    private int areaBY;

    public Enemy(int sizeX, int sizeY, String letters, int startX, int startY,
            int AX, int AY, int BX, int BY) {

        areaAX = AX;
        areaAY = AY;
        areaBX = BX;
        areaBY = BY;
        x = startX;
        y = startY;

        appearance = new String[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                appearance[i][j] = letters.substring((sizeX * i) + j, (sizeX * i) + j + 1);
            }
        }
    }

    public void move() {
        Random rnd = new Random();
        int moveX = rnd.nextInt(3) - 1;
        int moveY = rnd.nextInt(3) - 1;

        // Creates temporary coordinates to calculate on.
        int newX = x + moveX;
        int newY = y + moveY;

        // The next steps are only run if the movementvalue is below or
        // equal to 1.
        // Because if it is above 1, one does not move.
        // These if-clauses check that we do not get out of bounds of the map.
        if (newX < areaAX) {
            newX = x;
        }
        if (newX > areaBX - appearance.length + 1) {
            newX = x;
        }
        if (newY < areaAY) {
            newY = y;
        }
        if (newY > areaBY - appearance[0].length + 1) {
            newY = y;
        }

        x = newX;
        y = newY;

    }

    public void placeInMapArray(String[][] smallMap, MapFunctions map) {
        // places the tornado
        for (int i = 0; i < appearance.length; i++) {
            for (int j = 0; j < appearance[0].length; j++) {

                // Prints the blocks that are not whitespaces.
                if (!appearance[i][j].equals(" ")) {
                    smallMap = map.replaceLetterInMapArray(
                            smallMap,
                            appearance[i][j],
                            x + j,
                            y + i);
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String[][] getAppearance() {
        return appearance;
    }
}
