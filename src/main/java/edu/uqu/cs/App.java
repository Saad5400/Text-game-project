package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.uqu.cs.rooms.Option;
import edu.uqu.cs.rooms.Room;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /* Hint use this as your driver program */
        Room room1 = new Room(
            "You just woke up",
            new ArrayList<Option>(Arrays.asList(
                    new Option("Go Outside",
                    () -> {
                        System.out.println("You are outside");
                    })
                )),
            null
        );
    }

}