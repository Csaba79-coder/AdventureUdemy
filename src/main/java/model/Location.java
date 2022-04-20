package model;

import java.util.HashMap;
import java.util.Map;

public class Location {

    private final int LOCATION_ID;
    private final String DESCRIPTION;
    private final Map<String, Integer> EXITS;

    public Location(int LOCATION_ID, String DESCRIPTION) {
        this.LOCATION_ID = LOCATION_ID;
        this.DESCRIPTION = DESCRIPTION;
        this.EXITS = new HashMap<>();
    }

    public void addExit(String direction, int location) {
        EXITS.put(direction, location);
    }

    public int getLOCATION_ID() {
        return LOCATION_ID;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public Map<String, Integer> getEXITS() {
        return new HashMap<>(EXITS);
        //return EXITS;
    }
}
