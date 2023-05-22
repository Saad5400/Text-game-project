package edu.uqu.cs;

import java.util.ArrayList;
import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.*;

public class RoomsConstructer {

    // This list will store all the rooms
    public ArrayList<Room> rooms = new ArrayList<Room>();

    public RoomsConstructer() {
        // craete a room and add it to the list
        // each room can be created from a method that returns a new object of type Room
        rooms.add(createRoomStart());
    }

    // example room
    public Room createRoomStart() {
        // first create the object
        Room roomStart = new Room();
        roomStart.setEvent(() -> {
            Utilities.print("You just woke up in a dark and empty castle!\n\n", AnsiColor.GREEN);
        });
        // set its message
        // roomStart.setMessage("You just woke up in a dark and empty castle!");
        // IMPORTANT: No more set message, use set event like above

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
                exploreTheCastle().start();
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
        Utilities.print("You are out in the garden!\n\n", AnsiColor.GREEN);
        // roomGarden.setMessage("You are out in the garden!");
        // IMPORTANT: No more set message, use set event like above

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
    public Room exploreTheCastle(){
        Room room = new Room();

        room.setEvent(() -> {
            Utilities.print("You are in the castle!\n\n", AnsiColor.GREEN);
        });
        //room.setMessage("You are in the castle");
        // IMPORTANT: No more set message, use set event like above

        
        room.setOptions(
            // option 1
            new Option("Go back", () -> {

                System.out.println("You went back...");
                createRoomGarden().start();

            }),
            // option 2
            new Option("Go ahead", () -> {

                System.out.println("You going ahead...");
                

            })
        );


        return room;
    }
}
