package tietactoe;

import java.util.HashMap;
import java.util.Map;

public class Grid {

    // TODO: Map<Coordinate, Square | Mark>
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

    // TODO: Mark can be enum ['X' 'O' '_']
    public void place(String mark, Coordinate coordinate) {
        if (squareIsEmptyAt(coordinate)) {
            squares.put(coordinate, mark);
        }
    }

    private boolean squareIsEmptyAt(Coordinate coordinate) {
        String square = squares.get(coordinate);
        return square.equals("_");
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
