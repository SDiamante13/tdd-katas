package tictactoe;

class TicTacToe {

    private final Grid grid;
    private Mark currentMark = Mark.X;

    public TicTacToe() {
        grid = new Grid();
    }

    public void take(char locationDto) {
        if (gameIsOver()) {
            return;
        }
        Location location = Location.of(locationDto);
        grid.placeMarkOn(currentMark, location);
        currentMark = currentMark.rotate();
    }

    private boolean gameIsOver() {
        return !grid.winStatus().isEmpty();
    }

    @Override
    public String toString() {
        return grid.print();
    }
}
