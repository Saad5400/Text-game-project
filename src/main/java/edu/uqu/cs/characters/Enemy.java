package edu.uqu.cs.characters;

import edu.uqu.cs.Utilities;
import edu.uqu.cs.Utilities.AnsiColor;

/**
 * A class representing an enemy character in the game.
 */
public class Enemy extends Character {

    /**
     * Constructs a new enemy with the specified name, health, and attack damage.
     *
     * @param name the name of the enemy
     * @param health the health of the enemy
     * @param attackDamage the attack damage of the enemy
     */
    public Enemy(String name, Double health, Double attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    /**
     * Prints a message indicating that the enemy has died.
     */
    public void die() { 
        System.out.println("\n----------------------------------------");
        Utilities.print(name + " has fallen dead.\n", AnsiColor.PURPLE);
        System.out.println("----------------------------------------");
    }
}