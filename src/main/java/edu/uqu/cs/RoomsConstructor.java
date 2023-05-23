package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.*;

public class RoomsConstructor {

    // This list will store all the rooms
    public ArrayList<Room> rooms = new ArrayList<Room>();

    public RoomsConstructor() {
        // create a room and add it to the list
        // each room can be created from a method that returns a new object of type Room
        rooms = new ArrayList<Room>(Utilities.asList(
                createStartRoom(), createGardenRoom(), exploreCastleRoom()));
    }

    // example room
    public Room createStartRoom() {
        // first create the object
        Room room = new Room();
        room.setEvent(() -> {
            Utilities.print("You just woke up in a dark and empty castle!\n\n", AnsiColor.GREEN);
        });
        // set its message
        // room.setMessage("You just woke up in a dark and empty castle!");
        // IMPORTANT: No more set message, use set event like above

        // set each option and its action
        room.setOptions(
                // option 1 // this is a lambda expression that will be called when the user
                // choose this option
                new Option("Go out", () -> {

                    System.out.println("You went out...");
                    // you can change rooms like this
                    createGardenRoom().start();

                }),
                // option 2
                new Option("Explore the castle", () -> {

                    System.out.println("You are exploring the castle...");
                    exploreCastleRoom().start();
                }));

        return room;
    }

    public Room createGardenRoom() {
        Room room = new Room();

        room.setEvent(() -> {
            Utilities.print("You are out in the garden!\n\n", AnsiColor.GREEN);
        });
        // room.setMessage("You are out in the garden!");
        // IMPORTANT: No more set message, use set event like above

        room.setOptions(
                new Option("Go back", () -> {

                    System.out.println("You went back...");
                    createStartRoom().start();

                }),
                new Option("Fight the skeleton", () -> {

                    App.player.health -= 10;
                    if (App.player.health <= 0) {
                        // Player is dead
                    }
                    Enemy enemy = new Enemy("Skeleton", 100.0, 40.0);
                    enemy.health -= App.player.attackDamage;

                    Utilities.print("Fight started...\n");
                    Random random = new Random();
                    int answer = random.nextInt(3) + 1;
                    Scanner scnr = new Scanner(System.in);

                    for (int i = 0; i < 3; i++) {
                        Utilities.print("You should enter a number between 1 to 3: ", AnsiColor.RED);
                        int input = scnr.nextInt();

                        if (input == answer) {
                            Utilities.print("your damage the skeleton");
                        } else if (input != answer) {
                            Utilities.print("your damaged\n", AnsiColor.RED);
                        }

                else {

                        }

                    }

                }));

        return room;
    }

    public Room exploreCastleRoom() {
        Room room = new Room();

        room.setEvent(() -> {
            Utilities.print("You are in the castle!\n\n", AnsiColor.GREEN);
        });
        // room.setMessage("You are in the castle");
        // IMPORTANT: No more set message, use set event like above

        room.setOptions(
                // option 1
                new Option("Go back", () -> {

                    System.out.println("You went back...");
                    createGardenRoom().start();

                }),
                // option 2
                new Option("Go ahead", () -> {

                    System.out.println("You going ahead...");

                }));

        return room;
    }

    public Room storyRoom1() {
        Room room = new Room();
        room.setEvent(() -> {
            Utilities.print(
                    "Aban is found unconscious on the side of the road he was in bad condition those who found"
                            + "him were a bunch of merchants that were on their way to the capital of the nation they took"
                            + "him to the nearest medic they found and as a payment they took his sword and went on"
                            + "their way.", AnsiColor.ITALIC);
        });
        room.setOptions(
            new Option("Continue...", () -> {
                // sotoryRoom2().start();
            })
        );
        return room;
    }
}