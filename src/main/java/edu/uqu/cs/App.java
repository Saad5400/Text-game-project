package edu.uqu.cs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.Player;

public class App {

    public static Scanner scanner = new Scanner(System.in);

    public static Player player = new Player();

    private final static String SAVE_FILE_NAME = "save.txt";

    public static int getLastPlayedRoom() {
        try {
            File file = new File(SAVE_FILE_NAME);
            if (file.exists() && file.length() > 0) {
                // read the file and get the last played room
                Scanner fileScanner = new Scanner(file);
                int lastPlayedRoom = fileScanner.nextInt();
                fileScanner.close();
                return lastPlayedRoom;
            }
            file.createNewFile();
        } catch (IOException e) {
            Utilities.print("Error with file\n" + e.getMessage(), AnsiColor.RED);
        }
        return 0;
    }

    public static void setLastPlayedRoom(int roomIndex) {
        try {
            File file = new File(SAVE_FILE_NAME);
            if (!file.exists()) {
                getLastPlayedRoom();
            }
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(roomIndex + "");
            fileWriter.close();
        } catch (IOException e) {
            Utilities.print("Error with file\n" + e.getMessage(), AnsiColor.RED);
        }
    }

    public static void main(String[] args) {

        // Go to RoomsConstructer.java to see how this works
        ArrayList<Room> rooms = new RoomsConstructor().rooms;

        // starting the first room
        // got to rooms/Room.java and see the start method
        rooms.get(getLastPlayedRoom()).start();
    }

}