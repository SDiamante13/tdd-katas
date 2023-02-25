package tech.pathtoprogramming.gameoflife;

class Grid {

    private final Cell[][] cells;

    public Grid(Cell[][] cells) {
        validate(cells);
        this.cells = cells;
    }

    private static void validate(Cell[][] cells) {
        if (isEmpty(cells)) {
            throw new IllegalArgumentException("Cannot have a empty grid of the game of life.");
        }
    }

    private static boolean isEmpty(Cell[][] cells) { // primitive obsession
        return cells == null || cells.length == 0 || cells[0].length == 0;
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
