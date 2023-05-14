package edu.uqu.cs.rooms;

// this class will be used to store the text and action of an option

public class Option {
    public Runnable action;
    public String text;
    public Option(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }
}