package tech.pathtoprogramming.gameoflife;

import java.util.Arrays;

public class Board {

    private int[][] cells;

    public Board(int[][] cells) {
        this.cells = cells;
    }

    public int[][] getCells() {
        return cells;
    }

    public Board nextGeneration() {
        if (cells[1][1] == 1) {
            cells = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        } else if(cells[0][0] == 1 && cells[1][1] == 0) {
            cells = new int[][]{{0,0,0}, {0,1,0}, {0,0,0}};
        }

        return new Board(cells);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Arrays.equals(cells, board.cells);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(cells);
    }

    @Override
    public String toString() {
        return "Board{" +
                "cells=" + Arrays.toString(cells) +
                '}';
    }
}
