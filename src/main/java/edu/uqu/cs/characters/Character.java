package edu.uqu.cs.characters;

public abstract class Character {

    public String name;

    // Stats
    public Double health;
    public Double attackDamage;
    public Double critRate;
    public Double critdamage;

    public void attack(double damage, Character target) {
        // print this attacked target
        target.takeDamage(damage);
    }
    // Damage System
    public void takeDamage(double damage) {
        health -= damage;
        if (health <= 0) {
            die();
        }
    }
    public abstract void die();
}