package edu.uqu.cs;

import java.util.ArrayList;

import edu.uqu.cs.rooms.*;
import edu.uqu.cs.characters.*;

public class RoomsConstructer {

    public ArrayList<Room> rooms = new ArrayList<Room>();

    public RoomsConstructer() {
        rooms.add(createRoomStart());
        rooms.add(createRoomGarden());
    }

    public Room createRoomStart() {
        Room roomStart = new Room();
        roomStart.setMessage("You just woke up in a dark and empty castle!");
        roomStart.setOptions(
            new Option("Go out", () -> {

                System.out.println("You went out...");
                createRoomGarden().start();

            }),
            new Option("Explore the castle", () -> {

                System.out.println("You are exploring the castle...");

            })
        );
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
