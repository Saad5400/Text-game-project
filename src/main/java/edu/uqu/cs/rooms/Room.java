package edu.uqu.cs.rooms;

import java.util.ArrayList;

import edu.uqu.cs.App;
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

    

    public void start(){
        System.out.println(message);

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i+1) + ". " + options.get(i).text);
        }
        System.out.println();

        while (true) {
            System.out.print("Enter your choice: ");
            try {
                playerChoice = App.scanner.nextInt();
                if (playerChoice > options.size() || playerChoice <= 0){
                    System.out.println("Enter a number between options: ");

                }
                else{
                    break;    
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input!");
            }
        }

        options.get(playerChoice-1).action.run();
    }





} 