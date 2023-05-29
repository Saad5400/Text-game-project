package edu.uqu.cs.characters;

/**
 * A class representing an enemy character in the game.
 */
public class Enemy extends Character {

    /**
     * Constructs a new enemy with the specified name, health, attack damage, critical damage, and critical rate.
     *
     * @param name the name of the enemy
     * @param health the health of the enemy
     * @param attackDamage the attack damage of the enemy
     * @param critdamage the critical damage of the enemy
     * @param critRate the critical rate of the enemy
     */
    public Enemy(String name, Double health, Double attackDamage, double critdamage, double critRate) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.critRate = critRate;
        this.critdamage = critdamage;
    }

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
        this.critRate = 0.0;
        this.critdamage = 0.0;
    }

    /**
     * Prints a message indicating that the enemy has died.
     */
    public void die() {
        System.out.println("The enemy has disappeared");
    }
}