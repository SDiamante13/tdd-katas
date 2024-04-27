package tictactoe;

import java.util.HashMap;
import java.util.Map;

import static tictactoe.Location.*;

public class Locations {

    private final Map<Location, Coordinate> locationCoordinateMap;

    public Locations() {
        this.locationCoordinateMap = new HashMap<>() {{
            put(ONE, new Coordinate(0, 0));
            put(TWO, new Coordinate(1, 0));
            put(THREE, new Coordinate(2, 0));
            put(FOUR, new Coordinate(0, 1));
            put(FIVE, new Coordinate(1, 1));
            put(SIX, new Coordinate(2, 1));
            put(SEVEN, new Coordinate(0, 2));
            put(EIGHT, new Coordinate(1, 2));
            put(NINE, new Coordinate(2, 2));
        }};
    }

    public Coordinate getCoordinate(Location location) {
        return locationCoordinateMap.get(location);
    }
}
