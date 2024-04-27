package tietactoe;

class TicTacToe {

    private final Grid grid;
    private Mark currentMark = Mark.X;

    public TicTacToe() {
        grid = new Grid();
    }

    public void take(char location) {
        grid.placeMarkOn(currentMark, location);
        currentMark = currentMark.rotate();
    }

    @Override
    public String toString() {
        return grid.print();
    }
}
