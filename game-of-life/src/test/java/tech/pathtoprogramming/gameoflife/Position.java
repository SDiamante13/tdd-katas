package tech.pathtoprogramming.gameoflife;

public record Position(int x, int y) {

    int neighbors() {
        return 3;
    }
}
