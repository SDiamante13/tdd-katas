package tictactoe;

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
        for (int count = 0; count < 3; count++) {
            if (squares[0][count] == squares[1][count] && squares[0][count] == squares[2][count]) {
                return "Player %s Wins!".formatted(squares[0][count]);
            }
            if (squares[count][0] == squares[count][1] && squares[count][0] == squares[count][2]) {
                return "Player %s Wins!".formatted(squares[count][0]);
            }
        }
        if (squares[0][0] == squares[1][1] && squares[0][0] == squares[2][2]) {
            return "Player %s Wins!".formatted(squares[0][0]);
        }

        if (squares[0][2] == squares[1][1] && squares[0][2] == squares[2][0]) {
            return "Player %s Wins!".formatted(squares[0][2]);
        }

        return "";
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
