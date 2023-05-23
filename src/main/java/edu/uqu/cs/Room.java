package edu.uqu.cs;

import java.util.ArrayList;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.Enemy;

public class Room {

    // for each room object we will store its message, options and enemies
    // see class Option and class Enemy
    /**
     * 
     * This class represents a room in a video game.
     * 
     * @author Bard
     */
    public class Room {

        /**
         * 
         * The event that will be run when the room starts.
         */
        private Runnable event;
        /**
         * 
         * The list of options available in the room.
         */
        private ArrayList<Option> options;
        /**
         * 
         * The user's choice of option.
         */
        private int playerChoice;

        /**
         * 
         * Creates a new room with an empty event and no options.
         */
        public Room() {
            this(new ArrayList<>());
        }

        /**
         * 
         * Creates a new room with the specified event and no options.
         * 
         * @param event The event that will be run when the room starts.
         */
        public Room(Runnable event) {
            this(new ArrayList<>(), event);
        }

        /**
         * 
         * Creates a new room with the specified options and no event.
         * 
         * @param options The list of options available in the room.
         */
        public Room(ArrayList<Option> options) {
            this(options, new ArrayList<>());
        }

        /**
         * 
         * Creates a new room with the specified options and event.
         * 
         * @param options The list of options available in the room.
         * @param event   The event that will be run when the room starts.
         */
        public Room(ArrayList<Option> options, Runnable event) {
            this.options = options;
            this.event = event;
        }

        /**
         * 
         * Starts the room.
         * 
         * This method will print the room's message, list the available options, and
         * get the user's choice.
         * 
         * The action of the chosen option will then be run.
         */

        private Runnable event = () -> {
        }; // empty event
        private ArrayList<Option> options = new ArrayList<Option>();

        // this will be used to store the user choice
        private int playerChoice;

        // #region Constructors
        public Room(ArrayList<Option> options, ArrayList<Enemy> enemies, Runnable event) {
            this.options = options;
            this.event = event;
        }

        public Room(ArrayList<Option> options, ArrayList<Enemy> enemies) {
            this(options, enemies, () -> {
            });
        }

        public Room(ArrayList<Option> options) {
            this(options, new ArrayList<Enemy>());
        }

        public Room() {
            this(new ArrayList<Option>());
        }
        // #endregion Constructors

        // this method will be called to start the room
        public void start() {

            // first print the message with white color using the print method in Utilities
            // class
            // it's very similiar to printf, but it will print in colors and add a typing
            // effect
            // see Utilities.java
            event.run();
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
                        Utilities.print("Your choice must be betweem 1 and " + options.size() + "!\n\n", AnsiColor.RED);
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

        // #region Getters and Setters

        public ArrayList<Option> getOptions() {
            return options;
        }

        public void setOptions(ArrayList<Option> options) {
            this.options = options;
        }

        public void setOptions(Option... options) {
            this.options = Utilities.asList(options);
        }

        public void setEvent(Runnable event) {
            this.event = event;
        }
        // #endregion Getters and Setters
    }
}