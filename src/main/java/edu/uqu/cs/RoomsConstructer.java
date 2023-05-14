package edu.uqu.cs;

import java.util.ArrayList;

import edu.uqu.cs.rooms.*;
import edu.uqu.cs.characters.*;

public class RoomsConstructer {

    // This list will store all the rooms
    public ArrayList<Room> rooms = new ArrayList<Room>();

    public RoomsConstructer() {
        // craete a room and add it to the list
        // each room can be created from a method that returns a new object of type Room
        rooms.add(createRoomStart());
        rooms.add(createRoomGarden());
    }

    // example room
    public Room createRoomStart() {
        // first create the object
        Room roomStart = new Room();
        // set its message
        roomStart.setMessage("You just woke up in a dark and empty castle!");
        // set each option and its action
        roomStart.setOptions(
            // option 1               // this is a lambda expression that will be called when the user choose this option
            new Option("Go out", () -> {

                System.out.println("You went out...");
                // you can change rooms like this
                createRoomGarden().start();

            }),
            // option 2                          
            new Option("Explore the castle", () -> {

                System.out.println("You are exploring the castle...");

            })
        );
        // this is useless for now
        roomStart.setEnemies(
            new Enemy("Enemy 1", 10.0, 10.0, 5.0, 5.0),
            new Enemy("Enemy 2", 10.0, 10.0, 5.0,5.0)
        );
        
        return roomStart;
    }

    public Room createRoomGarden() {
        Room roomGarden = new Room();
        roomGarden.setMessage("You are out in the garden!");
        roomGarden.setOptions(
            new Option("Go back", () -> {

                System.out.println("You went back...");
                createRoomStart().start();

            }),
            new Option("Fight the skeleton", () -> {

                System.out.println("Fight started...");

            })
        );

        return roomGarden;
    }
}
