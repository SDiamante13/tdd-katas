package tietactoe;

class TicTacToe {

    private final Grid grid;
    private Mark currentMark = Mark.X;

    public TicTacToe() {
        grid = Grid.initialize();
    }

    public void take(char location) {
        Coordinate coordinate = Coordinate.convertToCoordinate(location);
        grid.placeMarkOn(coordinate, currentMark);
        currentMark = currentMark.rotate();
    }

    @Override
    public String toString() {
        return grid.print();
    }
}
