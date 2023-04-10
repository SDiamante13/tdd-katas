package tech.pathtoprogramming.gameoflife;

class Grid {

    private final Cell[] cells;

    public Grid(String cellSymbols) {
        validate(cellSymbols);
        this.cells = new Cell[cellSymbols.length()];
        constructGridFrom(cellSymbols);
    }

    private void validate(String cellSymbols) {
        if (null == cellSymbols || "".equals(cellSymbols)) {
            // can check that string only contains O and X
            throw new IllegalArgumentException("Cannot have a empty grid of the game of life.");
        }
    }

    private void constructGridFrom(String cellSymbols) {
        String[] cellSymbolArray = cellSymbols.split("");
        for (int index = 0; index < cellSymbolArray.length; index++) {
            this.cells[index] = convertToCell(cellSymbolArray[index]);
        }
    }

    private Cell convertToCell(String cellSymbol) {
        if ("O".equals(cellSymbol)) {
            return new Cell(State.ALIVE);
        }
        if ("X".equals(cellSymbol)) {
            return new Cell(State.DEAD);
        }
        throw new IllegalArgumentException("Only Alive and Dead are allowed.");
    }

    public void update() {
        for (var index = 0; index < cells.length; index++) {
            updateCellAt(index);
        }
    }

    private void updateCellAt(int index) {
        Cell cell = this.cells[index];
        cell.updateState(getLiveNeighbors());
        this.cells[index] = cell;
    }

    private int getLiveNeighbors() {
        return 0;
    }

    public String cells() {
        StringBuilder cellsAsString = new StringBuilder();
        for (var index = 0; index < this.cells.length; index++) {
            cellsAsString.append(cells[index].currentState().symbol());
        }
        return cellsAsString.toString();
    }
}
