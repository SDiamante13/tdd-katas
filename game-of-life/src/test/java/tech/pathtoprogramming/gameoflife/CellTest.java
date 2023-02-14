package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void deadCellWithExactlyThreeLiveNeighborsBecomesLiveCell() {
        int liveNeighbors = 3;
        Cell cell = new Cell(State.DEAD);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.ALIVE);
    }

    @Test
    void aliveCellWithMoreThanThreeLiveNeighborsDies() {
        int liveNeighbors = 4;
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.DEAD);
    }

    @Test
    void aliveCellWithOneLiveNeighborsDies() {
        int liveNeighbors = 1;
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);
        assertThat(cell.currentState()).isEqualTo(State.DEAD);
    }

    @Test
    void aliveCellWithZeroLiveNeighborsDies() {
        int liveNeighbors = 0;
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);
        assertThat(cell.currentState()).isEqualTo(State.DEAD);
    }

    @Test
    void aliveCellWithTwoNeighborsLives() {
        int liveNeighbors = 2;
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.ALIVE);

    }

    @Test
    void aliveCellWithThreeNeighborsLives() {
        int liveNeighbors = 3;
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.ALIVE);
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
        if (liveNeighbors > 3 || liveNeighbors < 2) {
            this.state = State.DEAD;
        } else {
            this.state = State.ALIVE;
        }
    }

    public State currentState() {
        return this.state;
    }
}
