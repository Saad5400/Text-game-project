package edu.uqu.cs.rooms;

import javax.swing.Action;

public class Option {
    public Runnable action;
    public String text;
    public Option(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }
}