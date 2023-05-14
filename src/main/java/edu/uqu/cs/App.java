package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Scanner;

import edu.uqu.cs.rooms.Room;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Go to RoomsConstructer.java to see how this works
        ArrayList<Room> rooms = new RoomsConstructer().rooms;

        // starting the first room
        // got to rooms/Room.java and see the start method
        rooms.get(0).start();
    }

}