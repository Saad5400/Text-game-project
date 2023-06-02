package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A class containing utility methods.
 */
public class Utilities {

    /**
     * This class contains ANSI escape codes for changing the color of text in the
     * console. See https://en.wikipedia.org/wiki/ANSI_escape_code for more
     * information.
     */
    public static class AnsiColor {
        public static final String RESET = "\u001B[0m";
        public static final String BLACK = "\u001B[30m";
        public static final String RED = "\u001B[31m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String BLUE = "\u001B[34m";
        public static final String PURPLE = "\u001B[35m";
        public static final String CYAN = "\u001B[36m";
        public static final String WHITE = "\u001B[37m";
        public static final String BLACK_BACKGROUND = "\u001B[40m";
        public static final String RED_BACKGROUND = "\u001B[41m";
        public static final String GREEN_BACKGROUND = "\u001B[42m";
        public static final String YELLOW_BACKGROUND = "\u001B[43m";
        public static final String BLUE_BACKGROUND = "\u001B[44m";
        public static final String PURPLE_BACKGROUND = "\u001B[45m";
        public static final String CYAN_BACKGROUND = "\u001B[46m";
        public static final String WHITE_BACKGROUND = "\u001B[47m";
        public static final String BOLD = "\u001B[1m";
        public static final String UNDERLINE = "\u001B[4m";
        public static final String ITALIC = "\u001B[3m";
        public static final String STRIKETHROUGH = "\u001B[9m";
        public static final String BLINK = "\u001B[5m";
        public static final String REVERSED = "\u001B[7m";
        public static final String INVISIBLE = "\u001B[8m";
        public static final String FRAMED = "\u001B[51m";
        public static final String ENCIRCLED = "\u001B[52m";
        public static final String OVERLINED = "\u001B[53m";
        public static final String BRIGHT_BLACK = "\u001B[90m";
        public static final String BRIGHT_RED = "\u001B[91m";
        public static final String BRIGHT_GREEN = "\u001B[92m";
        public static final String BRIGHT_YELLOW = "\u001B[93m";
        public static final String BRIGHT_BLUE = "\u001B[94m";
        public static final String BRIGHT_PURPLE = "\u001B[95m";
        public static final String BRIGHT_CYAN = "\u001B[96m";
        public static final String BRIGHT_WHITE = "\u001B[97m";
        public static final String BRIGHT_BLACK_BACKGROUND = "\u001B[100m";
        public static final String BRIGHT_RED_BACKGROUND = "\u001B[101m";
        public static final String BRIGHT_GREEN_BACKGROUND = "\u001B[102m";
        public static final String BRIGHT_YELLOW_BACKGROUND = "\u001B[103m";
        public static final String BRIGHT_BLUE_BACKGROUND = "\u001B[104m";
        public static final String BRIGHT_PURPLE_BACKGROUND = "\u001B[105m";
        public static final String BRIGHT_CYAN_BACKGROUND = "\u001B[106m";
        public static final String BRIGHT_WHITE_BACKGROUND = "\u001B[107m";
    }

    /**
     * The default delay between each character when printing a string.
     */
    public static final int DEFAULT_DELAY = 15;


    public static void println(String s) {
        print(s + "\n");
    }
    /**
     * Prints the formatted string to the console with the specified color and delay
     * between each character.
     * 
     * @param s     the string to print
     * @param color the color to use for the printed string, or null for the default
     *              color
     * @param delay the delay in milliseconds to wait before printing the next
     *              character
     * @param args  the arguments to use for formatting the string
     */
    public static void print(String s, String color, int delay, Object... args) {
        String formatted = String.format(s, args);
        double currentDelay = delay;
        double minDelay = 3;
        setColor(color);
        for (Character ch : formatted.toCharArray()) {
            System.out.print(ch);
            sleep((int) currentDelay);
            if (currentDelay > minDelay) {
                currentDelay -= 0.05;
            }
        }
        resetColor();
    }

    /**
     * Prints the formatted string to the console with the specified color and the
     * default delay between each character.
     * 
     * @param s     the string to print
     * @param color the color to use for the printed string, or null for the default
     *              color
     * @param args  the arguments to use for formatting the string
     */
    public static void print(String s, String color, Object... args) {
        print(s, color, DEFAULT_DELAY, args);
    }

    /**
     * Prints the formatted string to the console with the default color and delay
     * between each character.
     * 
     * @param s    the string to print
     * @param args the arguments to use for formatting the string
     */
    public static void print(String s, Object... args) {
        print(s, "", args);
    }

    /**
     * Prints the string to the console with the default color and delay between
     * each character.
     * 
     * @param s the string to print
     */
    public static void print(String s) {
        print(s, new Object[0]);
    }

    /**
     * Prints a newline character to the console.
     */
    public static void print() {
        print("\n");
    }

    /**
     * Sets the console color to the specified color.
     * 
     * @param color the color to set, as a string
     */
    public static void setColor(String color) {
        System.out.print(color);
    }

    /**
     * Resets the console color to the default color.
     */
    public static void resetColor() {
        System.out.print(AnsiColor.RESET);
    }

    /**
     * Makes the current thread sleep for the specified number of milliseconds.
     * 
     * @param ms the number of milliseconds to sleep
     */
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Converts an array of objects to an ArrayList of the same objects using
     * generics.
     * 
     * @param <T> the type of the objects in the array
     * @param a the array of objects to convert
     * @return an ArrayList of the same objects
     */
    public static <T> ArrayList<T> asList(T... a) {
        return new ArrayList<T>(Arrays.asList(a));
    }

    // javadoc

    /**
     * Takes a string and time, if the user enters the string within the time limit
     * then it returns true, else false.
     * @param ch
     * @param time
     * @return boolean
     */
    public static boolean quickTimeEvent(String ch, int time) {
        print("\n\nQuickly enter '" + ch + "' and click Enter!\n");
        print("You have only " + time + " seconds !\n");
        print();
        long startTime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        long endTime = System.currentTimeMillis();
        long timeElapsed = endTime - startTime;
        if (input.equalsIgnoreCase(ch) && timeElapsed < time * 1000.0) {
            return true;
        } else {
            return false;
        }
    }
}