package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GridTest {

    // test list

    // - ZOMBIES
    // - zero
    // - one

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

