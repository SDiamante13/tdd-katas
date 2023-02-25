package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class GridTest {

    private static final Cell[][] O =
    new Cell[][]{{new Cell(State.ALIVE)}};
    private static final Cell[][] X =
    new Cell[][]{{new Cell(State.DEAD)}};

    @Test
    void gridWith1LiveCellBecomesDeadCell() {
        Grid grid = new Grid(O);

        grid.update();

        assertThat(grid.cells())
                .isDeepEqualTo(X);
    }

    // need to know how many live neighbors a cell has
    // then can call cell.updateState(numberOfLiveNeighbors)
}

