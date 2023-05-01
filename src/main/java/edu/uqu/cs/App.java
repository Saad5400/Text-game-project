package edu.uqu.cs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import edu.uqu.cs.rooms.Option;
import edu.uqu.cs.rooms.Room;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static <T> ArrayList<T> asList(T... a) {
        return new ArrayList<>(Arrays.asList(a));
    }

    public static void main(String[] args) {

        /* Hint use this as your driver program */
        Room room1 = new Room(
            "You just woke up",
            asList(
                new Option("Go out", () -> {
                    System.out.println("You went out");
                }),
                new Option("go ahead", () -> {
                    System.out.println("hi");
                })
            ),
            null
        );

        room1.start();
    }

}