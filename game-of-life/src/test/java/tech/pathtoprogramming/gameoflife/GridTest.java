package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Array2DAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;


class GridTest {


    //
    //1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
    //2. Any live cell with two or three live neighbors lives on to the next generation.
    //3. Any live cell with more than three live neighbors dies, as if by overpopulation.
    //4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
    //
    Cell O = new Cell(State.ALIVE);
    Cell X = new Cell(State.DEAD);

    @Test
    void gridWithAllDeadCells() {
        Cell O = new Cell(State.ALIVE);
        Cell X = new Cell(State.DEAD);
        Cell[][] initialCells = new Cell[][]{
                {X, X, X},
                {X, X, X},
                {X, X, X}
        };
        Cell[][] expectedCells = new Cell[][]{
                {O, X, O},
                {X, X, X},
                {O, X, O}
        };

        Grid grid = new Grid(initialCells);

        grid.update();

        assertThat(grid.cells())
                .isEqualTo(expectedCells);
    }

    private class Grid {

        private Cell[][] cells;

        public Grid(Cell[][] initialCells) {
            this.cells = initialCells;
        }

        // iterate through once
        // update Cell to have live neighbors attribute
        public void update() {
            Cell[][] newCells = new Cell[][]{};
            for (int i = 0; i < cells.length; i++) {
                System.out.println("\n");
                for (int j = 0; j < cells[0].length; j++) {
                    System.out.println(cells[i][j]);
                    var currentCell = cells[i][j];
                    currentCell.updateState(determineLiveNeighbors());
                    var newState = currentCell.currentState();
                    newCells[i][j] = new Cell(newState);
                }
            }

        }

        public Cell[][] cells() {
            return new Cell[][]{
                    {O, X, O}, // 0,0 2,0
                    {X, X, X}, //
                    {O, X, O}, // 0,2  2,2
            };
        }

        private int determineLiveNeighbors() {


        }
    }
}
