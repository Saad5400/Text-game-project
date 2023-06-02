package edu.uqu.cs;

import java.util.ArrayList;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.Enemy;

/**
 * Represents a room in the game. Each room object stores its message, options,
 * and enemies.
 * 
 * @version [Version]
 */
public class Room {

    
    /**
     * Represents an option available to the player in a room.
     */
    private Runnable event = () -> {
    };

    /**
     * The options available to the player in this room.
     */
    private ArrayList<Option> options = new ArrayList<Option>();

    
    /**
     * The index of the option chosen by the player.
     */
    private int playerChoice;

    //#region Constructors
    /**
     * Constructs a new Room object with the given options, enemies, and event.
     * 
     * @param options the options available to the player in this room
     * @param enemies the enemies present in this room
     * @param event   the event that occurs when the player enters this room
     */
    public Room(ArrayList<Option> options, ArrayList<Enemy> enemies, Runnable event) {
        this.options = options;
        this.event = event;
    }

    /**
     * Constructs a new Room object with the given options and enemies, and an empty
     * event.
     * 
     * @param options the options available to the player in this room
     * @param enemies the enemies present in this room
     */
    public Room(ArrayList<Option> options, ArrayList<Enemy> enemies) {
        this(options, enemies, () -> {
        });
    }

    /**
     * Constructs a new Room object with the given options and an empty list of
     * enemies and event.
     * 
     * @param options the options available to the player in this room
     */
    public Room(ArrayList<Option> options) {
        this(options, new ArrayList<Enemy>());
    }

    /**
     * Constructs a new Room object with an empty list of options, enemies, and
     * event.
     */
    public Room() {
        this(new ArrayList<Option>());
    }
    //#endregion Constructors

    /**
     * Starts the room by executing the event and displaying the available options
     * to the player.
     * The player's choice is stored in the `playerChoice` field.
     * 
     */
    public void start() {
        event.run();
        options.add(new Option("Reload last checkpoint", () -> {
            Utilities.print("Are you sure you want to reload the last checkpoint? (y/n): ", AnsiColor.BLUE);
            String choice = App.scanner.next();
            if (choice.equalsIgnoreCase("y")) {
                App.setLastPlayedRoom(App.getLastPlayedRoom() - 1);
                Utilities.print("Please restart the game.");
                System.exit(0);
            }
            options.remove(options.size() - 1);
            start();
        }));
        // add an option for exiting the game
        options.add(new Option("Close the game", () -> {
            Utilities.print("Are you sure you want to exit? (y/n): ", AnsiColor.BLUE);
            String choice = App.scanner.next();
            if (choice.equalsIgnoreCase("y")) {
                Utilities.print("Goodbye!", AnsiColor.RED);
                System.exit(0);
            }
            options.remove(options.size() - 1);
            start();
        }));
        // print the options with cyan color
        Utilities.print("Options:", AnsiColor.BRIGHT_CYAN);
        Utilities.print();
        // loop for each option and print its text
        for (int i = 0; i < options.size(); i++) {
            Utilities.print((i + 1) + ". " + options.get(i).text, AnsiColor.CYAN);
            Utilities.print();
        }
        // printing a new line
        Utilities.print();

        // now we will get the user choice, make sure it's valid and then run the action
        while (true) {

            Utilities.print("Enter your choice: ", AnsiColor.BLUE);

            try {
                // see Utilities.java
                Utilities.setColor(AnsiColor.PURPLE);
                playerChoice = App.scanner.nextInt();
                Utilities.resetColor();

                Utilities.print();

                // validate the user choice
                if (playerChoice > options.size() || playerChoice <= 0) {
                    Utilities.print("Your choice must be between 1 and " + options.size() + "!\n\n", AnsiColor.RED);
                } else {
                    // if the choice is valid, break the loop
                    break;
                }
            } catch (Exception e) {
                System.out.print(AnsiColor.RED);
                System.out.println("\nInvalid input!\n");
                App.scanner.nextLine();
            }
        }
        Utilities.resetColor();
        // run the action of the chosen option
        options.get(playerChoice - 1).action.run();
    }

    //#region Getters and Setters
    /**
     * Sets the options available to the player in this room.
     * 
     * @param options the options available to the player in this room
     */
    public void setOptions(Option... options) {
        this.options = Utilities.asList(options);
    }

    /**
     * Sets the event that occurs when the player enters this room.
     * 
     * @param event the event that occurs when the player enters this room
     */
    public void setEvent(Runnable event) {
        this.event = event;
    }
    //#endregion Getters and Setters
}