package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GridTest {

    @Test
    void gridWith1LiveCellBecomesDeadCell() {
        Cell[][] cells = {{new Cell(State.ALIVE)}};
        Grid grid = new Grid(cells);

        grid.update();

        Cell[][] expectedCells = {{new Cell(State.DEAD)}};
        assertThat(grid.cells()).isEqualTo(expectedCells);
    }

    // need to know how many live neighbors a cell has
    // then can call cell.updateState(numberOfLiveNeighbors)
}

class Grid {

    private Cell[][] cells;

    public Grid(Cell[][] cells) {
        this.cells = cells;
    }

    public void update() {

    }

    public Cell[][] cells() {
        return this.cells;
    }
}
