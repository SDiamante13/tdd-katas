package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    // test list:
    // given a grid of size 1x1 with a dead cell, the cell should remain dead

    enum State {
        DEAD
    }
    record Grid(Cell cell) {

        public Grid nextIteration() {
            return new Grid(new Cell(State.DEAD, 0,0));
        }
    }

    record Cell(State dead, int x, int y) {}

    @Test
    void aDeadCellWithNoNeighborsRemainsDead() {
        assertThat(new Grid(new Cell(State.DEAD,0,0)).nextIteration())
                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0)));
    }
}
