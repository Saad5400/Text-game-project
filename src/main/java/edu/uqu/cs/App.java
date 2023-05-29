package edu.uqu.cs;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import edu.uqu.cs.Utilities.AnsiColor;
import edu.uqu.cs.characters.Player;

/**
 * The main class of the game.
 */
public class App {

    /**
     * The scanner used to read input from the user.
     */
    public static Scanner scanner = new Scanner(System.in);

    /**
     * The player object representing the user in the game.
     */
    public static Player player = new Player();

    /**
     * The name of the file used to store the last played room.
     */
    private final static String SAVE_FILE_NAME = "save.txt";

    /**
     * Gets the index of the last played room from the save file.
     *
     * @return the index of the last played room, or 0 if the save file does not exist or is empty
     */
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

    /**
     * Sets the index of the last played room in the save file.
     *
     * @param roomIndex the index of the last played room
     */
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

    /**
     * The main method of the game.
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {

        // Go to RoomsConstructer.java to see how this works
        RoomsConstructor rc = new RoomsConstructor();

        Room[] rooms = {
                rc.createStartRoom(), // 0
                rc.exploreCastleRoom(), // 1
                rc.createGardenRoom(), // 2
                rc.storyRoom1(), // 3
                rc.storyRoom2(), // 4
                rc.storyRoom3(), // 5
                rc.stage1Room(), // 6
                rc.stage2Room(), // 7
                rc.stage3Room(), // 8
                rc.finalstageRoom(), // 9
        };

        // starting the first room
        // got to rooms/Room.java and see the start method
        rooms[getLastPlayedRoom()].start();
    }

}