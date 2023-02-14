package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void deadCellWithThreeLiveNeighborsBecomesLiveCell() {
        int liveNeighbors = 3;
        Cell cell = new Cell(State.DEAD);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.ALIVE);
    }

    @Test
    void liveCellWithMoreThanThreeLiveNeighborsDies() {
        int liveNeighbors = 4;
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.DEAD);
    }
}

enum State {
    ALIVE,
    DEAD
}

class Cell {

    private State state;

    public Cell(State state) {
        this.state = state;
    }

    public void updateState(int liveNeighbors) {
        if (liveNeighbors > 3) {
            this.state = State.DEAD;
        } else {
            this.state = State.ALIVE;
        }
    }

    public State currentState() {
        return this.state;
    }
}
