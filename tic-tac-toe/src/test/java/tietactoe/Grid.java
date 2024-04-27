package tietactoe;

import static tietactoe.Mark.*;

public class Grid {

    private final char[][] squares = new char[3][3];
    private final Locations locations;

    public Grid() {
        this.locations = new Locations();
        initialize();
    }

    private void initialize() {
        int count = 1;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                squares[x][y] = Character.forDigit(count++, 10);
            }
        }
    }

    public String print() {
        String result = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                result += "| %s ".formatted(squares[x][y]);
                if (x == 2) {
                    result += "|\n";
                }
            }
        }
        return "+---+---+---+\n" +
                result +
                "+---+---+---+\n" +
                winStatus();
    }

    public String winStatus() {
        if (threeHorizontalSquaresTakenBySamePlayer()) {
            return "Player X Wins!";
        }
        return "";
    }

    private boolean threeHorizontalSquaresTakenBySamePlayer() {
        if (squares[0][0] == X.value() && squares[1][0] == X.value() && squares[2][0] == X.value()) {
            return true;
        }
        return false;
    }

    public void placeMarkOn(Mark mark, Location location) {
        Coordinate coordinate = locations.getCoordinate(location);
        validate(location, coordinate);
        squares[coordinate.x()][coordinate.y()] = mark.value();
    }

    private void validate(Location location, Coordinate coordinate) {
        if (squareIsAlreadyTakenAt(coordinate)) {
            throw new SquareAlreadyTakenException(location);
        }
    }

    private boolean squareIsAlreadyTakenAt(Coordinate coordinate) {
        char mark = squares[coordinate.x()][coordinate.y()];
        return !Character.isDigit(mark);
    }
}
