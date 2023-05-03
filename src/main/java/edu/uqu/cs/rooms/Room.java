package edu.uqu.cs.rooms;

import java.util.ArrayList;

import edu.uqu.cs.App;
import edu.uqu.cs.Utilities;
import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.Enemy;

public class Room {

    private String message;
    private ArrayList<Option> options = new ArrayList<Option>();
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private int playerChoice;

    public Room(String message, ArrayList<Option> options, ArrayList<Enemy> enemies) {
        this.message = message;
        this.options = options;
        this.enemies = enemies;
    }

    public Room(String message, ArrayList<Option> options) {
        this(message, options, new ArrayList<Enemy>());
    }

    public Room(String message) {
        this(message, new ArrayList<Option>(), new ArrayList<Enemy>());
    }

    public Room() {
        this("", new ArrayList<Option>(), new ArrayList<Enemy>());
    }

    public void start() {

        Utilities.print("%n%s%n%n", AnsiColor.WHITE, message);
        
        for (int i = 0; i < options.size(); i++) {
            Utilities.print((i+1) + ". " + options.get(i).text, AnsiColor.CYAN);
            Utilities.print();
        }
        Utilities.print();


        while (true) {

            Utilities.print("Enter your choice: ", AnsiColor.BLUE);

            try {

                Utilities.setColor(AnsiColor.PURPLE);
                playerChoice = App.scanner.nextInt();
                Utilities.resetColor();

                Utilities.print();
                if (playerChoice > options.size() || playerChoice <= 0){
                    Utilities.print("Your choice must be betweem 1 and " + options.size() + "!\n\n", AnsiColor.RED);
                }
                else {
                    break;
                }
            }
            catch (Exception e) {

                System.out.print(AnsiColor.RED);
                System.out.println("\nInvalid input!\n");
                App.scanner.nextLine();
            }
        }
        System.out.print(AnsiColor.RESET);
        options.get(playerChoice-1).action.run();

    }

    //#region Getters and Setters

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<Option> getOptions() {
        return options;
    }
    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }
    public void setOptions(Option... options) {
        this.options = Utilities.asList(options);
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public void setEnemies(ArrayList<Enemy> enemies) {
        this.enemies = enemies;
    }
    public void setEnemies(Enemy... enemies) {
        this.enemies = Utilities.asList(enemies);
    }

    //#endregion Getters and Setters

} 