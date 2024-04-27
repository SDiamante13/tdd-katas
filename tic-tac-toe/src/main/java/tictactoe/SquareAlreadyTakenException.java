package tictactoe;

public class SquareAlreadyTakenException extends RuntimeException {

    public SquareAlreadyTakenException(Location location) {
        super("The square at location %s has already been taken.".formatted(location.number()));
    }
}
