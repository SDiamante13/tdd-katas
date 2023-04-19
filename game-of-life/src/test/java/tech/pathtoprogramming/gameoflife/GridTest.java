package tech.pathtoprogramming.gameoflife;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @CsvSource(value = {
            "O,X",
            "OO,XX",
            "OX,XX"
    })
    void updateGrid(String initialCells, String expectedUpdatedCells) {
        Grid grid = new Grid(initialCells);

        grid.update();

        assertThat(grid.cells())
                .isEqualTo(expectedUpdatedCells);
    }

    @Test
    @Disabled
    void update2DGrid() {
        Grid grid = new Grid("XX\nXX");

        grid.update();

        assertThat(grid.cells())
                .isEqualTo("XX\nXX");
    }

    // need to know how many live neighbors a cell has
    // then can call cell.updateState(numberOfLiveNeighbors)

    //XX
    //XX
    //becomes
    // XX
    // XX
}

