package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GridTest {

    // test list

    // - ZOMBIES
    // - zero
    // - one

    private static final Cell[][] O =
    new Cell[][]{{new Cell(State.ALIVE)}};
    private static final Cell[][] X =
    new Cell[][]{{new Cell(State.DEAD)}};


    @Test
    void creatingAnEmptyGridThrowsAnIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> new Grid(""));
    }

    @Test
    void gridWith1LiveCellBecomesDeadCell() {
        Grid grid = new Grid("O");

        grid.update();

        assertThat(grid.cells())
                .isEqualTo("X");
    }

    // need to know how many live neighbors a cell has
    // then can call cell.updateState(numberOfLiveNeighbors)
}

