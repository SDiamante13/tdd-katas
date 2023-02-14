package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    private static final Cell DEAD_CELL = new Cell(0);

    @Test
    void deadCellWithThreeLiveNeighborsBecomesLiveCell() {
        int liveNeighbors = 3;
        Cell cell = DEAD_CELL;

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(1);
    }
}

class Cell {

    private int state;

    public Cell(int state) {
        this.state = state;
    }

    public void updateState(int liveNeighbors) {
        this.state = 1;
    }

    public int currentState() {
        return this.state;
    }
}

// Grid of Cells with States
// 0 0 0       0 0 0
// 0 0 0  -->  0 0 0
// 1 1 0       0 0 0
