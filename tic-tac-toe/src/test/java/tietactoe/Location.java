package tietactoe;

import java.util.HashMap;
import java.util.Map;

public enum Location {
    ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9');

    private static final Map<Character, Location> map = new HashMap<>(values().length);

    static {
        for (Location location : values()) map.put(location.number, location);
    }

    private final char number;

    Location(char number) {
        this.number = number;
    }

    public char number() {
        return number;
    }

    public static Location of(char location) {
        Location result = map.get(location);
        if (result == null) {
            throw new IllegalArgumentException("Invalid location: " + location);
        }
        return result;
    }
}
