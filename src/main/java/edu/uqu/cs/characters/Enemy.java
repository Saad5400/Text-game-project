package edu.uqu.cs.characters;

public class Enemy extends Character {
    public Enemy(String name, Double health, Double attackDamage) {
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
    }

    public void die() {
        // die
    }
}
