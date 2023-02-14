package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {


    @Test
    void deadCellWithThreeLiveNeighborsBecomesLiveCell() {
        int liveNeighbors = 3;
        Cell cell = new Cell(0);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(1);
    }

    @Test
    void liveCellWithMoreThanThreeLiveNeighborsDies() {
        int liveNeighbors = 4;
        Cell cell = new Cell(1);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(0);
    }
}

class Cell {

    private int state;

    public Cell(int state) {
        this.state = state;
    }

    public void updateState(int liveNeighbors) {
        if (liveNeighbors > 3) {
            this.state = 0;
        } else {
            this.state = 1;
        }
    }

    public int currentState() {
        return this.state;
    }
}
