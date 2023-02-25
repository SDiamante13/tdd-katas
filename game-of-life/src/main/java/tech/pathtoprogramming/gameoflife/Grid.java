package tech.pathtoprogramming.gameoflife;

class Grid {

    private final Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public void update() {
        for (var i = 0; i < cells[0].length; i++) {
            for (var j = 0; j < cells.length; j++) {
                cells[i][j].updateState(0);
            }
        }
    }

    public Cell[][] cells() {
        return this.cells;
    }
}
