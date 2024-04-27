package tietactoe;

class TicTacToe {

    Grid grid;

    public TicTacToe() {
        this.grid = new Grid();
    }

    @Override
    public String toString() {
        return grid.format();
    }
}
