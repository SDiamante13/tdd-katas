package tietactoe;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    private final Map<Coordinate, String> squares;

    public Grid() {
        this.squares = new HashMap<>();
        initialize();
    }

    private void initialize() {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                this.squares.put(new Coordinate(x, y), "_");
            }
        }
    }

    public void place(String mark, Coordinate coordinate) {
        squares.put(coordinate, mark);
    }

    String format() {
        String result = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                String square = squares.get(new Coordinate(x, y));
                result += "| %s ".formatted(square);
                if (x == 2) {
                    result += "|\n";
                }
            }
        }
        return "+---+---+---+\n" +
                result +
                "+---+---+---+\n";
    }
}
