package tech.pathtoprogramming.gameoflife;

class Grid {

    private final Cell[][] cells;

    public Grid(String cellSymbols) {
        validate(cellSymbols);
        int rowLength = deriveRowLength(cellSymbols);
        int columnLength = deriveColumnLength(cellSymbols);
        this.cells = new Cell[rowLength][columnLength];
        constructGridFrom(cellSymbols);
    }

    private void validate(String cellSymbols) {
        if (null == cellSymbols || "".equals(cellSymbols)) {
            // can check that string only contains O and X
            throw new IllegalArgumentException("Cannot have a empty grid of the game of life.");
        }
    }

    private int deriveRowLength(String cellSymbols) {
        return cellSymbols.split("\n")[0].length();
    }

    private int deriveColumnLength(String cellSymbols) {
        return cellSymbols.split("\n").length;
    }

    private void constructGridFrom(String cellSymbols) { //XX\nXX
        String[] rows = cellSymbols.split("\n");
        for (int row = 0; row < rows.length; row++) {
            String[] cellSymbolArray = rows[row].split("");
            for (int index = 0; index < cellSymbolArray.length; index++) {
                this.cells[index][row] = convertToCell(cellSymbolArray[index]);
            }
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
        Cell cell = this.cells[index][0];
        cell.updateState(getLiveNeighbors());
        this.cells[index][0] = cell;
    }

    private int getLiveNeighbors() {
        return 0;
    }

    public String cells() {
        StringBuilder cellsAsString = new StringBuilder();

        for (var row = 0; row < this.cells[0].length; row++) {
            for (var index = 0; index < this.cells.length; index++) {
                cellsAsString.append(cells[index][row].currentState().symbol());
            }
        }
        return cellsAsString.toString();
    }
}
