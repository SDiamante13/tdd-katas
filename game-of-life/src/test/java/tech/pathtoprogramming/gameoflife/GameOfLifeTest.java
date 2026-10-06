package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    // test list:
    // ✅ given a grid of size 1x1 with a state cell, the cell should remain state
    // ✅ given a grid of size 1x1 with an alive cell, the cell should die
    // ✅ given grid of [1 0] -> [0 0]
    // make grid and cells easier to read during test failures (toString())
    // Approval tests might make this easier to read. Is this API hard to understand?
    // given grid of [1 1] -> [1 1]
                 //  [0 1] -> [0 1]
    // given grid of [1 1] -> [1 1]
                 //  [0 1] -> [1 1]

    @Test
    void aDeadCellWithNoNeighborsRemainsDead() {
        assertThat(new Grid(new Cell(State.DEAD,0,0)).nextIteration())
                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0)));
    }

    @Test
    void anIsolatedAliveCellWillDie() {
        assertThat(new Grid(new Cell(State.ALIVE,0,0)).nextIteration())
                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0)));
    }

    @Test
    void aDeadAndAliveCellNextToEachOtherWillBothDie() {
        assertThat(new Grid(new Cell(State.ALIVE,0,0), new Cell(State.DEAD,1,0)).nextIteration())
                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0), new Cell(State.DEAD, 1,0)));
    }

    @Test
    void displayGridAsStringFor1DArray() {
        assertThat(new Grid(new Cell(State.ALIVE,0,0), new Cell(State.DEAD,1,0)).toString())
                .isEqualTo("[1 0]");
        assertThat(new Grid(new Cell(State.ALIVE,0,0), new Cell(State.DEAD,1,0), new Cell(State.ALIVE,2,0)).toString())
                .isEqualTo("[1 0 1]");
    }
}
