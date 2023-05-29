package edu.uqu.cs;

/**
 * A class representing an option in a menu.
 */
public class Option {
    
    /**
     * The action to be performed when the option is selected.
     */
    public Runnable action;
    
    /**
     * The text to be displayed for the option.
     */
    public String text;
    
    /**
     * Constructs a new option with the specified text and action.
     *
     * @param text the text to be displayed for the option
     * @param action the action to be performed when the option is selected
     */
    public Option(String text, Runnable action) {
        this.text = text;
        this.action = action;
    }
}