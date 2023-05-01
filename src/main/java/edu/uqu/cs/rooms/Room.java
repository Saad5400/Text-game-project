package edu.uqu.cs.rooms;

import java.util.ArrayList;

import edu.uqu.cs.App;
import edu.uqu.cs.characters.Enemy;

public class Room {

    public String message;

    public ArrayList<Enemy> enemies = new ArrayList<Enemy>();

    private int playerChoice;

    public Room(String message) {
        this.message = message;
        System.out.println(message);

        while (true) {
            try {
                playerChoice = App.scanner.nextInt();
                break;
            }
            catch (Exception e) {
                System.out.println("Invalid input");
            }
        }

        
    }

    

    public void Start(){
        // prints
    }





} 