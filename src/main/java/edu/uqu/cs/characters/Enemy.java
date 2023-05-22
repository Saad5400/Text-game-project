package edu.uqu.cs.characters;

public class Enemy extends Character {
    public Enemy(String name, Double health, Double attackDamage, double critdamage, double critRate) {
        // Enemy Stats is deffernt depneds on level
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.critRate = critRate;
        this.critdamage = critdamage;
    }
    public Enemy(String name, Double health, Double attackDamage) {
        // Enemy Stats is deffernt depneds on level
        this.name = name;
        this.health = health;
        this.attackDamage = attackDamage;
        this.critRate = 0.0;
        this.critdamage = 0.0;
    }

    // Die Message
    public void die() {
        System.out.println("The enemy has disappeared");
    }
}
