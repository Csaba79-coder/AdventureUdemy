package bootstrap;

import model.Location;
import util.MyPrinter;
import util.MyScanner;

import java.util.HashMap;
import java.util.Map;

public class DataLoader {

    Map<Integer, Location> locations = new HashMap<>();
    String text = "Choose a num between 0-5: ";

    public void loadTestData() {

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        int loc = 1;
        while(true) {
            System.out.println(locations.get(loc).getDESCRIPTION());
            new MyPrinter().print(text);
            if(loc == 0) {
                break;
            }

            loc = MyScanner.getScanner().nextInt();

            // this one down bellow will give exception if you don' t type from 0-5 a num!!! just gives a NullPointerException!!!
            if(!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
