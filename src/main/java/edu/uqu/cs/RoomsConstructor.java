package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.*;

/**
 * This class is responsible for creating the rooms and their options.
 * It contains methods for creating different types of rooms and setting their
 * options.
 */
public class RoomsConstructor {

    // example room
    public Room createStartRoom() {
        // first create the object
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(0);
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
            App.setLastPlayedRoom(1);
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

                    Enemy skeleton = new Enemy("Skeleton", 100.0, 40.0);

                    Utilities.print("Fight started...\n");
                    Random random = new Random();

                    Scanner scnr = new Scanner(System.in);

                    for (int i = 0; i <= 30; i++) {
                        /* */
                        Utilities.print("You should enter a number between 1 to 3: ", AnsiColor.RED);

                        int answer = random.nextInt(3) + 1;
                        int input = scnr.nextInt();

                        if (input == answer) {
                            Utilities.print("your damage the skeleton ");
                            Utilities.print("40\n", AnsiColor.GREEN);

                            skeleton.health -= App.player.attackDamage;

                            if (skeleton.health > 0) {
                                Utilities.print(skeleton.health + "\n", AnsiColor.RED);
                            }
                        } else if (input != answer) {
                            Utilities.print("your damaged by skeleton ");
                            Utilities.print("40\n", AnsiColor.RED);

                            App.player.health -= skeleton.attackDamage;

                            if (skeleton.health > 0) {
                                Utilities.print(App.player.health + "\n", AnsiColor.GREEN);
                            }
                        }
                        if (App.player.health <= 0) {
                            i = 50;
                            Utilities.print("you dead\n", AnsiColor.RED);
                        }

                        if (skeleton.health <= 0) {
                            Utilities.print("you killed the skeleton\n", AnsiColor.GREEN);
                            i = 50;
                        }

                    }
                }));
        return room;
    }

    public Room exploreCastleRoom() {
        Room room = new Room();

        room.setEvent(() -> {
            App.setLastPlayedRoom(2);
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

    /**
     * Creats story room 1 for the current player.
     * 
     * @return room object representing the created story room
     */
    public Room storyRoom1() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(0);

            // print game title
            Utilities.print(
                    "  _____ _             __  __               __        ___              _____                        _    _   _ _        ____           _   \r\n"
                            + //
                            " |_   _| |__   ___   |  \\/  | __ _ _ __    \\ \\      / / |__   ___    | ____|_ __ __ _ ___  ___  __| |  | | | (_)___   |  _ \\ __ _ ___| |_ \r\n"
                            + //
                            "   | | | '_ \\ / _ \\  | |\\/| |/ _` | '_ \\    \\ \\ /\\ / /| '_ \\ / _ \\   |  _| | '__/ _` / __|/ _ \\/ _` |  | |_| | / __|  | |_) / _` / __| __|\r\n"
                            + //
                            "   | | | | | |  __/  | |  | | (_| | | | |    \\ V  V / | | | | (_) |  | |___| | | (_| \\__ \\  __/ (_| |  |  _  | \\__ \\  |  __/ (_| \\__ \\ |_ \r\n"
                            + //
                            "   |_| |_| |_|\\___|  |_|  |_|\\__,_|_| |_|     \\_/\\_/  |_| |_|\\___/   |_____|_|  \\__,_|___/\\___|\\__,_|  |_| |_|_|___/  |_|   \\__,_|___/\\__|\r\n"
                            + //
                            "                                                                                                                                          \n\n",
                    AnsiColor.PURPLE, 1, new Object[0]);

            Utilities.print(
                    "\nAban is found unconscious on the side of the road he was in bad condition. those who found "
                            + "him were a bunch of merchants that were on their way to the capital of the nation they took "
                            + "him to the nearest medic they found and as a payment they took his sword and went on "
                            + "their way.\n\n",
                    AnsiColor.ITALIC);
        });
        room.setOptions(
                new Option("Continue...", () -> {
                    storyRoom2().start();
                }));
        return room;
    }

    /**
     * Creats story room 2 for the current player.
     * 
     * @return room object representing the created story room
     */
    public Room storyRoom2() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(1);
            Utilities.print(
                    "\na week later Aban woke up tired angry and sad he was in misery he was told about what "
                            + "happened by the doctor Aban didn't totally forget what happened before he was found but it "
                            + "was all fussy, he wasn't truly out of the war yet\n\n",
                    AnsiColor.ITALIC);
        });
        room.setOptions(
                new Option("Continue...", () -> {
                    storyRoom3().start();
                }));
        return room;
    }

    /**
     * Creats story room 3 for the current player.
     * 
     * @return room object representing the created story room
     */
    public Room storyRoom3() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(2);
            Utilities.print(
                    "\nAban decided to follow the merchants that rescued him to take his sword back "
                            + "It was the only thing that he truly owned and cherished so he went on his way to the capital\n\n",
                    AnsiColor.ITALIC);

            room.setOptions(
                    new Option("Continue...", () -> {
                        stage1Room().start();
                    }));

        });
        return room;
    }

    /**
     * Creats stage 1 room when the player reaches the first stage.
     * 
     * @return room object representing the first stage room
     */
    public Room stage1Room() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(3);
            Utilities.print(
                    "\nAban finds an old man on the rode "
                            + "the old Man asks for help regarding a bear that is residing in the old man's farm "
                            + "and offer to pay aban to kill the bear\n\n",
                    AnsiColor.ITALIC);

            // here should be a fight
            Utilities.print(
                    " .'\"'.        ___,,,___        .'``.\r\n" + //
                            ": (\\  `.\"'\"```         ```\"'\"-'  /) ;\r\n" + //
                            " :  \\                         `./  .'\r\n" + //
                            "  `.                            :.'\r\n" + //
                            "    /        _         _        \\\r\n" + //
                            "   |         0}       {0         |\r\n" + //
                            "   |         /         \\         |\r\n" + //
                            "   |        /           \\        |\r\n" + //
                            "   |       /             \\       |\r\n" + //
                            "    \\     |      .-.      |     /\r\n" + //
                            "     `.   | . . /   \\ . . |   .'\r\n" + //
                            "       `-._\\.'.(     ).'./_.-'\r\n" + //
                            "           `\\'  `._.'  '/'\r\n" + //
                            "             `. --'-- .'\r\n" + //
                            "               `-...-'\n\n",
                    AnsiColor.BRIGHT_RED, 1, new Object[0]);

            // #region fight
            Random random = new Random();
            Enemy bear = new Enemy("bear",
                    (double) random.nextInt(51) + 100,
                    (double) random.nextInt(6) + 5);
            Utilities.println("You are fighting a wild bear with " + bear.health + " health");
            while (true) {
                Utilities.print("\nThe bear charges at you, you must dodge him");
                if (Utilities.quickTimeEvent("x", 10)) {
                    Utilities.println("\nYou dodged the bear");
                    Utilities.println("The bear smashed into a rock and got damaged 10 points");
                    bear.health -= 10;
                    Utilities.println("You notice the bear's health is " + bear.health
                            + " and his head is injuried");
                    break;
                } else {
                    Utilities.println("\nYou didn't dodge the bear");
                    Utilities.println("The bear smacked you but you used your shield, you got damaged 2 points");
                    App.player.health -= 2;
                    Utilities.println("You notice your health is " + App.player.health);
                }
            }
            // #endregion fight

            Utilities.print(
                    "You killed the bear.\n"
                            + "The Old man offers you his last bag of money as a Reward\n\n",
                    AnsiColor.ITALIC);

        });
        room.setOptions(
                // option 1
                new Option("Take the money", () -> {

                    System.out.println("You took the money for your self");
                    stage2Room().start();

                }),
                // option 2
                new Option("Refuse the money", () -> {

                    System.out.println("You left the money for the old man.");
                    stage2Room().start();
                }));
        return room;
    }

    /**
     * Creats stage 2 room when the player reaches the second stage.
     * 
     * @return room object representing the second stage room
     */
    public Room stage2Room() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(4);
            Utilities.print(
                    "\nAban decided to rest in a coastal town on his way to the capital "
                            + " at night the town was hit by a storm. "
                            + " a little girl ask him for help To find her older brother "
                            + "Aban found the brother in a bandit camp.\n"
            // Fight
                            + "you killed the kidnappers and rescue him\n\n",
                    AnsiColor.ITALIC);
            room.setOptions(
                    new Option("accompany them to the town", () -> {
                        System.out.println("you accompaned them to the town.");
                        stage3Room().start();

                    }),
                    new Option("leave them to go back alone", () -> {
                        System.out.println("you left them and contenude to the capital");
                        stage3Room().start();

                    })

            );
        });
        return room;
    }

    /**
     * Creats stage 3 room when the player reaches the third stage.
     * 
     * @return room object representing the third stage room
     */
    public Room stage3Room() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(5);
            Utilities.print(
                    "\nAban hear’s about a rich farmer that needed help with Something and offering a large reward in return "
                            + "The reward was a small land not to big but enough for one small family "
                            + "Aban takes the job\n"

            // Fight
                            + "Aban dose it perfect it wasn't more than a few rogue soldiers but as a consequence the sword he borrowed was broken\n\n",
                    AnsiColor.ITALIC);
            room.setOptions(
                    new Option("demand the reward to be in gold", () -> {

                        System.out.println("You took 1 bag of gold enoght to fix your sword");
                        finalstageRoom().start();

                    }),
                    new Option("take the land", () -> {

                        System.out.println("You took the land in hope that you use it in the fututer ");
                        System.out.println("You bowrrod some money to fix the sword.");
                        finalstageRoom().start();

                    }));

        });
        return room;

    }

    /**
     * Creats the final room when the player reaches the final stage.
     * 
     * @return room object representing the final stage room
     */
    public Room finalstageRoom() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(6);
            Utilities.print(
                    "\nAban reaches the capital and start his search for the merchants that took his sword "
                            + "Aban found out that the merchants were near the riverside looking for Something "
                            + "Aban confronted them to no one surprise they had powerful mercenary guarding them\n"

            // Final Boss
                            + " aban is president an offer by the mercenary after he wins to join his group\n\n"

            /*
             * :The ending depends on the player’s choices
             * :If most of the choices are B
             * Aban refuses the offer and decides to spear the merchants and decides to
             * settle and start over.
             * 
             * :If most of the choices are A
             * Aban accepts the mercenary offer then kills the merchants and take his sword
             * back choosing to continue to live as a soldier.
             * 
             */
            );

        });
        return room;
    }

}
