package tech.pathtoprogramming.gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

record Grid(Cell... cells) {

    public Grid nextIteration() {
        List<Cell> list = new ArrayList<>();
        for (int x = 0; x < cells.length; x++) {
            Cell cell = cells[x];
            Cell applesauce = applesauce(cell);
            list.add(applesauce);
        }
        Cell[] newCells = list.toArray(new Cell[0]);
        return new Grid(newCells);
    }

    private static Cell applesauce(Cell cell) {
        return new Cell(State.DEAD, cell.x(), 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid = (Grid) o;
        return Arrays.equals(cells, grid.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }

    @Override
    public String toString() {
        List<String> cellStatesAsStrings = new ArrayList<>();
        for (int x = 0; x < cells.length; x++) {
            cellStatesAsStrings.add(cells[x].stateAsString());
        }
        String openingDelimiter = "[";
        String closingDelimiter = "]";
        return openingDelimiter + cellStatesAsStrings.stream().collect(Collectors.joining(" ")) + closingDelimiter;
    }
}
