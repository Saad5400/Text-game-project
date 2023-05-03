package edu.uqu.cs;

import java.util.ArrayList;
import java.util.Arrays;

public class Utilities {

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
    }

    public static final int DEFAULT_DELAY = 25;

    public static void print(String s, String color, int delay, Object ... args) {
        String formatted = String.format(s, args);
        setColor(color);
        for (Character ch : formatted.toCharArray()) {
            System.out.print(ch);
            sleep(delay);
        }
        resetColor();
    }
    public static void print(String s, String color, Object ... args) {
        print(s, color, DEFAULT_DELAY, args);
    }
    public static void print(String s, Object ... args) {
        print(s, AnsiColor.RESET, args);
    }
    public static void print(String s) {
        print(s, null);
    }
    public static void print() {
        print("\n");
    }

    public static void setColor(String color) {
        System.out.print(color);
    }
    public static void resetColor() {
        System.out.print(AnsiColor.RESET);
    }

    public static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static <T> ArrayList<T> asList(T... a) {
        return new ArrayList<T>(Arrays.asList(a));
    }
}
