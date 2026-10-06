package tech.pathtoprogramming.gameoflife;

enum State {
    ALIVE, DEAD;

    String asString() {
        return equals(ALIVE) ? "1" : "0";
    }
}
