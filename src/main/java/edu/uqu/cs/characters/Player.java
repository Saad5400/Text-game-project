package edu.uqu.cs.characters;

import edu.uqu.cs.Utilities;
import edu.uqu.cs.Utilities.AnsiColor;

/**
 * A class representing the player character in the game.
 */
public class Player extends Character {

    /**
     * The number of times the player has chosen the first option in a choice.
     */
    public int firstChoiceCount = 0;

    /**
     * The number of times the player has chosen the second option in a choice.
     */
    public int secondChoiceCount = 0;
    /**
     * Constructs a new player with the default health, attack damage, critical rate, and critical damage.
     */
    public Player() {
        health = 50.0;
    }

    /**
     * Prints a message indicating that the player has died.
     */
    public void die() {
        Utilities.print("You have died. Game over.", AnsiColor.RED);
        System.exit(0);
    } 
}