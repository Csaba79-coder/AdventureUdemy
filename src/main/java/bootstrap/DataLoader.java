package bootstrap;

import model.Location;
import util.MyPrinter;
import util.MyScanner;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class DataLoader {

    Map<Integer, Location> locationsBeforeRefactor = new HashMap<>();
    Map<Integer, Location> locations = new HashMap<>();
    String newText = "Pls. type a letter as follows:";
    String text = "Choose a num between 0-5: ";

    public void loadTestData() {
        testProgramRunning();
    }

    private void testProgramRunning() {
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
        locations.get(1).addExit("Q", 0);

        locations.get(2).addExit("N", 5);
        locations.get(2).addExit("Q", 0);

        locations.get(3).addExit("W", 1);
        locations.get(3).addExit("Q", 0);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(4).addExit("Q", 0);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
        locations.get(5).addExit("Q", 0);


        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDESCRIPTION());
            new MyPrinter().print(newText);
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getEXITS();
            System.out.print("Available exits are ");
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
}
