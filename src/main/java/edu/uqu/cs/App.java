package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Scanner;

import edu.uqu.cs.rooms.Room;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        /* Hint use this as your driver program */
        ArrayList<Room> rooms = new RoomsConstructer().rooms;

        rooms.get(0).start();
    }

}