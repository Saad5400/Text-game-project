package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Arrays;

public class Utilities {

    // all the colors that can be used in the console
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

    // default delay between printing characters
    public static final int DEFAULT_DELAY = 25;

    // print a string with a delay between each character
    public static void print(String s, String color, int delay, Object ... args) {
        String formatted = String.format(s, args);
        setColor(color);
        for (Character ch : formatted.toCharArray()) {
            System.out.print(ch);
            sleep(delay);
        }
        resetColor();
    }
    // overload
    public static void print(String s, String color, Object ... args) {
        print(s, color, DEFAULT_DELAY, args);
    }
    // overload
    public static void print(String s, Object ... args) {
        print(s, "", args);
    }
    // overload
    public static void print(String s) {
        print(s, null);
    }
    // overload
    public static void print() {
        print("\n");
    }

    // print a color (set a color)
    public static void setColor(String color) {
        System.out.print(color);
    }
    // print the reset color
    public static void resetColor() {
        System.out.print(AnsiColor.RESET);
    }

    // make the program sleep for a number of milliseconds
    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // take an array of objects and return an ArrayList of the same objects using generics
    public static <T> ArrayList<T> asList(T... a) {
        return new ArrayList<T>(Arrays.asList(a));
    }
}
