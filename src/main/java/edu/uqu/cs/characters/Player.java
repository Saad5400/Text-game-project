package edu.uqu.cs.characters;

/**
 * A class representing the player character in the game.
 */
public class Player extends Character {

    double luck = 0.5;
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
        System.out.println("Game Over");
    } 
}