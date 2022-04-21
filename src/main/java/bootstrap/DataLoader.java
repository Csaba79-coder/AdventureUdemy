package bootstrap;

import model.Location;
import util.MyPrinter;
import util.MyScanner;

import javax.swing.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DataLoader {

    Map<Integer, Location> locationsBeforeRefactor = new HashMap<>();
    Map<Integer, Location> locations = new HashMap<>();
    String newText = "Pls. type a letter as follows:";
    String text = "Choose a num between 0-5: ";

    public void loadTestData() {
        // codeBeforeRefactor();
        // automaticTestRunner();
        // testProgramRunning();
        showResultOfAdventureGameChallenge();
    }

    private void showResultOfAdventureGameChallenge() {
        // Challenge is:

        // Change the program to allow players to type full words, or phrases, then move to the
        // correct location based upon their input.
        // The player should be able to type commands such as "Go West", "run South", or just "East"
        // and the program will move to the appropriate location if there is one.  As at present, an
        // attempt to move in an invalid direction should print a message and remain in the same place.
        //
        // Single letter commands (N, W, S, E, Q) should still be available.

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        Map<String,String > vocabulary = new HashMap<>();

        vocabulary.put("QUIT", "Q");
        vocabulary.put("WEST", "W");
        vocabulary.put("NORTH", "N");
        vocabulary.put("EAST", "E");
        vocabulary.put("SOUTH", "S");

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDESCRIPTION());
            if (loc == 0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getEXITS();
            new MyPrinter().print(newText);
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = MyScanner.getScanner().nextLine().toUpperCase(Locale.ROOT);
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for (String word : words) {
                    if (vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            else {
                System.out.println("You cannot go in that direction");
            }
        }

    }

    private void testProgramRunning() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        // instead of put here all the exits, better to put it in the constructor, as it can be used anywhere in the code!
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        // locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        // locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        // locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        // locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        // locations.get(5).addExit("Q", 0);


        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDESCRIPTION());

            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getEXITS();
            new MyPrinter().print(newText);
            System.out.print("Available exits are: ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = MyScanner.getScanner().nextLine().toUpperCase(Locale.ROOT);

            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            else {
                System.out.println("You cannot go in that direction");
            }
        }
    }

    private void codeBeforeRefactor() {
        locationsBeforeRefactor.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locationsBeforeRefactor.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locationsBeforeRefactor.put(2, new Location(2, "You are at the top of a hill"));
        locationsBeforeRefactor.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locationsBeforeRefactor.put(4, new Location(4, "You are in a valley beside a stream"));
        locationsBeforeRefactor.put(5, new Location(5, "You are in the forest"));

        int loc = 1;
        while(true) {
            System.out.println(locationsBeforeRefactor.get(loc).getDESCRIPTION());
            new MyPrinter().print(text);
            if(loc == 0) {
                break;
            }

            loc = MyScanner.getScanner().nextInt();

            // this one down bellow will give exception if you don' t type from 0-5 a num!!! just gives a NullPointerException!!!
            if(!locationsBeforeRefactor.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }
    }

    private void automaticTestRunner() {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);


        String[] road = "You are standing at the end of a road before a small brick building".split(" ");
        for (String i : road) {
            System.out.println(i);
        }

        System.out.println("==================================");

        String[] building = "You are inside a building, a well house for a small spring".split(", ");
        for (String i : building) {
            System.out.println(i);
        }
    }
}
