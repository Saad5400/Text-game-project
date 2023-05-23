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
                storyRoom2().start();
            })
        );
        return room;
    }

    public Room storyRoom2() {
        Room room = new Room();
        room.setEvent(() -> {
            Utilities.print(
                    "a week later Aban woke up tired angry and sad he was in misery he was told about what"
                            + "happened by the doctor Aban didn't totally forget what happened before he was found but it"
                            + "was all fussy, he wasn't truly out of the war yet"
                            , AnsiColor.ITALIC);
        });
        room.setOptions(
            new Option("Continue...", () -> {
                 storyRoom3().start();
            })
        );
        return room;
    }

    public Room storyRoom3(){
        Room room = new Room();
        room.setEvent(()->{
            Utilities.print(
                    "Aban decided to follow the merchants that rescued him to take his sword back "
                    +"It was the only thing that he truly owned and cherished so he went on his way to the capital "
                    ,AnsiColor.ITALIC); 

                    room.setOptions(
                        new Option("Continue...", () -> {
                             stage1Room().start();
                        })
                    );


        });
        return room;
    }

        public Room stage1Room(){
            Room room = new Room();
            room.setEvent(()->{
                Utilities.print(
                    "Aban finds an old man on the rode" 
                    +"the old Man asks for help regarding a bear that is residing in the old man's farm and offer to pay aban to kill the bear aban kills the bear"

                    // here there should be a fight
                    +"you kill the bear."
                    +"The Old man offers you his last bag of money as a Reward"
                    ,AnsiColor.ITALIC);

                
            });  room.setOptions(
                // option 1 
                new Option("Take the money",() ->{

                    System.out.println("You took the money for your self");
                    stage2Room().start();

                

                }),
                //option 2
                new Option("Refuse the money",() ->{

                    System.out.println("You left the money for the old man.");
                    stage2Room().start();
        })
            ); 
            return room; 
    }
    

        public Room stage2Room(){
            Room room = new Room();
            room.setEvent( () ->{
                Utilities.print(
                    "Aban decided to rest in a coastal town on his way to the capital."
                    +" at night the town was hit by a storm. "
                    +" a little girl ask him for help To find her older brother Aban found the brother in a bandit camp. "
                    //Fight
                    +"you kill the kidnappers and rescue him",
                    AnsiColor.ITALIC);
                    room.setOptions(
                        new Option("accompany them to the town",() ->{
                            System.out.println("you accompaned them to the town.");
                            //stage3Room().start()

                        
                        }),
                        new Option("leave them to go back alone",() ->{
                            System.out.println("you left them and contenude to the capital");
                            //stage3Room().start()

                        })
                        
                    );  
            });
        return room; 
        } 
        
        








}
