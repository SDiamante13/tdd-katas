package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CellTest {

    @Test
    void deadCellWithExactly3LiveNeighborsBecomesLiveCell() {
        int liveNeighbors = 3;
        Cell cell = new Cell(State.DEAD);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.ALIVE);
    }

    @ParameterizedTest(name = "alive cell dies with {0} live neighbors")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9, 10})
    void aliveCellWithMoreThan3LiveNeighborsDies(int liveNeighbors) {
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.DEAD);
    }

    @ParameterizedTest(name = "alive cell dies with {0} live neighbors")
    @ValueSource(ints = {0, 1})
    void aliveCellWithFewerThan2LiveNeighborsDies(int liveNeighbors) {
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);
        assertThat(cell.currentState()).isEqualTo(State.DEAD);
    }

    @ParameterizedTest(name = "alive cell lives with {0} neighbors")
    @ValueSource(ints = {2, 3})
    void aliveCellWith2Or3LiveNeighborsLives(int liveNeighbors) {
        Cell cell = new Cell(State.ALIVE);

        cell.updateState(liveNeighbors);

        assertThat(cell.currentState()).isEqualTo(State.ALIVE);

    }
}
