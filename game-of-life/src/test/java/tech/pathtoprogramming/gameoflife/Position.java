package tech.pathtoprogramming.gameoflife;

public record Position(int x, int y) {

    int countNeighbors() {
        return 3;
    }
}
