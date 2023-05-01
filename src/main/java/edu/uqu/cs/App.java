package edu.uqu.cs;

import java.util.Scanner;

import edu.uqu.cs.rooms.Option;
import edu.uqu.cs.rooms.Room;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /* Hint use this as your driver program */
        Option option1 = new Option(
            "Go outside",
            () -> {
                System.out.println("This is a lambda void method with no parameters and no return type.");
            }
        );
        Room room1 = new Room(
            "You just woke up in a dark empty castle\n" +
            "What do you want to do?\n\n"
        );
        Room outside = new Room(
            "You encountred a skeleton\n" +
            "What do you want to do?\n\n" +
            "1. Attack\n" +
            "2. Run\n"
        );
        Room insideCastle1 = new Room(
            "You encountred a zombie"
        );
    }

}