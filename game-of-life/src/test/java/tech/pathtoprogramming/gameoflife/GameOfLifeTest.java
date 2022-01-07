package tech.pathtoprogramming.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameOfLifeTest {

    int[][] empty = new int[][]{
        {0, 0, 0},
        {0, 0, 0},
        {0, 0, 0}
    };

    @Test
    void nextGeneration_returnsNewBoard() {
        Board board = new Board(empty);

        Board nextBoard = board.nextGeneration();

        assertThat(nextBoard).isNotNull();
    }

    @Test
    void aBoardWithOneDeadCell_returnsABoardWithOneDeadCell() {
        Board board = new Board(empty);
        int[][] expected = new int[][]{
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        Board nextBoard = board.nextGeneration();

        assertThat(nextBoard.getCells()).isEqualTo(expected);
    }

    @Test
    void aBoardWithDiagonalAlive() {
        Board board = new Board(new int[][]{
                {0, 0, 1},
                {0, 1, 0},
                {1, 0, 0}
        });
        int[][] expected = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Board nextBoard = board.nextGeneration();


        assertThat(nextBoard.getCells()).isEqualTo(expected);
    }

    @Test
    void ifDeadCellHas3Neighbors_comesAlive() {
        Board board = new Board(new int[][]{
                {1, 0, 0},
                {0, 0, 1},
                {1, 0, 0}
        });
        int[][] expected = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        Board nextBoard = board.nextGeneration();


        assertThat(nextBoard.getCells()).isEqualTo(expected);
    }
}
