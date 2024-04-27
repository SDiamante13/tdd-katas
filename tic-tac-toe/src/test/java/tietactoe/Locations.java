package tietactoe;

import java.util.HashMap;
import java.util.Map;

public class Locations {

    private final Map<Character, Coordinate> map;

    public Locations() {
        this.map = new HashMap<>() {{
            put('1', new Coordinate(0, 0));
            put('2', new Coordinate(1, 0));
            put('3', new Coordinate(2, 0));
            put('4', new Coordinate(0, 1));
            put('5', new Coordinate(1, 1));
            put('6', new Coordinate(2, 1));
            put('7', new Coordinate(0, 2));
            put('8', new Coordinate(1, 2));
            put('9', new Coordinate(2, 2));
        }};
    }

    public Coordinate getCoordinate(char location) {
        return map.get(location);
    }
}
