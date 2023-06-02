package edu.uqu.cs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.Callable;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.*;

/**
 * This class is responsible for creating the rooms and their options.
 * It contains methods for creating different types of rooms and setting their
 * options.
 */
public class RoomsConstructor {

    /**
     * Creates story room 1 for the current player.
     * 
     * @return room object representing the created story room
     */
    public Room storyRoom1() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(0);

            // print game title

            Utilities.print("\nWelcome to:\n", AnsiColor.UNDERLINE);
            Utilities.print("\n\r\n" + //
                    "    ______                         __\r\n" + //
                    "   / ____/________ _________  ____/ /\r\n" + //
                    "  / __/ / ___/ __ `/ ___/ _ \\/ __  / \r\n" + //
                    " / /___/ /  / /_/ (__  )  __/ /_/ /  \r\n" + //
                    "/_____/_/   \\__,_/____/\\___/\\__,_/   \r\n" + //
                    "                                     \r\n" + //
                    "\n",
                    AnsiColor.PURPLE, 5, new Object[0]);

            Utilities.print(
                    "\nAban is found unconscious on the side of the road he was in bad condition. those who found "
                            + "him were a bunch of merchants that were on their way to the capital of the nation. They took "
                            + "him to the nearest medic they found and as a payment they took his sword and went on "
                            + "their way...\n\n",
                    AnsiColor.ITALIC);
        });
        room.setOptions(
                new Option("Continue...", () -> {
                    storyRoom2().start();
                }));
        return room;
    }

    /**
     * Creates story room 2 for the current player.
     * 
     * @return room object representing the created story room
     */
    public Room storyRoom2() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(1);
            Utilities.print(
                    "\na week later Aban woke up tired, angry, and sad. He was in misery when he was told about what "
                            + "happened by the doctor. Aban didn't totally forget what happened before he was found, but it "
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
     * Creates story room 3 for the current player.
     * 
     * @return room object representing the created story room
     */
    public Room storyRoom3() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(2);
            Utilities.print(
                    "\nAban decided to follow the merchants that rescued him to take his sword back. "
                            + "It was the only thing that he truly owned and cherished, so he went on his way to the capital\n\n",
                    AnsiColor.ITALIC);

            room.setOptions(
                    new Option("Continue...", () -> {
                        stageRoom1().start();
                    }));

        });
        return room;
    }

    /**
     * Creates stage 1 room when the player reaches the first stage.
     * 
     * @return room object representing the first stage room
     */
    public Room stageRoom1() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(3);
            Utilities.print(
                    "\nAban finds an old man on the rode "
                            + "the old Man asks for help regarding a bear that is residing in the old man's farm, "
                            + "and offers to pay aban to kill the bear\n\n",
                    AnsiColor.ITALIC);

            // #region fight
            Random random = new Random();
            Enemy bear = new Enemy("bear",
                    (double) random.nextInt(51) + 100,
                    (double) random.nextInt(6) + 5);
            Utilities.println("You are fighting a wild bear with " + bear.health + " health\n", AnsiColor.RED);

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
                            "               `-...-'\n",
                    AnsiColor.BRIGHT_RED, 1, new Object[0]);

            while (true) {
                Utilities.println("\nThe bear charges at you, you must dodge him", AnsiColor.YELLOW);
                if (Utilities.quickTimeEvent("dodge", 10)) {
                    Utilities.println("\nYou dodged the bear", AnsiColor.BOLD);
                    Utilities.println("The bear smashed into a rock and got damaged 10 points", AnsiColor.ITALIC);
                    bear.takeDamage(10);
                    Utilities.println("You notice the bear's health is " + bear.health
                            + " and his head is injured", AnsiColor.ITALIC);
                    break;
                } else {
                    Utilities.println("\nYou didn't dodge the bear", AnsiColor.BOLD);
                    Utilities.println("The bear smacked you but you used your shield, you got damaged 2 points",
                            AnsiColor.ITALIC);
                    App.player.takeDamage(2);
                    Utilities.println("You notice your health is " + App.player.health, AnsiColor.ITALIC);
                }
            }
            while (true) {
                Utilities.println("\nYou see a chance to stick a sword in the bear's head", AnsiColor.YELLOW);
                if (Utilities.quickTimeEvent("stab", 5)) {
                    Utilities.println("\nYou stuck the knife in the bear's head", AnsiColor.BOLD);
                    Utilities.println("The bear is screaming in pain and got damaged 70 points", AnsiColor.ITALIC);
                    bear.takeDamage(70);
                    Utilities.println("You notice the bear's health is " + bear.health, AnsiColor.ITALIC);
                    break;
                } else {
                    Utilities.println("\nYou missed the bear's head", AnsiColor.BOLD);
                    Utilities.println("The bear scratched you, you got damaged 5 points", AnsiColor.ITALIC);
                    App.player.takeDamage(5);
                    Utilities.println("You notice your health is " + App.player.health, AnsiColor.ITALIC);
                }
            }
            while (true) {
                Utilities.println("\nThe bear is tired and about to die, finish him off!", AnsiColor.ITALIC);
                Utilities.println("You use your spear and try to throw it at the bear's heart", AnsiColor.YELLOW);
                if (Utilities.quickTimeEvent("throw", 5)) {
                    Utilities.println("\nThe spear hit the bear's heart!", AnsiColor.BOLD);
                    bear.die();
                    break;
                } else {
                    Utilities.println("\nYou missed the bear's heart", AnsiColor.BOLD);
                    Utilities.println("The bear tried to bite you but missed, you got damaged 3 points",
                            AnsiColor.ITALIC);
                    App.player.takeDamage(3);
                    Utilities.println("You notice your health is " + App.player.health, AnsiColor.ITALIC);
                }
            }
            Utilities.print("\nYou have won!\n\n", AnsiColor.GREEN);
            Utilities.println("You and the old man are celebrating and enjoying a well cooked bear meat",
                    AnsiColor.ITALIC);
            App.player.health = 50.0;
            Utilities.println("You notice your health is restored to " + App.player.health, AnsiColor.GREEN);
            // #endregion fight
            Utilities.println("\nThe Old man offers you his last bag of money as a Reward\n\n",
                    AnsiColor.ITALIC);

        });
        room.setOptions(
                // option 1
                new Option("Take the money", () -> {

                    System.out.println("You took the money for your self");
                    App.player.firstChoiceCount += 1;
                    stageRoom2().start();

                }),
                // option 2
                new Option("Refuse the money", () -> {

                    System.out.println("You left the money for the old man.");
                    App.player.secondChoiceCount += 1;
                    stageRoom2().start();
                }));
        return room;
    }

    /**
     * Creates stage 2 room when the player reaches the second stage.
     * 
     * @return room object representing the second stage room
     */
    public Room stageRoom2() {
        Room room = new Room();
        room.setEvent(() -> {
            App.setLastPlayedRoom(4);
            Utilities.println(
                    "\nAban decided to rest in a coastal town on his way to the capital. "
                            + "At night the town was hit by a storm. "
                            + "A little girl asked Aban for help to find her older brother. "
                            + "Aban found the brother in a bandit camp.",
                    AnsiColor.ITALIC);

            // #region fight
            Random random = new Random();

            Enemy abbas = new Enemy("Abbas", random.nextInt(31) + 20, random.nextInt(5) + 1);
            Enemy anwar = new Enemy("Anwar", random.nextInt(31) + 20, random.nextInt(5) + 1);
            Enemy fawzi = new Enemy("Fawzi", random.nextInt(31) + 20, random.nextInt(5) + 1);

            ArrayList<Enemy> aliveBandits = Utilities.asList(abbas, anwar, fawzi);

            Utilities.println("\nAban decided to fight the bandits and rescue the brother", AnsiColor.ITALIC);
            Utilities.println("You are fighting a group of bandits:\n", AnsiColor.RED);
            // Utilities.print(
            // " ccfMMW8W##tcc \r\n" + //
            // " czur*rvc\\ccjvrzB \r\n" + //
            // " Wx*rvzfzcrcnuztzc& \r\n" + //
            // " &M#8W88M8 &#&*M#x#vjvxu*r#W& &8W88M8M*& \r\n" + //
            // " WzvcrcztccnMB#&zMMz8&&&#8&cM#cM&BWnuzxzvrcuu8 \r\n" + //
            // " &Muzcfcvuvx#*c&WM&W##c&&MWWW*vzvrcvn#xzW* \r\n" + //
            // " 8&MMWzz*xzcuv\\cu/unx#xz*jWM*MW8& \r\n" + //
            // " \r\n" + //
            // " c#*8BB BB B&M#n \r\n" + //
            // " &Mc8W*Wzu*# 8j*M*WWMM* &&&*&z#W \r\n" + //
            // " &*nzcjccr*xczcccjcuc#z&8*&WWB& \r\n" + //
            // " &c*jczt*cncncztzcM *#n#& \r\n" + //
            // " Wn**xutuu(vcM 8u*jzv\\zvM \r\n" + //
            // " #/ccjvrvccB BB&&&B \r\n" + //
            // " &nccfcv*M& \r\n" + //
            // " 8ucjccr&B\n\n",
            // AnsiColor.BRIGHT_RED, 1, new Object[0]);

            // for (Enemy bandit : aliveBandits) {
            // Utilities.println(bandit.toString());
            // }

            class Attack {
                public String key;
                public String description;
                public int damage;

                public Attack(String key, String description, int damage) {
                    this.key = key;
                    this.description = description;
                    this.damage = damage;
                }

                public Attack(String description, int damage) {
                    this.description = description;
                    this.damage = damage;
                }
            }

            ArrayList<Attack> playerDefends = new ArrayList<>();
            playerDefends.add(new Attack("riposte", "Riposte with a quick counterattack", 20));
            playerDefends.add(new Attack("strike", "Strike the opponent with a quick blow", 15));
            playerDefends.add(new Attack("tackle", "Tackle the opponent to the ground", 25));
            playerDefends.add(new Attack("throw", "Throw the opponent off balance", 10));
            playerDefends.add(new Attack("grapple", "Grapple the opponent and immobilize them", 15));
            playerDefends.add(new Attack("sweep", "Sweep the opponent's legs", 10));
            playerDefends.add(new Attack("uppercut", "Uppercut the opponent", 20));
            playerDefends.add(new Attack("shove", "Shove the opponent back", 5));
            playerDefends.add(new Attack("stomp", "Stomp the opponent's foot", 10));
            playerDefends.add(new Attack("headbutt", "Headbutt the opponent", 15));

            String[] banditAttacks = {
                    " swings a spiked mace at you",
                    " thrusts a longsword at you",
                    " fires a heavy crossbow bolt at you",
                    " charges at you with a spear",
                    " throws a sharpened throwing axe at you",
                    " lashes out with a whip",
                    " ensnares you in a weighted net",
                    " blinds you with a handful of dirt",
                    " charges at you with a flaming torch",
                    " throws a javelin your way",
                    " strikes at you with a heavy mallet",
                    " attacks with a sharp halberd",
                    " throws a wickedly sharp dagger",
                    " raises a heavy warhammer to strike",
                    " charges at you with a spiked shield",
                    " swings a battle-axe at you",
                    " thrusts a short sword at you",
                    " fires a shortbow arrow at you",
                    " charges at you with a flail",
            };

            // while all the bandits are alive
            while (aliveBandits.size() > 0) {

                int attackers = random.nextInt(aliveBandits.size()) + 1;

                // each bandit attacks
                for (int i = 0; i < attackers; i++) {
                    int banditIndex = random.nextInt(aliveBandits.size());
                    Enemy bandit = aliveBandits.get(banditIndex);

                    Utilities.println(bandit.name + " is attacking you", AnsiColor.RED);
                    // get a random defend from the player
                    int defendIndex = random.nextInt(playerDefends.size());
                    Attack defend = playerDefends.get(defendIndex);
                    Utilities.println(defend.description, AnsiColor.YELLOW);

                    if (Utilities.quickTimeEvent(defend.key, 5)) {
                        Utilities.println("\nYou defended yourself", AnsiColor.BOLD);
                        Utilities.println("You damaged " + bandit.name + " " + defend.damage + " points",
                                AnsiColor.ITALIC);
                        bandit.takeDamage(defend.damage);
                        if (bandit.isAlive) {
                            Utilities.println("You notice " + bandit.name + "'s health is " + bandit.health,
                                    AnsiColor.ITALIC);
                        }
                    } else {
                        String attack = banditAttacks[random.nextInt(banditAttacks.length)];
                        Utilities.println("\nYou failed to defend yourself", AnsiColor.BOLD);
                        Utilities.println(bandit.name + attack + " and damaged you " + bandit.attackDamage + " points",
                                AnsiColor.ITALIC);
                        App.player.takeDamage(bandit.attackDamage);
                        Utilities.println("You notice your health is " + App.player.health, AnsiColor.ITALIC);
                        break;
                    }
                }
                ;

                // remove dead bandits
                for (Enemy bandit : new ArrayList<>(aliveBandits)) {
                    if (!bandit.isAlive) {
                        aliveBandits.remove(bandit);
                    }
                }
            }

            // #endregion fight

            Utilities.println("You have killed all the kidnappers and rescued the brother!!\n",
                    AnsiColor.GREEN);

            room.setOptions(
                    new Option("accompany them to the town", () -> {
                        System.out.println("you accompanied them to the town.");
                        App.player.firstChoiceCount += 1;
                        stageRoom3().start();

                    }),
                    new Option("leave them to go back alone", () -> {
                        System.out.println("you left them and continued to the capital");
                        App.player.secondChoiceCount += 1;
                        stageRoom3().start();

                    })

            );
        });
        return room;
    }

    /**
     * Creates stage 3 room when the player reaches the third stage.
     * 
     * @return room object representing the third stage room
     */
    public Room stageRoom3() {
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

                        System.out.println("You took 1 bag of gold enough to fix your sword");
                        finalStageRoom().start();

                    }),
                    new Option("take the land", () -> {

                        System.out.println("You took the land in hope that you use it in the future");
                        System.out.println("You bowered some money to fix the sword.");
                        finalStageRoom().start();

                    }));

        });
        return room;

    }

    /**
     * Creates the final room when the player reaches the final stage.
     * 
     * @return room object representing the final stage room
     */
    public Room finalStageRoom() {
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
