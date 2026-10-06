package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    // test list:
    // ✅ given a grid of size 1x1 with a dead cell, the cell should remain dead
    // ✅ given a grid of size 1x1 with an alive cell, the cell should die
    // given grid of [1 0] -> [0 0]
    // given grid of [1 1] -> [1 1]
                 //  [0 1] -> [0 1]
    // given grid of [1 1] -> [1 1]
                 //  [0 1] -> [1 1]

    enum State {
        ALIVE, DEAD
    }
    record Grid(Cell... cells) {

        public Grid nextIteration() {
            return new Grid(new Cell(State.DEAD, 0,0));
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
    }

    record Cell(State dead, int x, int y) {}

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

//    @Test
//    void aDeadAndAliveCellNextToEachOtherWillBothDie() {
//        assertThat(new Grid(new Cell(State.ALIVE,0,0), new Cell(State.DEAD,1,0)).nextIteration())
//                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0), new Cell(State.DEAD, 1,0)));
//    }
}
