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
import edu.uqu.cs.characters.Character;

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

                    Utilities.println("You took the money for your self", AnsiColor.ITALIC);
                    App.player.secondChoiceCount += 1;
                    stageRoom2().start();

                }),
                // option 2
                new Option("Refuse the money", () -> {

                    Utilities.println("You left the money for the old man.", AnsiColor.ITALIC);
                    App.player.firstChoiceCount += 1;
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
            Utilities.print(
                    "                                                                                          \r\n" + //
                            "                             *jr*z            #z*fr*                                      \r\n"
                            + //
                            "                             1?\\1~c((*vv vcc|(u~((-(                                      \r\n"
                            + //
                            "z                           tn[{n?t\\[j}]v}[z][c[}u]}zf                                    \r\n"
                            + //
                            "                            ?z~<#<]f_1]_f]~#<+c?i <iu[                                    \r\n"
                            + //
                            "                           1{z}}z{{v}|f{\\f[n({x([z{[u}}#                                  \r\n"
                            + //
                            "                         jt|+v-?v[+ +[z-_z_1t]11]x}]n__#)                                 \r\n"
                            + //
                            "     #z#z                zct{c1)c(- ?{c[]z?(t}((}n{}u?{#u                      **c        \r\n"
                            + //
                            "    v(}n[fj/xj|*||*|# ##   ## ##  j#jxc/{n-/([/{r*jr#j  ## ##   ## #(#|/u\\tx/xj1f_|*      \r\n"
                            + //
                            "    x[1n[)([t(-c?]z-_ _}   j[#-?#j/#tj            tf*t/ ]?v[f   -?*?-#?{r[1/[t([j?]c      \r\n"
                            + //
                            "     cfx_[{-|{<c<+z<i >-z/\\      f/zt\\ |\\ -<z~<v/fu/rf/v      \\| <-x_+x>|)_\\~+u~_ |       \r\n"
                            + //
                            "        *jr{|1<c~+z<> >?u_~u<))1xf/zt/ \\\\ t\\*/\\ctfutrftuf~#<~#<> <?n-_n<|)-/~\\z\\#         \r\n"
                            + //
                            "              vfru)n)1n(}#}}*}[#})x1(f)f/)r}{z}) [[ 1{v1(t1tt[c)1n)/ //                   \r\n"
                            + //
                            "                  z*vv*vu }{#{}#{(x1{/[/([j-?z-[ _[ 1{c1|t)tcu#vv*v                       \r\n"
                            + //
                            "                                   *ucncvncxn#xn r                                        \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                      _j#t                             zxrcffz                            \r\n"
                            + //
                            "                      +[#_~#?rzr     r*    / t     *rn)(1-x?-n                            \r\n"
                            + //
                            "                      */#() **#*c*fjt}z1#  * [{z|c#c****f\\v\\c#        zc#cj|r(z           \r\n"
                            + //
                            "                      uv uu x\\v1-|?\\1~c~)zvu r?v_+u-\\ffccv*vv*  *n/t(j1?z[}zrr            \r\n"
                            + //
                            "                      x1#[]#[)u{{f1f\\[z[}z)] \\|c}[v}(/{/|{n1r*  *nuvncv*                  \r\n"
                            + //
                            "                        x)|(~v_-v]~ ~]z_+z+{t?{1?x[?x~+#[/   j?v_\\*#                      \r\n"
                            + //
                            "                           x]u+-u]< <]z_~z~{/?{1-r[-x~+#f     fz+-v<|                     \r\n"
                            + //
                            "                              nxr}c][z?- ?{v[]v?\\\\}\\(c  n ??#{?#r?n}1r)u                  \r\n"
                            + //
                            "                              vvu/*\\/*|< <]u__u~(({fc#  c 11 |1z+~x-}j-()v                \r\n"
                            + //
                            "                              ff\\}z[{*[[ [)c1}c}j**             cc#c(v\\*z#                \r\n"
                            + //
                            "                              uv1~c+_z<< <]v[[zn                                          \r\n"
                            + //
                            "                                [}z]]u]{n]( jvfz                                          \r\n"
                            + //
                            "                                 [z-_j]1t]|]]x}v                                          \r\n"
                            + //
                            "                                  r]1/]j([r]?v                                            \r\n"
                            + //
                            "                                  c/n|1#1)*{v\n",
                    AnsiColor.BRIGHT_RED, 1, new Object[0]);

            for (Enemy bandit : aliveBandits) {
                Utilities.println(bandit.toString());
            }

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

            Utilities.println("The brother gave you a health potion, you drank it and healed yourself",
                    AnsiColor.ITALIC);
            App.player.health = 100;
            Utilities.println("You notice your health is " + App.player.health, AnsiColor.GREEN);

            room.setOptions(
                    new Option("accompany them to the town", () -> {
                        Utilities.println("you accompanied them to the town.", AnsiColor.ITALIC);
                        App.player.firstChoiceCount += 1;
                        finalStageRoom().start();

                    }),
                    new Option("leave them to go back alone", () -> {
                        Utilities.println("you left them and continued to the capital", AnsiColor.ITALIC);
                        App.player.secondChoiceCount += 1;
                        finalStageRoom().start();

                    })

            );
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
            App.setLastPlayedRoom(5);
            Utilities.print(
                    "\nAban reaches the capital and start his search for the merchants that took his sword. "
                            + "Aban found out that the merchants were near the riverside looking for Something. "
                            + "Aban confronted them, but to no one surprise, they had a powerful companion guarding them\n",
                    AnsiColor.ITALIC);

            // #region fight
            Enemy companion = new Enemy("Companion", 100, 10);
            Utilities.println("You are fighting the powerful companion", AnsiColor.BOLD);
            Utilities.print(
                    "\n\n                                ct)z                jt/#                               \r\n" + //
                            "                                  u;#*]               *? n;                               \r\n"
                            + //
                            "                                  ?<  f\\              [z  `v                              \r\n"
                            + //
                            "                                  u;#  |             ct  u;                               \r\n"
                            + //
                            "                                   zf#    jffffffffu    cj#                               \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                                    1fz<)f|in   j>/t{<*t1                                 \r\n"
                            + //
                            "                                   {> ?,   ]!   \"1   \"{ !)                                \r\n"
                            + //
                            "                                   -+ n,r zI/{}t}I* j:v ~]                                \r\n"
                            + //
                            "                                   *~n  rjj#     *fjn  u+*                                \r\n"
                            + //
                            "                                     v#               #c                                  \r\n"
                            + //
                            "                                                            #u                            \r\n"
                            + //
                            "                                  #,*     *#              lx /~t                          \r\n"
                            + //
                            "                                  ~+      r>)            (:    |~r                        \r\n"
                            + //
                            "                                tl]         |lz        x><*     #1+n                      \r\n"
                            + //
                            "                             |_+1*                  /_+[c         #}_v                    \r\n"
                            + //
                            "                     x)))(                                           z\\\\\\\\\\\\\\\\\\*          \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                                      xu  #f#              f#  un                         \r\n"
                            + //
                            "         ?*        #]v  -             x\"j*;[               [;#/,u            #?           \r\n"
                            + //
                            "        \\f             1u     n/tz     u\",)     *t\\r        ?,,z              j|          \r\n"
                            + //
                            "       c[             n1    #<|ux[~     {:     ]-ru/ij       \"j                }c         \r\n"
                            + //
                            "       x#             r     cr    /*    n/     |    zt       (c                #x         \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "    *n             uz|[[[[[[[z             ;n                nc                  f        \r\n"
                            + //
                            "   t_             <x #*******   )>r       u`1               #?                   -        \r\n"
                            + //
                            "   \"j            t,  u}}}}}}|    *?!c    c,tIr              }c                   -        \r\n"
                            + //
                            "   i(            v, c\\\\\\\\\\\\\\\\x     z   z?:r zlij           u\\                    -        \r\n"
                            + //
                            "   #)x            x|vrrrrrrrrv         (f     n(#                                [        \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                     *unv   nv         r\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\/                                \r\n"
                            + //
                            "   )#           #,*_?[(\\1?-\\#][*                            x#                       l)   \r\n"
                            + //
                            "   ?#           )<##       *  v?[z                          x+-c                    };#   \r\n"
                            + //
                            "   ?#          /!*              c-]*                          u>c                v{l}     \r\n"
                            + //
                            "   ?#         //                  v-x                                          j-[r       \r\n"
                            + //
                            "   t#                                                                                     \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                                        r(z                                   *]|         \r\n"
                            + //
                            "     f_c                                 u}[{c                              #}_v          \r\n"
                            + //
                            "      v_~v                                 c{l/                           *}?u            \r\n"
                            + //
                            "        vc                              u]]1z    z!|                     |_c              \r\n"
                            + //
                            "            t\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\/z#         c u\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n"
                            + //
                            "r                \r\n" + //
                            "                                                                                          \r\n"
                            + //
                            "                            x                                #f                           \r\n"
                            + //
                            "                            ,     vn   []]!!]]|     c>      #!t                           \r\n"
                            + //
                            "                            ,    (?    cuu<~uu*     {+     #Ir                            \r\n"
                            + //
                            "                            ,    \"r    f));I))n    n:z      _{                            \r\n"
                            + //
                            "                            ,    ?}   j{{{;;{{{v  ({*        {[                           \r\n"
                            + //
                            "                            ;     rx                                                      \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                           u#                            v}u                              \r\n"
                            + //
                            "                         1nf1]zj1                    t?--[xu /t                           \r\n"
                            + //
                            "                        n1 (}{    n}}}}}}}x          *n|?__f  ]*                          \r\n"
                            + //
                            "                        - j]|v             j{{{{{{{{cx1rc\\_~r z]                          \r\n"
                            + //
                            "                       cv  #x1c                     #{]]}j#    x#                         \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                                                                                          \r\n"
                            + //
                            "                    #t      <x                                })        t#                \r\n"
                            + //
                            "                    {v      v!t                             #{!#        c}                \r\n"
                            + //
                            "                   x(        #\\?]v                        r?-j           (n               \r\n"
                            + //
                            "                   [                                                      )\n",
                    AnsiColor.BRIGHT_RED, 1, new Object[0]);
            Utilities.println("You notice the companion's health is " + companion.health, AnsiColor.ITALIC);

            Random rand = new Random();
            while (companion.isAlive) {
                boolean success = true;
                for (int i = 0; i < 3; i++) {
                    // get a random char
                    char c = (char) (rand.nextInt(26) + 'a');
                    // convert to String
                    String s = String.valueOf(c);
                    if (!Utilities.quickTimeEvent(s, 3)) {
                        success = false;
                        break;
                    }
                }
                ;
                if (success) {
                    Utilities.println("You have done a great damage to the companion!", AnsiColor.BOLD);
                    companion.takeDamage(20);
                    if (companion.isAlive) {
                        Utilities.println("You notice the companion's health is " + companion.health, AnsiColor.ITALIC);
                    }
                } else {
                    Utilities.println("The companion has done a great damage to you!", AnsiColor.BOLD);
                    App.player.takeDamage(10);
                    Utilities.println("You notice your health is " + App.player.health, AnsiColor.ITALIC);
                }
            }

            Utilities.println("You have defeated the companion!", AnsiColor.GREEN);
            Utilities.println("But he is still alive and is really tired.", AnsiColor.YELLOW);
            Utilities.println("\nWhat do you want to do?", AnsiColor.BRIGHT_CYAN);

            Utilities.println("1. Let him go", AnsiColor.CYAN);
            Utilities.println("2. Kill him\n", AnsiColor.CYAN);

            Utilities.print("Enter your choice: ", AnsiColor.BLUE);
            Utilities.setColor(AnsiColor.PURPLE);
            int playerChoice;

            while (true) {
                try {
                    playerChoice = App.scanner.nextInt();
                    break;
                } catch (Exception e) {
                    App.scanner.nextLine();
                    Utilities.println("Please enter a valid number!", AnsiColor.RED);
                    continue;
                }
            }
            Utilities.resetColor();

            switch (playerChoice) {
                case 1:
                    Utilities.println("You have let the companion go", AnsiColor.ITALIC);
                    App.player.firstChoiceCount += 1;
                    break;
                case 2:
                    Utilities.println("You have killed the companion", AnsiColor.ITALIC);
                    App.player.secondChoiceCount += 1;
                    break;
                default:
                    Utilities.println("You have unlocked a hidden ending!", AnsiColor.BOLD);
                    Utilities.println("Aban decided to join the merchants and fight along the companion",
                            AnsiColor.ITALIC);
                    Utilities.println("Leaving his memory behind, he started a new life...", AnsiColor.ITALIC);
                    Utilities.ending();
                    break;
            }

            Utilities.println("You retrieved your sword from the merchants, unlocking your forgotten past...",
                    AnsiColor.BOLD);
            if (App.player.firstChoiceCount > App.player.secondChoiceCount) {
                // print his memories
                Utilities.println(
                        "Aban remembered that he was a great warrior, he fought in countless battles under the Great King. Not only did he win a lot, but he also were smart and merciful warrior. Aban decided to return to the Great King to serve him once again!",
                        AnsiColor.ITALIC);
            } else {
                Utilities.println(
                        "Aban's past is meaningless, he used to be a nobody who will kill anyone for money. Aban is ashamed of his past and regret remembering it. Yet, he still cannot change himself, so he kills the merchants who saved his life and continues his journey...",
                        AnsiColor.ITALIC);
            }
            Utilities.ending();
        });
        return room;
    }

}
