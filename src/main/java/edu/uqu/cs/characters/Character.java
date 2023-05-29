package edu.uqu.cs.characters;

/**
 * An abstract class representing a character in the game.
 */
public abstract class Character {

    /**
     * The name of the character.
     */
    public String name;

    /**
     * The health of the character.
     */
    public Double health;

    /**
     * The attack damage of the character.
     */
    public Double attackDamage;

    /**
     * The critical rate of the character.
     */
    public Double critRate;

    /**
     * The critical damage of the character.
     */
    public Double critdamage;

    /**
     * Attacks the target character with the specified damage.
     *
     * @param damage the damage to be dealt
     * @param target the target character to be attacked
     */
    public void attack(double damage, Character target) {
        // print this attacked target
        target.takeDamage(damage);
    }

    /**
     * Takes the specified amount of damage.
     *
     * @param damage the amount of damage to be taken
     */
    public void takeDamage(double damage) {
        health -= damage;
        if (health <= 0) {
            die();
        }
    }

    /**
     * Performs the actions required when the character dies.
     */
    public abstract void die();
}