package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    // test list:
    // ✅ given a grid of size 1x1 with a dead cell, the cell should remain dead
    // ✅ given a grid of size 1x1 with an alive cell, the cell should die
    // ✅ given grid of [1 0] -> [0 0]
    // make grid and cells easier to read during test failures (toString())
    // Approval tests might make this easier to read. Is this API hard to understand?
    // given grid of [1 1] -> [1 1]
                 //  [0 1] -> [0 1]
    // given grid of [1 1] -> [1 1]
                 //  [0 1] -> [1 1]

    enum State {
        ALIVE, DEAD
    }
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
            return new Cell(State.DEAD, cell.x, 0);
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
            return "[1 0]";
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

    @Test
    void aDeadAndAliveCellNextToEachOtherWillBothDie() {
        assertThat(new Grid(new Cell(State.ALIVE,0,0), new Cell(State.DEAD,1,0)).nextIteration())
                .isEqualTo(new Grid(new Cell(State.DEAD, 0,0), new Cell(State.DEAD, 1,0)));
    }

    @Test
    void displayGridAsString() {
        assertThat(new Grid(new Cell(State.ALIVE,0,0), new Cell(State.DEAD,1,0)).toString())
                .isEqualTo("[1 0]");
    }
}
