package edu.uqu.cs.characters;

public class Player extends Character {

    // Player Stats
    public Player() {
        health = 100.0;
        attackDamage = 40.0;
        critRate = 10.0;
        critdamage = 50.0;
    }

    // Die Message
    public void die() {
        System.out.println("Game Over");
    } 
}