package tech.pathtoprogramming.gameoflife;

class Grid {

    private final Cell[][] cells;

    public Grid(String initialState) {
        validate(initialState);
        this.cells = new Cell[1][1];
        constructGridFrom(initialState);
    }

    private void validate(String initialState) {
        if (null == initialState || "".equals(initialState)) {
            throw new IllegalArgumentException("Cannot have a empty grid of the game of life.");
        }
    }

    private void constructGridFrom(String initialState) {
        for (String s : initialState.split(" ")) {
            if ("O".equals(s)) {
                this.cells[0][0] = new Cell(State.ALIVE);
            }
        }
    }

    public void update() {
        for (var i = 0; i < cells[0].length; i++) {
            for (var j = 0; j < cells.length; j++) {
                int liveNeighbors = 0;
                Cell cell = this.cells[i][j];
                cell.updateState(liveNeighbors);
            }
        }
    }

    public String cells() {
        StringBuilder cellsAsString = new StringBuilder();
        for (var i = 0; i < this.cells[0].length; i++) {
            for (var j = 0; j < this.cells.length; j++) {
                cellsAsString.append("X");
            }
        }
        return cellsAsString.toString();
    }
}
