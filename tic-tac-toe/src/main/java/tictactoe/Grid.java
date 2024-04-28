package tictactoe;

import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class Grid {

    private static final String PLAYER_WINS_MESSAGE = "Player %s Wins!";
    private static final String TIE_GAME_MESSAGE = "Game Over - TIE!";
    private static final String GAME_IN_PROGRESS_MESSAGE = "";

    // TODO: Could use Mark[][] where the possible choices are X, O, 1-9
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
        String result = formatSquares();
        return "+---+---+---+\n" +
                result +
                "+---+---+---+\n" +
                winStatus();
    }

    private String formatSquares() {
        String result = "";
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                result += "| %s ".formatted(squares[x][y]);
                if (x == 2) {
                    result += "|\n";
                }
            }
        }
        return result;
    }

    public String winStatus() {
        for (int count = 0; count < 3; count++) {
            if (squares[0][count] == squares[1][count] && squares[0][count] == squares[2][count]) {
                return PLAYER_WINS_MESSAGE.formatted(squares[0][count]);
            }
            if (squares[count][0] == squares[count][1] && squares[count][0] == squares[count][2]) {
                return PLAYER_WINS_MESSAGE.formatted(squares[count][0]);
            }
        }
        if (squares[0][0] == squares[1][1] && squares[0][0] == squares[2][2]) {
            return PLAYER_WINS_MESSAGE.formatted(squares[0][0]);
        }

        if (squares[0][2] == squares[1][1] && squares[0][2] == squares[2][0]) {
            return PLAYER_WINS_MESSAGE.formatted(squares[0][2]);
        }
        if (areAllSpacesTaken()) {
            return TIE_GAME_MESSAGE;
        }

        return GAME_IN_PROGRESS_MESSAGE;
    }

    private boolean areAllSpacesTaken() {
        return range(0, 3)
                .noneMatch(y -> range(0, 3)
                        .anyMatch(x -> Character.isDigit(squares[x][y])));
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
