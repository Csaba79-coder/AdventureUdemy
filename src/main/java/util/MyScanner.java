package util;

import java.util.Scanner;

public class MyScanner {

    private static Scanner scanner = new Scanner(System.in);
    private String text;

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        MyScanner.scanner = scanner;
    }
}
