package edu.uqu.cs.characters;

/**
 * Character is the abstract base class for all game characters
 * which allows for creating multiple game characters
 * including players and enemies
 * A character encapsulates the state information needed for the various
 * game operations supported in the current version such as
 * character health based on attacks
 * @author Glitched Eagles
 * @version 1.0
 */
public abstract class Character {

    /**
     * The name of the character.
     */
    public String name;

    /**
     * The health of the character.
     */
    public double health;

    /**
     * The attack damage of the character.
     */
    public double attackDamage;

    /**
     * The state of the character.
     */
    public boolean isAlive = true;

    /**
     * Takes the specified amount of damage.
     *
     * @param damage the amount of damage to be taken
     */
    public void takeDamage(double damage) {
        health -= damage;
        if (health <= 0) {
            isAlive = false;
            die();
        }
    }

    /**
     * Performs the actions required when the character dies.
     */
    public abstract void die();
}