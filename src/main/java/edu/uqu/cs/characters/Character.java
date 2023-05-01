package edu.uqu.cs.characters;

public abstract class Character {

    public String name;

    // Stats
    public Double health;
    public Double attackDamage;

    public void attack(double damage, Character target) {
        // print this attacked target
        target.takeDamage(damage);
    }
    public void takeDamage(double damage) {
        health -= damage;
        if (health <= 0) {
            die();
        }
    }
    public abstract void die();
}
